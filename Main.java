public class Main {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();

        vendingMachine.insertMoney(20.0); // Insert initial money
        vendingMachine.purchaseProducts();
    }
}
