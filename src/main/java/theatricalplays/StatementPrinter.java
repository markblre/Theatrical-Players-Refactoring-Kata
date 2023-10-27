package theatricalplays;

import java.text.NumberFormat;
import java.util.Locale;

public class StatementPrinter {

  public String printTXT(Invoice invoice) {
    int totalAmount = 0;
    int volumeCredits = 0;
    String result = String.format("Statement for %s\n", invoice.customer);

    NumberFormat frmt = NumberFormat.getCurrencyInstance(Locale.US);

    for (Performance perf : invoice.performances) {
      int thisAmount = perf.getAmount();
      volumeCredits += perf.getVolumeCredits();

      // print line for this order
      result += String.format("  %s: %s (%s seats)\n", perf.play.name, frmt.format(thisAmount / 100), perf.audience);
      totalAmount += thisAmount;
    }
    result += String.format("Amount owed is %s\n", frmt.format(totalAmount / 100));
    result += String.format("You earned %s credits\n", volumeCredits);
    return result;
  }

}
