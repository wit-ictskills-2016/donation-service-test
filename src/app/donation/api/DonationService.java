package app.donation.api;

import java.util.List;
import app.donation.model.Candidate;
import app.donation.model.Donation;
import app.donation.model.DonationComplete;
import app.donation.model.User;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface DonationService
{
  @GET("/api/users")
  Call<List<User>> getAllUsers();

  @GET("/api/users/{id}")
  Call<User> getUser(@Path("id") String id);

  @POST("/api/users")
  Call<User> createUser(@Body User User);

  @GET("/api/donations")
  Call<List<Donation>> getAllDonations();

  @GET("/api/donations")
  Call<List<DonationComplete>> getAllCompleteDonations();  
  
  @GET("/api/candidates")
  Call<List<Candidate>> getAllCandidates();

  @POST("/api/candidates/{id}/donations")
  Call<Donation> createDonation(@Path("id") String id, @Body Donation donation);
}