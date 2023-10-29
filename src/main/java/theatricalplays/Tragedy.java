package theatricalplays;

public class Tragedy extends Play {

  public Tragedy(String name) {
    super(name);
  }

  @Override
  public float calculateAmount(int audience) {
    int amount = 400;
    if (audience > 30) {
      amount += 10 * (audience - 30);
    }
    return amount;
  }

  @Override
  public int calculateVolumeCredits(int audience) {
    int volumeCredits = 0;
    volumeCredits += Math.max(audience - 30, 0);
    return volumeCredits;
  }
}
