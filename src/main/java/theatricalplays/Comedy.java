package theatricalplays;

public class Comedy extends Play {

  public Comedy(String name) {
    super(name);
  }

  @Override
  public int calculateAmount(int audience) {
    int amount = 30000;
    if (audience > 20) {
      amount += 10000 + 500 * (audience - 20);
    }
    amount += 300 * audience;
    return amount;
  }

  @Override
  public int calculateVolumeCredits(int audience) {
    int volumeCredits = 0;
    volumeCredits += Math.max(audience - 30, 0);
    volumeCredits += Math.floor(audience / 5);
    return volumeCredits;
  }
}
