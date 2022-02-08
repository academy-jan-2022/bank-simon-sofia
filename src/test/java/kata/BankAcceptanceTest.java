package kata;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BankAcceptanceTest {
    /*
Given a client makes a deposit of 1000 on 10-01-2012
And a deposit of 2000 on 13-01-2012
And a withdrawal of 500 on 14-01-2012
When they print their bank statement
Then they would see:

Date       || Amount || Balance
14/01/2012 || -500   || 2500
13/01/2012 || 2000   || 3000
10/01/2012 || 1000   || 1000
     */
    @Test void
    shouldPrintDesiredTransactions() throws ParseException {
        final ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        String expectedOutput= "Date || Amount || Balance\n" +
            "14/01/2012 || -500 || 2500\n" +
            "13/01/2012 || 2000 || 3000\n" +
            "10/01/2012 || 1000 || 1000\n";

     /*   DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date expectedDate = formatter.parse("2012-01-10");
        when(dateProvider.getNow()).thenReturn(expectedDate);*/


        /*
        var timeProviderMock = new Mock<ITimeProvider>();
        var count = 0;
        timeProviderMock.Setup(tp => tp.Now())
            .Returns(() =>
            {
                count++;
        if (count == 1)
            return new DateTime(2012, 01, 10);
        if (count == 2)
            return new DateTime(2012, 01, 13);
        return new DateTime(2012, 01, 14);
            });*/

        var timeProviderMock =  mock(DateProviderService.class);
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date expectedDate = formatter.parse("2012-01-10");
        Date expectedDate2 = formatter.parse("2012-01-13");
        Date expectedDate3 = formatter.parse("2012-01-14");

        when(timeProviderMock.getNow()).thenReturn(expectedDate).thenReturn(expectedDate2).thenReturn(expectedDate3);

        var account = new Account(new MemoryTransactionRepository(timeProviderMock));
        account.deposit(1000);
        account.deposit(2000);
        account.withdraw(500);
        account.print();

        assertEquals(expectedOutput, output.toString());
    }
}
