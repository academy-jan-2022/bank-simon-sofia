package kata;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MemoryTransactionRepositoryShould {
    @Test
    void
    store_a_transaction_in_the_given_date() throws ParseException {
        DateProviderService dateProvider = mock(DateProviderService.class);
        //Date expectedDate = new GregorianCalendar(2017, Calendar.JANUARY, 1).getTime();
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date expectedDate = formatter.parse("2017-01-01");
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
