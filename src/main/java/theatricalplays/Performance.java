package theatricalplays;

public class Performance {

  public Play play;
  public int audience;

  public Performance(Play play, int audience) {
    this.play = play;
    this.audience = audience;
  }

  public PerformanceData getData() {
    PerformanceData data = new PerformanceData();
    data.playName = this.play.name;
    data.playType = this.play.getClass().getSimpleName();
    data.audience = this.audience;
    data.amount = this.getAmount();
    data.volumeCredits = this.getVolumeCredits();
    return data;
  }

  private float getAmount() {
    return this.play.calculateAmount(this.audience);
  }

  private int getVolumeCredits() {
    return this.play.calculateVolumeCredits(this.audience);
  }
}
