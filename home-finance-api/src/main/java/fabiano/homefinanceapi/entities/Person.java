package fabiano.homefinanceapi.entities;

import jakarta.persistence.*;

@Entity()
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private int age;
}
