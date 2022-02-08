package kata;


import java.util.ArrayList;
import java.util.List;

public class MemoryTransactionRepository implements TransactionRepository {


    List<Transaction> transactions = new ArrayList<>();
    private final DateProviderService dateProvider;

    public MemoryTransactionRepository(DateProviderService dateProvider) {
        this.dateProvider = dateProvider;
    }

    @Override
    public void add(Money amount) {
        transactions.add(new Transaction(amount, dateProvider.getNow()));
    }

    @Override
    public List<Transaction> getTransactions() {
        return transactions;
    }
}
