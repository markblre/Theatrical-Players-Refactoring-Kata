package theatricalplays;

public class Tragedy extends Play {

  public Tragedy(String name) {
    super(name);
  }

  @Override
  public int calculateAmount(int audience) {
    int amount = 40000;
    if (audience > 30) {
      amount += 1000 * (audience - 30);
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
