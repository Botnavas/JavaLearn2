import java.util.HashMap;

public class YearlyReport {
    private HashMap<String, MonthStatistic> monthStatisticHashMap = new HashMap<>();
    private String year;

    public YearlyReport(String[] monthExpense, String year) {
        this.year = year;

        for (int i = 1; i < monthExpense.length; i++) {
            String[] monthExpenseData = monthExpense[i].split(",");
            if (!monthStatisticHashMap.containsKey(monthExpenseData[0])) {
                monthStatisticHashMap.put(monthExpenseData[0],
                        new MonthStatistic(monthExpenseData[0]));
            }
            if (Boolean.parseBoolean(monthExpenseData[2])) {
                monthStatisticHashMap.get(monthExpenseData[0]).setExpense(
                        Integer.parseInt(monthExpenseData[1]));
            } else {
                monthStatisticHashMap.get(monthExpenseData[0]).setIncome(
                        Integer.parseInt(monthExpenseData[1]));
            }
        }
    }

    private int findAverageExpense() {
        int expense = 0;

        for (MonthStatistic monthStatistic : monthStatisticHashMap.values()) {
            expense += monthStatistic.getExpense();
        }
        return expense/ monthStatisticHashMap.size();
    }

    private int findAverageIncome() {
        int income = 0;
        for (MonthStatistic monthStatistic : monthStatisticHashMap.values()) {
            income += monthStatistic.getIncome();
        }
        return income/ monthStatisticHashMap.size();
    }

    public void printYearlyReport() {
        if (monthStatisticHashMap.isEmpty()) {
            System.out.println("Error: yearly report wasn't read");
            return;
        }

        System.out.println("YEAR: " + year);
        System.out.println("Average income: " + findAverageIncome());
        System.out.println("Average expense: " + findAverageExpense());
        for (MonthStatistic monthsStats : monthStatisticHashMap.values()) {
            System.out.println("MONTH\tINCOME");
            System.out.print(monthsStats.getMonth() + "\t");
            System.out.print(Integer.toString(monthsStats.getIncome() - monthsStats.getExpense()) + "\n");
        }
        System.out.println();
    }

    public void checkMonthlyReports(HashMap<String, MonthlyReport> monthlyReports) {
        if (monthlyReports.isEmpty() || monthStatisticHashMap.isEmpty()) {
            System.out.println("Error: reports wasn't read");
            return;
        }

        for (MonthlyReport monthlyReport : monthlyReports.values()) {
            if (!monthlyReport.checkReport().equals(
                    monthStatisticHashMap.get(monthlyReport.getMonth()))) {
                System.out.println("Found variance in monthly report for month "
                     + monthlyReport.getMonth() + " and yearly report");
            } else {
                System.out.println("Data in monthly report for month "
                        + monthlyReport.getMonth() + " and yearly report are the same");
            }
        }
    }
}
