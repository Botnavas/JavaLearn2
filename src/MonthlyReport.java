import java.util.ArrayList;
import java.util.List;

public class MonthlyReport {
    private List<MonthItem> monthItems;
    private String month;

    public MonthlyReport(String[] lines, String month) {
        this.month = month;

        monthItems = new ArrayList<>();
        for (int i = 1; i < lines.length; i ++) {
            MonthItem monthItem = new MonthItem(lines[i]);
            monthItems.add(monthItem);
        }
    }

    public MonthStatistic checkReport() {
        int monthExpense = 0;
        int monthIncome = 0;

        for (MonthItem monthItem : monthItems) {
            if (monthItem.getIsExpense()) {
                monthExpense += monthItem.getPrice() * monthItem.getQuantity();
            } else {
                monthIncome += monthItem.getPrice() * monthItem.getQuantity();
            }
        }
        return new MonthStatistic(month, monthExpense, monthIncome);
    }

    private MonthItem findBiggestExpense() {
        MonthItem biggestExpense = new MonthItem("", true, 0, 0);

        for (MonthItem monthItem : monthItems) {
            if (monthItem.getIsExpense()) {
                if ((monthItem.getPrice() * monthItem.getQuantity()) >
                        (biggestExpense.getPrice() * biggestExpense.getQuantity())) {
                    biggestExpense = monthItem;
                }
            }
        }

        return biggestExpense;
    }

    private MonthItem findBiggestIncome() {
        MonthItem biggestIncome = new MonthItem("", false, 0, 0);

        for (MonthItem monthItem : monthItems) {
            if (!monthItem.getIsExpense()) {
                if ((monthItem.getPrice() * monthItem.getQuantity()) >
                        (biggestIncome.getPrice() * biggestIncome.getQuantity())) {
                    biggestIncome = monthItem;
                }
            }
        }
        return biggestIncome;
    }

    public void printReport() {
        MonthItem biggestExpense = findBiggestExpense();
        MonthItem biggestIncome = findBiggestIncome();

        System.out.println("MONTH: " + month);
        System.out.println("Biggest expense: " + biggestExpense.getItemName()
            + ", Sum: " + biggestExpense.getQuantity() * biggestExpense.getPrice());
        System.out.println("Biggest income: " + biggestIncome.getItemName()
                + ", Sum: " + biggestIncome.getQuantity() * biggestIncome.getPrice());

        System.out.println("ITEM NAME\t\tIS EXPENSE\tQUANTITY\tSUM OF ONE");
        for (MonthItem monthItem : monthItems) {
            System.out.print(monthItem.getItemName() + "\t");
            System.out.print(monthItem.getIsExpense() + "\t");
            System.out.print(monthItem.getQuantity() + "\t");
            System.out.print(monthItem.getPrice() + "\n");
        }
        System.out.println();
    }

    public  String getMonth() {
        return  month;
    }
}
