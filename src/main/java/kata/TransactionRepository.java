package kata;

import java.util.Date;

public interface TransactionRepository {
    void add(int amount, Date date);
}
