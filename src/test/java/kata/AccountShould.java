package kata;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class AccountShould {

    @Test
    void
    should_store_one_transaction_the_first_of_january_2017() {
        TransactionRepository transactionRepository = mock(TransactionRepository.class);
        var account = new Account(transactionRepository);
        account.deposit(100);
        Date expectedTime = new GregorianCalendar(
            2017,
            Calendar.JANUARY,
            1
        ).getTime();
        verify(transactionRepository).add(100, expectedTime);
    }
}
