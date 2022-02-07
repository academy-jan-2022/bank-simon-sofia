package kata;

import java.util.List;

public interface TransactionRepository {
    void add(int amount);
    List<Transaction> getTransactions();
}
