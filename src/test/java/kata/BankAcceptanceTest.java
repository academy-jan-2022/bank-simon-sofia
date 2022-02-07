package kata;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
    shouldPrintDesiredTransactions(){
        final ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        String expectedOutput= "Date || Amount || Balance\n" +
            "14/01/2012 || -500   || 2500\n" +
            "13/01/2012 || 2000   || 3000\n" +
            "10/01/2012 || 1000   || 1000";

        var account = new Account(new MemoryTransactionRepository(new DateProviderGregorian()));
        account.deposit(1000);
        account.deposit(2000);
        account.withdraw(500);
        account.print();

        assertEquals(expectedOutput, output.toString());
    }
}
