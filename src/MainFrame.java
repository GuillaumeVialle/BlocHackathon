import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;
import javax.swing.*;

public class MainFrame {
	
	public static void addCategory(ArrayList<Transaction> transactions) {
		for (Transaction x : transactions) {
			String merchant = x.getMerchant();
			String city = x.getCity();
			
			//This step is only required on Windows. Comment out if running on Mac.
			//if (city.charAt(city.length()-2) < 1 || city.charAt(city.length()-2) > 26 ) city = city.substring(0, city.length() - 1);
			
			String category = REST.getCategory(merchant, city);
			
			x.setCategory(category);
		}
	}
	
	public static void sendSomewhere(String url) throws IOException, URISyntaxException {
		java.net.URI tester = new java.net.URI(url);
		java.awt.Desktop.getDesktop().browse(tester);
	}
	
	public static ArrayList<Category> getReport(ArrayList<Transaction> transactions){
		ArrayList<Category> budget = new ArrayList<Category>();
		
		for (Transaction x : transactions) {
			
			boolean test = true;
			for (Category y : budget) {
				if (x.getCategory().equals(y.getType())) {
					test=false;
					double addAmount = (x.getAmount());
					y.setAmount(y.getAmount()+ (int)addAmount);
				}
			}
			if(test) {
				double addAmount = (x.getAmount());
				Category temp = new Category(x.getCategory(), (int)addAmount);
				budget.add(temp);
			}
		}
		
		return budget;
	}

	public static boolean checkLoginRecievers(String email, String password, ArrayList<Reciever> recievers){
	    for(int i=0; i<recievers.size(); i++){
	        if(email.equals(recievers.get(i).getEmail()) && password.equals(recievers.get(i).getPassword())){
	            return true;
            }
        }
	    return false;
    }

    public static boolean checkLoginDonors(String email, String password, ArrayList<Donor> donors){
        for(int i=0; i<donors.size(); i++){
            if(email.equals(donors.get(i).getEmail()) && password.equals(donors.get(i).getPassword())){
                return true;
            }
        }
        return false;
    }
}