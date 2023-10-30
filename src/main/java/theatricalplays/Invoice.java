package theatricalplays;

import java.util.List;

public class Invoice {

  public Customer customer;
  public List<Performance> performances;

  public Invoice(Customer customer, List<Performance> performances) {
    this.customer = customer;
    this.performances = performances;
  }

  private float calculateDiscount() {
    if (this.customer.credits >= 150) {
      this.customer.credits -= 150;
      return 15f;
    } else {
      return 0f;
    }
  }

  public InvoiceData getData() {
    InvoiceData invoiceData = new InvoiceData();
    invoiceData.customerName = this.customer.name;
    invoiceData.customerCreditsBefore = this.customer.credits;
    invoiceData.performances = new PerformanceData[this.performances.size()];
    for (int i = 0; i < this.performances.size(); i++) {
      invoiceData.performances[i] = this.performances.get(i).getData();
    }
    invoiceData.subtotalAmount = 0;
    invoiceData.totalVolumeCredits = 0;
    for (PerformanceData perf : invoiceData.performances) {
      invoiceData.subtotalAmount += perf.amount;
      invoiceData.totalVolumeCredits += perf.volumeCredits;
    }
    this.customer.credits += invoiceData.totalVolumeCredits;
    invoiceData.discount = calculateDiscount();
    invoiceData.customerCreditsAfter = this.customer.credits;
    invoiceData.totalAmount = invoiceData.subtotalAmount - invoiceData.discount;
    return invoiceData;
  }
}
