package kata;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MemoryTransactionRepositoryShould {
    @Test
    void
    store_a_transaction_in_the_given_date() {
        DateProvider dateProvider = mock(DateProvider.class);
        Date expectedDate = new GregorianCalendar(2017, Calendar.JANUARY, 1).getTime();
        when(dateProvider.getNow()).thenReturn(expectedDate);
        var repository = new MemoryTransactionRepository(dateProvider);
        repository.add(100);
        List<Transaction> transactions = repository.getTransactions();
        var expected = List.of(
            new Transaction(
                100,
                expectedDate)
        );
        assertEquals(expected, transactions);
    }
}
