package kata;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AccountShould {

    @Test
    void
    should_store_one_transaction() {
        TransactionRepository transactionRepository = mock(TransactionRepository.class);
        var account = new Account(transactionRepository);
        account.deposit(100);
        verify(transactionRepository).add(100);
    }
}
