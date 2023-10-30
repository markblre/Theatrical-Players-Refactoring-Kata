package theatricalplays;

public class Tragedy extends Play {

  public static final int BASE_AMOUNT = 400;
  public static final int BASE_AUDIENCE = 30;
  public static final int EXTRA_COST_PER_AUDIENCE = 10;

  public Tragedy(String name) {
    super(name);
  }

  @Override
  public float calculateAmount(int audience) {
    int amount = BASE_AMOUNT;
    if (audience > BASE_AUDIENCE) {
      amount += EXTRA_COST_PER_AUDIENCE * (audience - BASE_AUDIENCE);
    }
    return amount;
  }

  @Override
  public int calculateVolumeCredits(int audience) {
    int volumeCredits = 0;
    volumeCredits += Math.max(audience - BASE_AUDIENCE, 0);
    return volumeCredits;
  }
}
