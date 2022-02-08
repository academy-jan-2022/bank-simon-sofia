package kata;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MemoryTransactionRepository implements TransactionRepository {

    List<Transaction> transactions = new ArrayList<>();
    private final DateProviderService dateProvider;
    private Money balance = new Money(0);

    public MemoryTransactionRepository(DateProviderService dateProvider) {
        this.dateProvider = dateProvider;
    }

    @Override
    public void add(Money money) {
        balance = new Money(getBalance() + money.amount());
        transactions.add(new Transaction(money, dateProvider.getNow(), getBalance()));
    }

    @Override
    public List<Transaction> getTransactions() {
        Collections.reverse(transactions);
        return transactions;
    }

    @Override
    public int getBalance() {
        return balance.amount();
    }
}
