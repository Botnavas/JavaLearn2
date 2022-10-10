public class Expense {
    private String itemName;
    private boolean isExpense;
    private int quantity;
    private int price;

    public Expense(String itemName, boolean isExpense, int quantity, int price) {
        this.itemName = itemName;
        this.isExpense = isExpense;
        this.quantity = quantity;
        this.price = price;
    }

    public Expense(String line) {
        String[] data = line.split(",");
        itemName = data[0];
        isExpense = Boolean.parseBoolean(data[1]);
        quantity = Integer.parseInt(data[2]);
        price = Integer.parseInt(data[3]);
    }

    public String getItemName() {
        return itemName;
    }

    public boolean getIsExpense() {
        return isExpense;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }
}
