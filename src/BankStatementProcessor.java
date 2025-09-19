import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankStatementProcessor {
    private final List<BankTransaction> bankTransactions;

    public BankStatementProcessor(List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    public  double calculateTotalAmount()  {
        Double sum = 0d;
        for (BankTransaction bankTransaction: bankTransactions) {
            sum += bankTransaction.getAmount();
        }
        return sum;
    }

    public  double selectInMonth(final Month month) {
        Double sum = 0d;
        for (BankTransaction bankTransaction: bankTransactions) {
            if (bankTransaction.getDate().getMonth() == month) {
                sum += bankTransaction.getAmount();
            }
        }
        return sum;
    }

    public double calculateTotalForCatogory(final String category) {
        Double sum = 0d;
        for (BankTransaction bankTransaction: bankTransactions) {
            if (bankTransaction.getDesc().equals(category)) {
                sum += bankTransaction.getAmount();
            }
        }
        return sum;
    }

    public List<BankTransaction> findTransactionsGreaterThanEquals(double amount) {
        final List<BankTransaction> res = new ArrayList<>();
        for (BankTransaction transaction: bankTransactions) {
            if (transaction.getAmount() >= amount) {
                res.add(transaction);
            }
        }
        return res;
    }

    public List<BankTransaction> findTransactionsInMonth(Month month) {
        final List<BankTransaction> res = new ArrayList<>();
        for (BankTransaction transaction: bankTransactions) {
            if (transaction.getDate().getMonth() == month) {
                res.add(transaction);
            }
        }
        return res;
    }

}
