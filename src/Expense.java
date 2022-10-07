public class Expense {
    private String itemName;
    private boolean isExpense;
    private int quantity;
    private int sum;

    public Expense(String itemName, boolean isExpense, int quantity, int sum) {
        this.itemName = itemName;
        this.isExpense = isExpense;
        this.quantity =quantity;
        this.sum =sum;
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

    public int getSum() {
        return sum;
    }
}
