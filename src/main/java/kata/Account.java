package kata;

public class Account {
    private final TransactionRepository transactionRepository;

    public Account(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public void deposit(int amount) {
        transactionRepository.add(amount);
    }

    public void withdraw(int amount) {
        transactionRepository.add(-amount);
    }

    public void print() {
        throw new UnsupportedOperationException();
    }
}
