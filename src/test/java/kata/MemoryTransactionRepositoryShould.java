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
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date expectedDate = formatter.parse("01-01-2017");
        when(dateProvider.getNow()).thenReturn(expectedDate);
        var repository = new MemoryTransactionRepository(dateProvider);
        repository.add(new Money(100));
        var balance = repository.getBalance();
        List<Transaction> transactions = repository.getTransactions();
        var expected = List.of(
            new Transaction(
                new Money(100),
                expectedDate,
                balance)
        );
        assertEquals(expected, transactions);
    }
}
