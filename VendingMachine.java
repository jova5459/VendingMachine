import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class VendingMachine {
    private Map<String, Product> inventory = new HashMap<>();
    private double totalMoney = 0;
    private double totalSales = 0;

    public VendingMachine() {
        initializeInventory();
    }

    private void initializeInventory() {
        inventory.put("Water", new Product("Water", 1.0, "0g of Sugar", Category.DRINK));
        inventory.put("Soda", new Product("Soda", 1.5, "39g of sugar", Category.DRINK));
        inventory.put("Iced Tea", new Product("Iced Tea", 1.5, "11g of sugar", Category.DRINK));
        inventory.put("Coffee", new Product("Coffee", 2.0, "8g of sugar", Category.DRINK));
        inventory.put("Energy Drink", new Product("Energy Drink", 1.75, "35g of sugar", Category.DRINK));
        inventory.put("Gatorade", new Product("Gatorade", 1.75, "23g of sugar", Category.DRINK));

        inventory.put("Pringles", new Product("Pringles", 1.5, "135mg of sodium", Category.CHIPS));
        inventory.put("Herrs", new Product("Herrs", 1.25, "125mg of sodium", Category.CHIPS));
        inventory.put("Doritos", new Product("Doritos", 1.25, "135mg of sodium", Category.CHIPS));
        inventory.put("Fritos", new Product("Fritos", 1.5, "145mg of sodium", Category.CHIPS));
        inventory.put("Takis", new Product("Takis", 2.25, "165mg of sodium", Category.CHIPS));
        inventory.put("Lays", new Product("Lays", 1.5, "155mg of sodium", Category.CHIPS));

        inventory.put("Granola Bar", new Product("Granola Bar", 1.75, "14g of carbs", Category.HEALTHY_SNACKS));
        inventory.put("Oatmeal", new Product("Oatmeal", 3.0, "22g of carbs", Category.HEALTHY_SNACKS));
        inventory.put("Cereal", new Product("Cereal", 2.25, "12g of carbs", Category.HEALTHY_SNACKS));
        inventory.put("Nuts", new Product("Nuts", 1.5, "18g of carbs", Category.HEALTHY_SNACKS));
        inventory.put("Raisins", new Product("Raisins", 1.25, "13g of carbs", Category.HEALTHY_SNACKS));
        inventory.put("Crackers", new Product("Crackers", 1.5, "11g of carbs", Category.HEALTHY_SNACKS));

        inventory.put("Wrap", new Product("Wrap", 2.75, "10g of protein", Category.SANDWICHES));
        inventory.put("Hoagie", new Product("Hoagie", 3.25, "12g of protein", Category.SANDWICHES));
        inventory.put("Panini", new Product("Panini", 2.75, "9g of protein", Category.SANDWICHES));
        inventory.put("Burger", new Product("Burger", 3.0, "15g of protein", Category.SANDWICHES));
        inventory.put("Chicken Sandwich", new Product("Chicken Sandwich", 3.25, "13g of protein", Category.SANDWICHES));
        inventory.put("Vegan Sandwich", new Product("Vegan Sandwich", 3.0, "11g of protein", Category.SANDWICHES));

        inventory.put("KitKat", new Product("KitKat", 2.0, "11g of sugar", Category.CANDY));
        inventory.put("Hershey", new Product("Hershey", 2.25, "16g of sugar", Category.CANDY));
        inventory.put("SourPatch", new Product("SourPatch", 2.5, "20g of sugar", Category.CANDY));
        inventory.put("Skittles", new Product("Skittles", 2.0, "18g of sugar", Category.CANDY));
        inventory.put("M&M's", new Product("M&M's", 2.0, "14g of sugar", Category.CANDY));
        inventory.put("AlmondJoy", new Product("AlmondJoy", 1.5, "10g of sugar", Category.CANDY));

        inventory.put("IceCream", new Product("IceCream", 2.75, "12g of sugar", Category.FROZEN));
        inventory.put("IceCream Sandwich", new Product("IceCream Sandwich", 3.25, "15g of sugar", Category.FROZEN));
        inventory.put("Popsicle", new Product("Popsicle", 2.5, "13g of sugar", Category.FROZEN));
        inventory.put("Yogurt", new Product("Yogurt", 1.75, "9g of sugar", Category.FROZEN));
        inventory.put("WaterIce", new Product("WaterIce", 2.75, "17g of sugar", Category.FROZEN));
        inventory.put("FreezePop", new Product("FreezePop", 2.5, "16g of sugar", Category.FROZEN));

        for (Product product : inventory.values()) {
            product.setQuantity(6);
        }
    }

    public void insertMoney(double amount) {
        totalMoney += amount;
        System.out.println("You have inserted: $" + amount);
    }

    public void displayProducts() {
        System.out.println("Welcome to the Vending Machine!");
        System.out.println("Available Products:");

        for (Product product : inventory.values()) {
            System.out.println(product.getName() + " - $" + product.getPrice() + " - " + product.getCategory() +
                    " (Quantity: " + product.getQuantity() + ")");
        }
    }

    public boolean selectProduct(String productName) {
        Product selectedProduct = inventory.get(productName);

        if (selectedProduct != null && selectedProduct.getQuantity() > 0) {
            double price = selectedProduct.getPrice();
            if (totalMoney >= price) {
                System.out.println("You have selected: " + selectedProduct.getName());
                System.out.println("Price: $" + price);
                System.out.println("Nutritional Facts: " + selectedProduct.getNutritionalFacts());
                totalMoney -= price;
                totalSales += price;
                selectedProduct.decrementQuantity();
                return true;
            } else {
                System.out.println("Not enough money. Please insert more coins.");
            }
        } else {
            System.out.println("Invalid product selection or out of stock.");
        }
        return false;
    }

    private double returnChange() {
        double change = totalMoney;
        totalMoney = 0;
        return change;
    }

    public void purchaseProducts() {
        Scanner scanner = new Scanner(System.in);
        boolean continueShopping = true;

        while (continueShopping) {
            displayProducts();
            System.out.print("Enter the product name you want to buy (or 'quit' to exit): ");
            String productName = scanner.nextLine();

            if (productName.equalsIgnoreCase("quit")) {
                continueShopping = false;
            } else {
                selectProduct(productName);
            }
        }

        double change = returnChange();
        if (change > 0) {
            System.out.println("Your change: $" + change);
        }

        System.out.println("Thank you for your purchases!");
        System.out.println("Total spent: $" + totalSales);
    }
}
