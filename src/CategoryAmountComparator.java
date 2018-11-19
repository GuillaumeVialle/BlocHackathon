import java.util.Comparator;

public class CategoryAmountComparator implements Comparator<Category> {
    public int compare(Category c1, Category c2){
        return c1.getAmount() - c2.getAmount();
    }
}

