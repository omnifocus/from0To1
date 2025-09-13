import javax.swing.text.DateFormatter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class BankTransactionAnalyzerSimple {
    public static void main(String[] args) throws IOException {
        /**
         * What is the total profit and loss from a list of bank statements? Is it positive or negative?
         */
        final Path RESOURCES = Paths.get(args[0]);
        final List<String> lines = Files.readAllLines(RESOURCES);
        Double sum = 0.0;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        for (String line : lines) {
            String[] lineArr = line.split(",");
            LocalDate date = LocalDate.parse(lineArr[0],formatter);
            if (date.getMonth() == Month.JANUARY) {
                double value = Double.parseDouble(lineArr[1]);
                sum += value;

            }
        }
        System.out.println("sum:" + sum);
    }


}
