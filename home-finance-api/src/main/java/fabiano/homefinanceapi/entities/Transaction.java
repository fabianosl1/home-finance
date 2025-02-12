package fabiano.homefinanceapi.entities;


import fabiano.homefinanceapi.enums.TransactionType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Getter
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Setter
    private String description;

    @Setter
    private double amount;

    @Setter
    private TransactionType type;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @Setter
    private Person person;
}
