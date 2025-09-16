import java.util.List;

public interface BankStatementParser {
    public  BankTransaction parseLine(String line) ;
    public  List<BankTransaction> parseLines(List<String> lines) ;

}
