import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankTransactionAnalyzerSimple {

    public static void main(String[] args) throws IOException, URISyntaxException {
        final BankStatementParser bankStatementParser = new BankStatementCSVParser();
        final Path RESOURCES = Paths.get(BankTransactionAnalyzerSimple.class.getResource(args[0]).toURI().getPath());
        List<BankTransaction> bankTransactions = bankStatementParser.parseLines(Files.readAllLines(RESOURCES));
        BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);
        collectSummary(bankStatementProcessor);

    }

    private static void collectSummary(BankStatementProcessor bankStatementProcessor) {
        System.out.println("The total for all transaction is " + bankStatementProcessor.calculateTotalAmount());
        System.out.println("The total for transactions in Jan is " + bankStatementProcessor.selectInMonth(Month.JANUARY));
        System.out.println("The total for transactions in Feb is " + bankStatementProcessor.selectInMonth(Month.FEBRUARY));
        System.out.println("The total salary received is " + bankStatementProcessor.calculateTotalForCatogory("Salary"));
    }


}
