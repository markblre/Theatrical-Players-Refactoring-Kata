package theatricalplays;

import java.text.NumberFormat;
import java.util.Locale;

public class StatementPrinter {

  public String printTXT(Invoice invoice) {
    StringBuilder result = new StringBuilder();

    result.append(String.format("Statement for %s\n", invoice.customer.name));

    NumberFormat frmt = NumberFormat.getCurrencyInstance(Locale.US);

    for (Performance perf : invoice.performances) {
      result.append(String.format("  %s: %s (%s seats)\n", perf.play.name, frmt.format(perf.getAmount()), perf.audience));
    }
    result.append(String.format("Amount owed is %s\n", frmt.format(invoice.getTotalAmount())));
    result.append(String.format("You earned %s credits\n", invoice.getTotalVolumeCredits()));

    return result.toString();
  }

}
