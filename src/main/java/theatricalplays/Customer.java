package theatricalplays;

import java.util.UUID;

public class Customer {
  public String name;
  public UUID id;
  public int credits;

  public Customer(String name) {
    this.name = name;
    this.id = UUID.randomUUID();
    this.credits = 0;
  }
}
