package kata;

import java.util.Date;

public class MemoryTransactionRepository implements TransactionRepository {
    @Override
    public void add(int amount, Date date) {
        throw new UnsupportedOperationException();
    }
}
