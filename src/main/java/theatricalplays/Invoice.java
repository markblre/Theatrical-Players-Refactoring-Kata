package theatricalplays;

import java.util.List;

public class Invoice {

  public Customer customer;
  public List<Performance> performances;

  public Invoice(Customer customer, List<Performance> performances) {
    this.customer = customer;
    this.performances = performances;
  }

  public InvoiceData getData() {
    InvoiceData invoiceData = new InvoiceData();
    invoiceData.customerName = this.customer.name;
    invoiceData.performances = new PerformanceData[this.performances.size()];
    for (int i = 0; i < this.performances.size(); i++) {
      invoiceData.performances[i] = this.performances.get(i).getData();
    }
    invoiceData.totalAmount = 0;
    invoiceData.totalVolumeCredits = 0;
    for (PerformanceData perf : invoiceData.performances) {
      invoiceData.totalAmount += perf.amount;
      invoiceData.totalVolumeCredits += perf.volumeCredits;
    }
    return invoiceData;
  }
}
