package kata;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AccountShould {

    @Test
    void
    should_store_one_transaction() {
        TransactionRepository transactionRepository = mock(TransactionRepository.class);
        var account = new Account(transactionRepository);
        account.deposit(100);
        verify(transactionRepository).add(new Money(100));
    }

    @Test
    void
    should_store_a_withdraw() {
        TransactionRepository transactionRepository = mock(TransactionRepository.class);
        var account = new Account(transactionRepository);
        account.withdraw(10);
        verify(transactionRepository).add(new Money(-10));
    }

    @Test
    void
    should_print_a_transaction() throws ParseException {
        final ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        String expectedOutput= "Date || Amount || Balance\n" +
            "10/01/2012 || 10 || 10\n";

        DateProviderService dateProvider = mock(DateProviderService.class);
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date expectedDate = formatter.parse("2012-01-10");
        when(dateProvider.getNow()).thenReturn(expectedDate);
        var account = new Account(new MemoryTransactionRepository(dateProvider));
        account.deposit(10);
        account.print();
        assertEquals(expectedOutput, output.toString());
    }
}
