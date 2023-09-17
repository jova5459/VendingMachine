public class Product {
    private String name;
    private double price;
    private String nutritionalFacts;
    private Category category;
    private int quantity;

    public Product(String name, double price, String nutritionalFacts, Category category) {
        this.name = name;
        this.price = price;
        this.nutritionalFacts = nutritionalFacts;
        this.category = category;
        this.quantity = 0;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getNutritionalFacts() {
        return nutritionalFacts;
    }

    public Category getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void decrementQuantity() {
        if (quantity > 0) {
            quantity--;
        }
    }
}
