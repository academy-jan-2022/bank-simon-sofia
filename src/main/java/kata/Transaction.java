package kata;

import java.util.Date;

public record Transaction(Money amount, Date time, int currentBalance) {
}
