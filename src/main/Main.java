package main;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import app.donation.api.DonationServiceAPI;
import app.donation.model.Candidate;
import app.donation.model.Donation;
import app.donation.model.DonationComplete;
import app.donation.model.User;

public class Main
{
  static Gson gson = new GsonBuilder().setPrettyPrinting().create();
  
  public static void println(Object o)
  {
    System.out.println(gson.toJson(o));
  }
  
  public static void println(String s)
  {
    System.out.println(s);
  }

  public static void main(String[] args) throws Exception
  {
    DonationServiceAPI service = new DonationServiceAPI("http://localhost:4000");
    List<Candidate> candidates = service.getAllCandidates();
    List<User> users = service.getUsers();
    List<Donation> donations = service.getAllDonations();
    
    println ("--------------------");
    println ("  all users: ");
    println ("--------------------");
    println(users);
    println ("--------------------");
    println ("  all candidates: ");
    println ("--------------------");
    println(candidates);
    println ("--------------------");
    println ("  all donations: ");
    println ("--------------------");
    println(donations);
    
    Donation donation = new Donation(5000, "paypal");
    service.createDonation(candidates.get(0), donation);
    donations = service.getAllDonations();
    println ("--------------------");
    println ("  all donations with a new donation created: ");
    println ("--------------------");
    println(donations);
    
    println ("--------------------");
    println ("  complete donations: ");
    println ("--------------------");
    List<DonationComplete> complateDonations = service.getAllCompleteDonations();
    println(complateDonations);
  }
}
