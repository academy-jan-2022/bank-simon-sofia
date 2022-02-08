package kata;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Account {
    private final TransactionRepository transactionRepository;

    public Account(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public void deposit(int amount) {
        transactionRepository.add(new Money(amount));
    }

    public void withdraw(int amount) {
        transactionRepository.add(new Money(-amount));
    }

    public void print() {
        StringBuilder output = new StringBuilder("Date || Amount || Balance\n");

        var transactionsList = transactionRepository.getTransactions();
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        for (Transaction transaction : transactionsList) {
            Date date= transaction.time();
            String strDate = formatter.format(date);
            output.append(strDate)
                .append(" || ")
                .append(transaction.amount().amount())
                .append(" || ")
                .append(transaction.currentBalance())
                .append("\n");
        }

        System.out.print(output);
    }
}
