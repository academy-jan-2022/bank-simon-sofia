package kata;

import java.util.List;

public interface TransactionRepository {
    void add(Money amount);
    List<Transaction> getTransactions();
}
