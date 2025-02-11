package fabiano.homefinanceapi.entities;


import fabiano.homefinanceapi.enums.TransactionType;
import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String describe;

    private double amount;

    private TransactionType type;

    @ManyToOne
    private Person person;
}
