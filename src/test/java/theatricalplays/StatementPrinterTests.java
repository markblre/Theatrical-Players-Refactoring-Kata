package theatricalplays;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.approvaltests.Approvals.verify;

public class StatementPrinterTests {

    @Test
  void exampleStatement() {
    Customer BigCo = new Customer("BigCo");

    Play Hamlet = new Play("Hamlet", "tragedy");
    Play AsYouLikeIt = new Play("As You Like It", "comedy");
    Play Othello = new Play("Othello", "tragedy");

    Invoice invoice = new Invoice(BigCo, List.of(
            new Performance(Hamlet, 55),
            new Performance(AsYouLikeIt, 35),
            new Performance(Othello, 40)));

    StatementPrinter statementPrinter = new StatementPrinter();
    var result = statementPrinter.printTXT(invoice);

    verify(result);
  }
}
