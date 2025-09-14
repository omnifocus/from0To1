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
        List<BankTransaction> bankTransactions = BankStatementCSVParser.parseCsv(Files.readAllLines(RESOURCES));
        BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);
        collectSummary(bankStatementProcessor);

    }

    private static void collectSummary(BankStatementProcessor bankStatementProcessor) {
        System.out.println("The total for all transaction is " + bankStatementProcessor.calculateTotalAmount());
        System.out.println("The total for transactions in Jan is " + bankStatementProcessor.selectInMonth(Month.JANUARY));
        System.out.println("The total for transactions in Feb is " + bankStatementProcessor.selectInMonth(Month.FEBRUARY));
        System.out.println("The total salary received is" + bankStatementProcessor.calculateTotalForCatogory("Salary"));
    }


}
