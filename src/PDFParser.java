import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDFParser {

	private String filePath;

	public PDFParser(String filePath) {
		this.filePath = filePath;
	}

	public String PDFtoText() throws IOException {
		try {
			PDDocument doc = PDDocument.load(new File(filePath));
			if (!doc.isEncrypted()) {
				PDFTextStripper stripper = new PDFTextStripper();
				String text = stripper.getText(doc);
				doc.close();
				return text;
			}
			else {
				return("Encrypted File");
			}
		} catch (Exception e) {
			return ("Failed");
		}
	}

	public ArrayList<Transaction> getTransactions(){

		ArrayList<Transaction> transactions = new ArrayList<>();
		String text;
		try {
			text = PDFtoText();
		} catch (Exception e) {
			text = "Error loading text"; 
		}

		for(int i = 0; i < text.length(); i++) {

			Double amount = 0.0;
			String merchant = "";
			String city = "";

			if(text.charAt(i) == '$') {
				i++;
				String amountString = "";
				while(text.charAt(i) != '.') {
					amountString += "" + text.charAt(i);
					i++;
				}
				amountString += "." + text.charAt(i+1) + text.charAt(i+2);
				amount = Double.parseDouble(amountString);
				i += 3;


			while(!Character.isDigit(text.charAt(i))){	
				if(text.charAt(i) == ' ') {
					merchant += "+";
				} else if (text.charAt(i) != '#' && text.charAt(i) != '\n'){
					merchant += "" + text.charAt(i);
				}
				i++;
			}
			
			while(Character.isDigit(text.charAt(i))){
				i++;
			}
			i++;

			while(text.charAt(i) != '\n') {
				if(text.charAt(i) == ' ') {
					city += "+";
				} else if (text.charAt(i) != '#' && text.charAt(i) != '\n'){
					city += "" + text.charAt(i);
				}
				i++;
			}
			
			if (merchant.charAt(merchant.length()-1) == '+' || merchant.charAt(merchant.length()-1) == '-' || merchant.charAt(merchant.length()-1) == '\n') merchant = merchant.substring(0, merchant.length() -1);
			if (city.charAt(city.length()-1) == '+' || city.charAt(city.length()-1) == '-' || city.charAt(city.length()-1) == '\n') city = city.substring(0, city.length() -1);
			transactions.add(new Transaction(merchant, amount, city));
			}
		}
		return transactions;
	}
}
