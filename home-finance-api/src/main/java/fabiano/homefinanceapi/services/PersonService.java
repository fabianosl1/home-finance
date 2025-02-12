package fabiano.homefinanceapi.services;

import fabiano.homefinanceapi.dtos.CreatePersonRequest;
import fabiano.homefinanceapi.entities.Person;
import fabiano.homefinanceapi.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public Person create(CreatePersonRequest createPersonRequest) {
        if (createPersonRequest.getName() == null || createPersonRequest.getName().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Name cannot be empty");
        }

        if (createPersonRequest.getAge() < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Age cannot be negative");
        }

        var person = createPersonRequest.makePerson();
        return personRepository.save(person);
    }

    public Person findById(Long id) {
        var person = personRepository.findById(id);

        if (person.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Person not found");
        }

        return person.get();
    }

    public void destroy(long personId) {
        this.findById(personId);
        personRepository.deleteById(personId);
    }

    public List<Person> listAll() {
        return personRepository.all();
    }
}
