package fabiano.homefinanceapi.services;

import fabiano.homefinanceapi.entities.Transaction;
import fabiano.homefinanceapi.repositories.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public Transaction create() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void destroy(long id) {
        this.transactionRepository.deleteById(id);
    }

    public List<Transaction> findAll() {
       return this.transactionRepository.all();
    }
}
