package app.donation.model;

public class DonationComplete
{
  public String   _id;
  public int    amount;
  public String method;
  public User donor;
  public Candidate candidate;

  public DonationComplete (int amount, String method)
  {
    this.amount = amount;
    this.method = method;
  }
}