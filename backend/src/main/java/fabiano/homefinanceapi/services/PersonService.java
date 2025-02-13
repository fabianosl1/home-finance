package fabiano.homefinanceapi.services;

import fabiano.homefinanceapi.dtos.CreatePersonRequest;
import fabiano.homefinanceapi.entities.Person;
import fabiano.homefinanceapi.exceptions.NotFoundException;
import fabiano.homefinanceapi.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public Person create(CreatePersonRequest createPersonRequest) {
        var person = createPersonRequest.makePerson();
        return personRepository.save(person);
    }

    public Person findById(Long id) {
        var person = personRepository.findById(id);

        if (person.isEmpty()) {
            throw new NotFoundException("pessoa não encontrada");
        }

        return person.get();
    }

    public void destroy(long personId) {
        this.findById(personId);
        personRepository.deleteById(personId);
    }

    public List<Person> listAll() {
        var persons = this.personRepository.findAll();

        return Streamable.of(persons).toList();
    }
}
