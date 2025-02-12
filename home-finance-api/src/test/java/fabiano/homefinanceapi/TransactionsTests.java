package fabiano.homefinanceapi;

import fabiano.homefinanceapi.dtos.*;
import fabiano.homefinanceapi.enums.TransactionType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TransactionsTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void when_create_expense_with_age_greater_than_min_then_should_created() {
        var person = this.createPerson("person", 18);

        var body = CreateTransactionRequest.builder()
                .amount(10.50)
                .description("description")
                .type(TransactionType.EXPENSE)
                .build();

        var response = this.createTransaction(person.getId(), body);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    public void when_create_expense_with_age_less_than_min_then_should_created() {
        var person = this.createPerson("person 2", 15);

        var body = CreateTransactionRequest.builder()
                .amount(10.50)
                .description("description")
                .type(TransactionType.EXPENSE)
                .build();

        var response = this.createTransaction(person.getId(), body);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    public void when_create_income_with_age_less_than_min_then_should_bad_request() {
        var person = this.createPerson("person 2", 15);

        var body = CreateTransactionRequest.builder()
                .amount(10.50)
                .description("description")
                .type(TransactionType.INCOME)
                .build();

        var response = this.createTransaction(person.getId(), body);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    public void when_create_income_with_age_greater_than_min_then_should_bad_request() {
        var person = this.createPerson("person 2", 21);
        var body = CreateTransactionRequest.builder()
                .amount(10.50)
                .description("description")
                .type(TransactionType.INCOME)
                .build();

        var response = this.createTransaction(person.getId(), body);

        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    public void when_delete_user_then_delete_all_transactions() {
        var person = this.createPerson("person 2", 21);

        var transactionBody = CreateTransactionRequest.builder()
                .amount(10.50)
                .description("description")
                .type(TransactionType.INCOME)
                .build();

        var transactions = List.of(
            this.createTransaction(person.getId(), transactionBody),
            this.createTransaction(person.getId(), transactionBody),
            this.createTransaction(person.getId(), transactionBody)
        );



        restTemplate.delete("/persons/" + person.getId());

        var response = restTemplate.getForEntity("/transactions", ListTransactionsResponse.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());

        var listTransactions = response.getBody();

        assert listTransactions != null;


        for (var transaction : transactions) {
            assertEquals(HttpStatus.CREATED, transaction.getStatusCode());
            var bodyTransaction = transaction.getBody();
            assert bodyTransaction != null;

            var match = listTransactions.getTransactions()
                    .stream()
                    .filter(item -> item.getId() == bodyTransaction.getId())
                    .findFirst()
                    .orElse(null);

            assertNull(match);
        }

    }

    private ResponseEntity<CreateTransactionResponse> createTransaction(
            long personId,
            CreateTransactionRequest body
    ) {
        String path = "/persons/" + personId + "/transactions";
        return restTemplate.postForEntity(path, body, CreateTransactionResponse.class);
    }

    private CreatePersonResponse createPerson(String name, int age) {
        var body = CreatePersonRequest.builder().name(name).age(age).build();

        var response = restTemplate.postForEntity("/persons", body, CreatePersonResponse.class);

        return response.getBody();
    }
}
