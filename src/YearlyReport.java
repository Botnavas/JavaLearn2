import java.util.HashMap;

public class YearlyReport {
    private HashMap<String, YearItem> yearItems = new HashMap<>();
    private String year;

    public YearlyReport(String[] yearItem, String year) {
        this.year = year;

        //Creating YearItem for all months
        for (int i = 1; i <= 12; i++) {
            String monthName;
            if (i < 10) {
                monthName = "0" + Integer.toString(i);
            } else  {
                monthName = Integer.toString(i);
            }
            yearItems.put(monthName, new YearItem(monthName));
        }

        //Filling yearItems
        for (int i = 1; i < yearItem.length; i++) {
            String[] yearItemData = yearItem[i].split(",");

            if (Boolean.parseBoolean(yearItemData[2])) {
                yearItems.get(yearItemData[0]).addExpense(
                        Integer.parseInt(yearItemData[1]));
            } else {
                yearItems.get(yearItemData[0]).addIncome(
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
                System.out.println("For month " + yearItem.getMonth()
                     + " income and expense are zero. Information for this month may be missing");
            } else {
                System.out.println("MONTH\tINCOME");
                System.out.print(yearItem.getMonth() + "\t");
                System.out.print(Integer.toString(yearItem.getIncome() - yearItem.getExpense()) + "\n");
            }
            System.out.println();
        }
    }

    public void checkMonthlyReports(HashMap<String, MonthlyReport> monthlyReports) {
        if (monthlyReports.isEmpty() || yearItems.isEmpty()) {
            System.out.println("Error: reports wasn't read");
            return;
        }

        for (MonthlyReport monthlyReport : monthlyReports.values()) {
            if (!monthlyReport.calculateYearItem().equals(
                    yearItems.get(monthlyReport.getMonth()))) {
                System.out.println("Found variance in monthly report for month "
                     + monthlyReport.getMonth() + " and yearly report");
            } else {
                System.out.println("Data in monthly report for month "
                        + monthlyReport.getMonth() + " and yearly report are the same");
                if ((yearItems.get(monthlyReport.getMonth()).getExpense() == 0) &&
                        (yearItems.get(monthlyReport.getMonth()).getIncome() == 0)) {
                    System.out.println("For month " + yearItems.get(monthlyReport.getMonth()).getMonth()
                            + " income and expense are zero. Information for this month may be missing"
                            + " and monthly report most likely is missing too");
                }
            }
            System.out.println();
        }
    }
}
