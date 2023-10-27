package theatricalplays;

public class Performance {

  public Play play;
  public int audience;

  public Performance(Play play, int audience) {
    this.play = play;
    this.audience = audience;
  }

  public int getAmount() {
    int amount = 0;

    switch (play.type) {
      case "tragedy":
        amount = 40000;
        if (this.audience > 30) {
          amount += 1000 * (this.audience - 30);
        }
        break;
      case "comedy":
        amount = 30000;
        if (this.audience > 20) {
          amount += 10000 + 500 * (this.audience - 20);
        }
        amount += 300 * this.audience;
        break;
      default:
        throw new Error("unknown type: ${play.type}");
    }

    return amount;
  }

  public int getVolumeCredits() {
    int volumeCredits = 0;

    // add volume credits
    volumeCredits += Math.max(this.audience - 30, 0);
    // add extra credit for every ten comedy attendees
    if ("comedy".equals(play.type)) volumeCredits += Math.floor(this.audience / 5);

    return volumeCredits;
  }
}
