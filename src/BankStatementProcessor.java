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
}
