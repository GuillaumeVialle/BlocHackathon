import java.util.*;

public class Donor {

    //donor ranking  system

    private String firstName;
    private String lastName;
    private String email;
    private String password;

    private double donated;
    private ArrayList<Integer> associatedRecievers;



    public Donor(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;

    }
    
    public Donor(String email, String password) {
    	this.email=email;
    	this.password=password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getDonated(){
        return donated;
    }

    public void addDonated(double toAdd) {
        donated += toAdd;
    }
}