public class Category{
    private String type;
    private int amount;

    public Category(String type, int amount){
        this.type = type;
        this.amount = amount;
    }

    //type: supermarket, bank, clothing store, pharmacy, gas, bus

    public String getType() {
        return type;
    }
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String toString() {
    	return "Type: " + type + " Amount: " + amount;
    } 
}
