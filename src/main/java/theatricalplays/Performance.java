package theatricalplays;

public class Performance {

  public Play play;
  public int audience;

  public Performance(Play play, int audience) {
    this.play = play;
    this.audience = audience;
  }

  public float getAmount() {
    return this.play.calculateAmount(this.audience);
  }

  public int getVolumeCredits() {
    return this.play.calculateVolumeCredits(this.audience);
  }
}
