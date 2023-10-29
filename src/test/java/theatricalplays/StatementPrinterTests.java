package theatricalplays;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.approvaltests.Approvals.verify;

public class StatementPrinterTests {

    @Test
  void exampleStatement() {
    Customer BigCo = new Customer("BigCo");

    Play Hamlet = new Tragedy("Hamlet");
    Play AsYouLikeIt = new Comedy("As You Like It");
    Play Othello = new Tragedy("Othello");

    Invoice invoice = new Invoice(BigCo, List.of(
            new Performance(Hamlet, 55),
            new Performance(AsYouLikeIt, 35),
            new Performance(Othello, 40)));

    StatementPrinter statementPrinter = new StatementPrinter();
    var result = statementPrinter.printTXT(invoice);

    verify(result);
  }
}
