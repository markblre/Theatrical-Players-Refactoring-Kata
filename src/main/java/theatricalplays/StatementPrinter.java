package theatricalplays;

import java.text.NumberFormat;
import java.util.Locale;

public class StatementPrinter {

  public String printTXT(InvoiceData invoiceData) {

    NumberFormat frmt = NumberFormat.getCurrencyInstance(Locale.US);

    StringBuilder result = new StringBuilder(String.format("Statement for %s\n", invoiceData.customerName));

    for (int i = 0; i < invoiceData.performances.length; i++) {
      result.append(String.format("  %s: %s (%s seats)\n", invoiceData.performances[i].playName, frmt.format(invoiceData.performances[i].amount), invoiceData.performances[i].audience));
    }
    result.append(String.format("Subtotal: %s\n", frmt.format(invoiceData.subtotalAmount)));
    result.append(String.format("Previous credit balance: %s\n", invoiceData.customerCreditsBefore));
    result.append(String.format("You earned %s credits\n", invoiceData.totalVolumeCredits));
    if (invoiceData.discount > 0) {
      result.append(String.format("Discount: %s (-150 credits)\n", frmt.format(invoiceData.discount)));
    }
    result.append(String.format("New credit balance: %s\n", invoiceData.customerCreditsAfter));
    result.append(String.format("Total: %s\n", frmt.format(invoiceData.totalAmount)));

    return result.toString();
  }

  public String printHTML(InvoiceData invoiceData) {

    NumberFormat frmt = NumberFormat.getCurrencyInstance(Locale.US);

    StringBuilder result = new StringBuilder(String.format("<h1>Statement for %s</h1>\n", invoiceData.customerName));

    result.append("<table border='1'>\n");
    result.append("  <tr><th>play</th><th>seats</th><th>price</th></tr>\n");
    for (int i = 0; i < invoiceData.performances.length; i++) {
      result.append(String.format("  <tr><td>%s</td><td>%s</td><td>%s</td></tr>\n", invoiceData.performances[i].playName, invoiceData.performances[i].audience, frmt.format(invoiceData.performances[i].amount)));
    }
    result.append("</table>\n");

    result.append(String.format("<p>Subtotal: %s</p>\n", frmt.format(invoiceData.subtotalAmount)));
    result.append(String.format("<p>Previous credit balance: %s</p>\n", invoiceData.customerCreditsBefore));
    result.append(String.format("<p>You earned <em>%s</em> credits</p>\n", invoiceData.totalVolumeCredits));
    if (invoiceData.discount > 0) {
      result.append(String.format("<p>Discount: %s (-150 credits)</p>\n", frmt.format(invoiceData.discount)));
    }
    result.append(String.format("<p>New credit balance: %s</p>\n", invoiceData.customerCreditsAfter));
    result.append(String.format("<p>Total: <em>%s</em></p>\n", frmt.format(invoiceData.totalAmount)));

    return result.toString();
  }
}
