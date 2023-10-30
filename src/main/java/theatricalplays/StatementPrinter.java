package theatricalplays;

import java.text.NumberFormat;
import java.util.Locale;

public class StatementPrinter {

  public String printTXT(Invoice invoice) {
    InvoiceData invoiceData = invoice.getData();

    NumberFormat frmt = NumberFormat.getCurrencyInstance(Locale.US);

    StringBuilder result = new StringBuilder(String.format("Statement for %s\n", invoiceData.customerName));

    for (int i = 0; i < invoiceData.performances.length; i++) {
      result.append(String.format("  %s: %s (%s seats)\n", invoiceData.performances[i].playName, frmt.format(invoiceData.performances[i].amount), invoiceData.performances[i].audience));
    }
    result.append(String.format("Amount owed is %s\n", frmt.format(invoiceData.totalAmount)));
    result.append(String.format("You earned %s credits\n", invoiceData.totalVolumeCredits));

    return result.toString();
  }

  public String printHTML(Invoice invoice) {
    InvoiceData invoiceData = invoice.getData();

    NumberFormat frmt = NumberFormat.getCurrencyInstance(Locale.US);

    StringBuilder result = new StringBuilder(String.format("<h1>Statement for %s</h1>\n", invoiceData.customerName));

    result.append("<table border='1'>\n");
    result.append("  <tr><th>play</th><th>seats</th><th>price</th></tr>\n");
    for (int i = 0; i < invoiceData.performances.length; i++) {
      result.append(String.format("  <tr><td>%s</td><td>%s</td><td>%s</td></tr>\n", invoiceData.performances[i].playName, invoiceData.performances[i].audience, frmt.format(invoiceData.performances[i].amount)));
    }
    result.append("</table>\n");
    result.append(String.format("<p>Amount owed is <em>%s</em></p>\n", invoiceData.totalAmount));
    result.append(String.format("<p>You earned <em>%s</em> credits</p>\n", invoiceData.totalVolumeCredits));

    return result.toString();
  }
}
