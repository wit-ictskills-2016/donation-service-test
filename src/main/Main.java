package main;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import app.donation.api.DonationServiceAPI;
import app.donation.model.Candidate;
import app.donation.model.Donation;
import app.donation.model.User;

public class Main
{
  public static void println(String s)
  {
    System.out.println(s);
  }

  public static void main(String[] args) throws Exception
  {
    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    DonationServiceAPI service = new DonationServiceAPI("http://localhost:4000");
    List<Candidate> candidates = service.getAllCandidates();
    List<User> users = service.getUsers();
    List<Donation> donations = service.getAllDonations();
    
    println ("--------------------");
    println ("  all users: ");
    println ("--------------------");
    println(gson.toJson(users));
    println ("--------------------");
    println ("  all candidates: ");
    println ("--------------------");
    println(gson.toJson(candidates));
    println ("--------------------");
    println ("  all donations: ");
    println ("--------------------");
    println(gson.toJson(donations));
  }
}
