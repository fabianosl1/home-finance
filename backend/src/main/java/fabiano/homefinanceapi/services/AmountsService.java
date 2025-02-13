package fabiano.homefinanceapi.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import fabiano.homefinanceapi.entities.TransactionsAmounts;
import fabiano.homefinanceapi.enums.TransactionType;

/*
 * Serviço responsavel por calcular os totais das transações
 * 
 * minha primeira implementação era O(n^2) pois para cada person ele percorria o array de transactions.
 * 
 * - Acredito que essa seja mais performatica pois gera um hashMap dos valores (personId : valores).
 * - O calculo total tbm é gerado na API, sendo possivel adicionar cache.
 */
@Service
@RequiredArgsConstructor
@Log4j2
public class AmountsService {

    private final TransactionService transactionService;

    public Map<Long, TransactionsAmounts> getAmountsMap() {
        Map<Long, TransactionsAmounts> map = new HashMap<>();

        var transactions = transactionService.listAll();

        for (var transaction : transactions) {
            long key = transaction.getPerson().getId();
            var balance = map.getOrDefault(key, new TransactionsAmounts());

            try {
                balance.add(transaction);
                map.put(key, balance);
            } catch (IllegalStateException exception) {
                log.info(exception.getMessage() + " transaction id: " + transaction.getId());
            }
        }

        return map;
    }

    public TransactionsAmounts calculateAmounts(List<TransactionsAmounts> amounts) {
        var amount = new TransactionsAmounts();

        for (var balance : amounts) {
            amount.add(balance.getIncomes(), TransactionType.INCOME);
            amount.add(balance.getExpenses(), TransactionType.EXPENSE);
        }

        return amount;
    }
}
