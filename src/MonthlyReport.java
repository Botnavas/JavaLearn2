import java.util.ArrayList;
import java.util.List;

public class MonthlyReport {
    private List<Expense> expenses = new ArrayList<>();
    private String month;

    public MonthlyReport(String[] lines, String month) {
        for (int i = 1; i < lines.length; i ++) {
            Expense expense = new Expense(lines[i]);
            expenses.add(expense);
        }
        this.month = month;
    }

    public MonthStats checkReport() {
        int monthExpense = 0;
        int monthIncome = 0;

        for (Expense expense : expenses) {
            if (expense.getIsExpense()) {
                monthExpense -= expense.getPrice() * expense.getQuantity();
            } else {
                monthIncome += expense.getPrice() * expense.getQuantity();
            }
        }
        return new MonthStats(month, monthExpense, monthIncome);
    }

    private Expense findBiggestExpense() {
        Expense biggestExpense = new Expense("", true, 0, 0);

        for (Expense expense : expenses) {
            if (expense.getIsExpense()) {
                if ((expense.getPrice() * expense.getQuantity()) >
                        (biggestExpense.getPrice() * biggestExpense.getQuantity())) {
                    biggestExpense = expense;
                }
            }
        }

        return biggestExpense;
    }

    private Expense findBiggestIncome() {
        Expense biggestIncome = new Expense("", false, 0, 0);

        for (Expense expense : expenses) {
            if (!expense.getIsExpense()) {
                if ((expense.getPrice() * expense.getQuantity()) >
                        (biggestIncome.getPrice() * biggestIncome.getQuantity())) {
                    biggestIncome = expense;
                }
            }
        }
        return biggestIncome;
    }

    public void printReport() {
        if (expenses.isEmpty()) {
            System.out.println("Error: monthly reports wasn't read");
            return;
        }

        Expense biggestExpense = findBiggestExpense();
        Expense biggestIncome = findBiggestIncome();

        System.out.println("MONTH: " + month);
        System.out.println("Biggest expense: " + biggestExpense.getItemName()
            + ", Sum: " + biggestExpense.getQuantity() * biggestExpense.getPrice());
        System.out.println("Biggest income: " + biggestIncome.getItemName()
                + ", Sum: " + biggestIncome.getQuantity() * biggestIncome.getPrice());

        System.out.println("ITEM NAME\t\tIS EXPENSE\tQUANTITY\tSUM OF ONE\n");
        for (Expense expense : expenses) {
            System.out.print(expense.getItemName() + "\t");
            System.out.print(expense.getIsExpense() + "\t");
            System.out.print(expense.getQuantity() + "\t");
            System.out.print(expense.getPrice() + "\n");
        }
    }

    public  String getMonth() {
        return  month;
    }
}
