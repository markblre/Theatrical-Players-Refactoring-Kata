package theatricalplays;

import java.text.NumberFormat;
import java.util.Locale;

public class StatementPrinter {

  public String printTXT(Invoice invoice) {
    InvoiceData invoiceData = invoice.getData();

    StringBuilder result = new StringBuilder();

    result.append(String.format("Statement for %s\n", invoiceData.customerName));

    NumberFormat frmt = NumberFormat.getCurrencyInstance(Locale.US);
    for (int i = 0; i < invoiceData.performances.length; i++) {
      result.append(String.format("  %s: %s (%s seats)\n", invoiceData.performances[i].playName, frmt.format(invoiceData.performances[i].amount), invoiceData.performances[i].audience));
    }
    result.append(String.format("Amount owed is %s\n", frmt.format(invoiceData.totalAmount)));
    result.append(String.format("You earned %s credits\n", invoiceData.totalVolumeCredits));

    return result.toString();
  }

}
