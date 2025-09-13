import javax.swing.text.DateFormatter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BankTransactionAnalyzerSimple {

    public static void main(String[] args) throws IOException {
        final Path RESOURCES = Paths.get(args[0]);

    }

    public static double calculateTotalAmount(final List<BankTransaction> bankTransactions)  {
        Double sum = 0d;
        for (BankTransaction bankTransaction: bankTransactions) {
                sum += bankTransaction.getAmount();
        }
        return sum;
    }

    public static List<BankTransaction> selectInMonth(final List<BankTransaction> bankTransactions, final Month month) {
        List<BankTransaction> ans = new ArrayList<>();
        for (BankTransaction bankTransaction: bankTransactions) {
            if (bankTransaction.getDate().getMonth() == month) {
                ans.add(bankTransaction);
            }
        }
        return ans;
    }


}
