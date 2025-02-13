package fabiano.homefinanceapi.repositories;

import fabiano.homefinanceapi.entities.Transaction;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
