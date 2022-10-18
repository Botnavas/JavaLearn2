import java.util.ArrayList;
import java.util.List;

public class MonthlyReport {
    private List<MonthItem> monthItems = new ArrayList<>();
    private int month;

    public MonthlyReport(String[] monthItemsInLines, int month) {
        this.month = month;
        if (monthItemsInLines.length == 0)
        {
            System.out.println("Report for month " + String.format("%1$02d", month) + " wasn't found");
            return;
        }

        for (int i = 1; i < monthItemsInLines.length; i ++) {
            MonthItem monthItem = new MonthItem(monthItemsInLines[i]);
            monthItems.add(monthItem);
        }
        System.out.println("Read report for month " + String.format("%1$02d", month));
    }

    public YearItem calculateYearItem() {
        if (monthItems.isEmpty()) {
            return new YearItem(month);
        }

        int monthExpense = 0;
        int monthIncome = 0;

        for (MonthItem monthItem : monthItems) {
            if (monthItem.isExpense()) {
                monthExpense += monthItem.getPrice() * monthItem.getQuantity();
            } else {
                monthIncome += monthItem.getPrice() * monthItem.getQuantity();
            }
        }
        return new YearItem(month, monthExpense, monthIncome);
    }

    //True for expense, false for income
    private ArrayList<MonthItem> findBiggestExpensesOrIncomes(boolean expenseOrIncome) {
        MonthItem biggestExpense = new MonthItem("", expenseOrIncome, 0, 0);
        ArrayList<MonthItem> biggestExpenses = new ArrayList<>();

        for (MonthItem monthItem : monthItems) {
            if (monthItem.isExpense() == expenseOrIncome) {
                if ((monthItem.getPrice() * monthItem.getQuantity()) ==
                        (biggestExpense.getPrice() * biggestExpense.getQuantity())) {
                    biggestExpense = monthItem;
                    biggestExpenses.add(biggestExpense);
                }
                if ((monthItem.getPrice() * monthItem.getQuantity()) >
                        (biggestExpense.getPrice() * biggestExpense.getQuantity())) {
                    biggestExpense = monthItem;
                    biggestExpenses.clear();
                    biggestExpenses.add(biggestExpense);
                }
            }
        }

        return biggestExpenses;
    }

    public void printReport() {
        if (monthItems.isEmpty()) {
            System.out.println("There isn't report for month "
                    + String.format("%1$02d", month) + " or it wasn't read");
            return;
        }

        System.out.println("MONTH: " + String.format("%1$02d", month));
        System.out.println("Biggest expenses:");

        for (MonthItem monthItem : findBiggestExpensesOrIncomes(true))
        {
            System.out.println(monthItem.getItemName() + ", Sum "
                    + monthItem.getQuantity() * monthItem.getPrice());
        }
        System.out.println("Biggest income: ");
        for (MonthItem monthItem : findBiggestExpensesOrIncomes(false))
        {
            System.out.println(monthItem.getItemName() + ", Sum "
                    + monthItem.getQuantity() * monthItem.getPrice());
        }

        System.out.println("ITEM NAME\t\tIS EXPENSE\tQUANTITY\tSUM OF ONE");
        for (MonthItem monthItem : monthItems) {
            System.out.print(monthItem.getItemName() + "\t");
            System.out.print(monthItem.isExpense() + "\t");
            System.out.print(monthItem.getQuantity() + "\t");
            System.out.print(monthItem.getPrice() + "\n");
        }
        System.out.println();
    }

    public int getMonth() {
        return  month;
    }
}
