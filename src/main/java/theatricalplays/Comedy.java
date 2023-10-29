package theatricalplays;

public class Comedy extends Play {

  public Comedy(String name) {
    super(name);
  }

  @Override
  public float calculateAmount(int audience) {
    int amount = 300;
    if (audience > 20) {
      amount += 100 + 5 * (audience - 20);
    }
    amount += 3 * audience;
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
