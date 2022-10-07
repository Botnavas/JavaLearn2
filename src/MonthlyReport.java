import java.util.ArrayList;

public class MonthlyReport {
    private ArrayList<Expense> expenses;
    String month;

    public MonthStats checkReport() {
        int monthExpense = 0;
        int monthIncome = 0;

        for (Expense expense : expenses) {
            if (expense.getIsExpense()) {
                monthExpense -= expense.getSum() * expense.getQuantity();
            } else {
                monthIncome += expense.getSum() * expense.getQuantity();
            }
        }

        return new MonthStats(month, monthExpense, monthIncome);
    }

    public void printReport() {
        System.out.println("ITEM NAME\t\tIS EXPENSE\tQUANTITY\tSUM OF ONE\n");
        for (Expense expense : expenses) {
            System.out.print(expense.getItemName() + "\t");
            System.out.print(expense.getIsExpense() + "\t");
            System.out.print(expense.getQuantity() + "\t");
            System.out.print(expense.getSum() + "\n");
        }
    }
}
