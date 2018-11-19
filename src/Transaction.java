
public class Transaction {
	
	private String merchant;
	private Double amount;
	private String city;
	private String category;
	
	public Transaction(String merchant, Double amount, String city) {
		this.merchant = merchant;
		this.amount = amount;
		this.city = city;
	}

	public String getMerchant() {
		return merchant;
	}

	public Double getAmount() {
		return amount;
	}

	public String getCity() {
		return city;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	public String toString() {
		return "Merchant: " + merchant + " Amount: " +  amount + " City: " + city;
	}
	
	
}
