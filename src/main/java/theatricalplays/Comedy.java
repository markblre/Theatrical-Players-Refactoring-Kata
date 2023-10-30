package theatricalplays;

public class Comedy extends Play {

  public static final int BASE_AMOUNT = 300;
  public static final int BASE_COST_PER_AUDIENCE = 3;
  public static final int BASE_AUDIENCE = 20;
  public static final int BASE_AUDIENCE_EXTRA_COST = 100;
  public static final int EXTRA_COST_PER_AUDIENCE = 5;
  public static final int BASE_AUDIENCE_FOR_CREDITS = 30;

  public Comedy(String name) {
    super(name);
  }

  @Override
  public float calculateAmount(int audience) {
    int amount = BASE_AMOUNT;
    if (audience > BASE_AUDIENCE) {
      amount += BASE_AUDIENCE_EXTRA_COST + EXTRA_COST_PER_AUDIENCE * (audience - BASE_AUDIENCE);
    }
    amount += BASE_COST_PER_AUDIENCE * audience;
    return amount;
  }

  @Override
  public int calculateVolumeCredits(int audience) {
    int volumeCredits = 0;
    volumeCredits += Math.max(audience - BASE_AUDIENCE_FOR_CREDITS, 0);
    volumeCredits += Math.floor(audience / 5);
    return volumeCredits;
  }
}
