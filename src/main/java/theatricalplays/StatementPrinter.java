package theatricalplays;

import java.text.NumberFormat;
import java.util.Locale;

public class StatementPrinter {

  public String printTXT(Invoice invoice) {
    String result = String.format("Statement for %s\n", invoice.customer);

    NumberFormat frmt = NumberFormat.getCurrencyInstance(Locale.US);

    for (Performance perf : invoice.performances) {
      // print line for this order
      result += String.format("  %s: %s (%s seats)\n", perf.play.name, frmt.format(perf.getAmount() / 100), perf.audience);
    }
    result += String.format("Amount owed is %s\n", frmt.format(invoice.getTotalAmount() / 100));
    result += String.format("You earned %s credits\n", invoice.getTotalVolumeCredits());
    return result;
  }

}
