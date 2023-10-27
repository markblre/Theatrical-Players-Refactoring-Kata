package theatricalplays;

import java.util.List;

public class Invoice {

  public String customer;
  public List<Performance> performances;

  public Invoice(String customer, List<Performance> performances) {
    this.customer = customer;
    this.performances = performances;
  }

  public int getTotalAmount() {
    int totalAmount = 0;
    for (Performance perf : this.performances) {
      totalAmount += perf.getAmount();
    }
    return totalAmount;
  }

  public int getTotalVolumeCredits() {
    int totalVolumeCredits = 0;
    for (Performance perf : this.performances) {
      totalVolumeCredits += perf.getVolumeCredits();
    }
    return totalVolumeCredits;
  }
}
