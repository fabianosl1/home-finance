package fabiano.homefinanceapi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;

import fabiano.homefinanceapi.dtos.CreatePersonRequest;
import fabiano.homefinanceapi.dtos.CreatePersonResponse;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PersonsTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void when_create_person_then_ok() {
        var body = CreatePersonRequest.builder()
                .name("person")
                .age(0)
                .build();

        var response = restTemplate.postForEntity("/persons", body, CreatePersonResponse.class);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    public void when_empty_name_then_bad_request() {
        var body = CreatePersonRequest.builder()
                .name("")
                .age(18)
                .build();

        var response = restTemplate.postForEntity("/persons", body, CreatePersonResponse.class);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }


    @Test
    public void when_invalid_age_then_bad_request() {
        var body = CreatePersonRequest.builder()
                .name("person")
                .age(-1)
                .build();

        var response = restTemplate.postForEntity("/persons", body, CreatePersonResponse.class);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }
}
