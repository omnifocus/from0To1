import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BankStatementCSVParser {

    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static BankTransaction parseLine(String line) {
        final String[] arr = line.split(",");
        final LocalDate date = LocalDate.parse(arr[0],dateTimeFormatter);
        final double amount = Double.parseDouble(arr[1]);
        final String desc = arr[2];
        return new BankTransaction(date,amount,desc);
    }

    public static List<BankTransaction> parseCsv(final List<String> lines) {
       final List<BankTransaction> list = new ArrayList<>();
        for (final String line: lines) {
            list.add(parseLine(line));
        }
        return list;
    }
}
