package kata;

import org.junit.jupiter.api.Test;

public class AccountShould {

    @Test
    void
    should_return_one_transaction() {
        var account = new Account();
        account.deposit(100);
        throw new UnsupportedOperationException();
    }
}
