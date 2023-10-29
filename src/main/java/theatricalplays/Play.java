package theatricalplays;

abstract public class Play {

  public String name;

  public Play(String name) {
    this.name = name;
  }

  abstract public float calculateAmount(int audience);
  abstract public int calculateVolumeCredits(int audience);
}
