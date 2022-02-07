package kata;


import java.util.ArrayList;
import java.util.List;

public class MemoryTransactionRepository implements TransactionRepository {


    List<Transaction> transactions = new ArrayList<>();
    private final DateProvider dateProvider;

    public MemoryTransactionRepository(DateProvider dateProvider) {
        this.dateProvider = dateProvider;
    }

    @Override
    public void add(int amount) {
        transactions.add(new Transaction(amount, dateProvider.getNow()));
    }

    @Override
    public List<Transaction> getTransactions() {
        return transactions;
    }
}
