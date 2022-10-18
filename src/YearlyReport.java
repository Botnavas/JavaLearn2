import java.util.HashMap;

public class YearlyReport {
    private HashMap<Integer, YearItem> yearItems = new HashMap<>();
    private Integer year;

    public YearlyReport(String[] yearItem, int year) {
        this.year = year;

        if (yearItem.length == 0)
        {
            System.out.println("Report for year" + year + " wasn't found or incorrect");
            return;
        }

        //Creating YearItem for all months
        for (int i = 1; i <= 12; i++) {
            yearItems.put(i, new YearItem(i));
        }

        //Filling yearItems
        for (int i = 1; i < yearItem.length; i++) {
            String[] yearItemData = yearItem[i].split(",");

            if (Boolean.parseBoolean(yearItemData[2])) {
                yearItems.get(Integer.parseInt(yearItemData[0])).addExpense(
                        Integer.parseInt(yearItemData[1]));
            } else {
                yearItems.get(Integer.parseInt(yearItemData[0])).addIncome(
                        Integer.parseInt(yearItemData[1]));
            }
        }
    }

    private int findAverageExpense() {
        int expense = 0;

        for (YearItem yearItem : yearItems.values()) {
            expense += yearItem.getExpense();
        }
        return expense/ yearItems.size();
    }

    private int findAverageIncome() {
        int income = 0;
        for (YearItem yearItem : yearItems.values()) {
            income += yearItem.getIncome();
        }
        return income/ yearItems.size();
    }

    public void printYearlyReport() {
        if (yearItems.isEmpty()) {
            System.out.println("Error: yearly report wasn't read");
            return;
        }

        System.out.println("YEAR: " + year);
        System.out.println("Average income: " + findAverageIncome());
        System.out.println("Average expense: " + findAverageExpense());
        for (YearItem yearItem : yearItems.values()) {
            if ((yearItem.getExpense() == 0) && (yearItem.getIncome() == 0)) {
                System.out.println("For month " + String.format("%1$02d", yearItem.getMonth())
                     + " income and expense are zero. Information for this month may be missing");
            } else {
                System.out.println("MONTH\tINCOME");
                System.out.print(String.format("%1$02d", yearItem.getMonth()) + "\t");
                System.out.print(Integer.toString(yearItem.getIncome() - yearItem.getExpense()) + "\n");
            }
            System.out.println();
        }
    }

    public void checkMonthlyReports(HashMap<Integer, MonthlyReport> monthlyReports) {
        if (monthlyReports.isEmpty() || yearItems.isEmpty()) {
            System.out.println("Error: reports wasn't read");
            return;
        }

        for (MonthlyReport monthlyReport : monthlyReports.values()) {
            if (!monthlyReport.calculateYearItem().equals(
                    yearItems.get(monthlyReport.getMonth()))) {
                System.out.println("Found variance in monthly report for month "
                     + String.format("%1$02d", monthlyReport.getMonth()) + " and yearly report");
            } else {
                System.out.println("Data in monthly report for month "
                        +String.format("%1$02d", monthlyReport.getMonth()) + " and yearly report are the same");
                if ((yearItems.get(monthlyReport.getMonth()).getExpense() == 0) &&
                        (yearItems.get(monthlyReport.getMonth()).getIncome() == 0)) {
                    System.out.println("For month " + String.format("%1$02d", monthlyReport.getMonth())
                            + " income and expense are zero. Information for this month may be missing"
                            + " and monthly report most likely is missing too");
                }
            }
            System.out.println();
        }
    }
}
