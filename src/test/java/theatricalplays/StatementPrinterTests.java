package theatricalplays;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.approvaltests.Approvals.verify;
import static org.approvaltests.Approvals.verifyHtml;

public class StatementPrinterTests {

    @Test
  void testTXTInvoice() {
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

  @Test
  void testHTMLInvoice() {
    Customer BigCo = new Customer("BigCo");

    Play Hamlet = new Tragedy("Hamlet");
    Play AsYouLikeIt = new Comedy("As You Like It");
    Play Othello = new Tragedy("Othello");

    Invoice invoice = new Invoice(BigCo, List.of(
      new Performance(Hamlet, 55),
      new Performance(AsYouLikeIt, 35),
      new Performance(Othello, 40)));

    StatementPrinter statementPrinter = new StatementPrinter();
    var result = statementPrinter.printHTML(invoice);

    verifyHtml(result);
  }
}
