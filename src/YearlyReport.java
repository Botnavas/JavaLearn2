import java.util.ArrayList;
import java.util.List;

public class YearlyReport {
    private List<MonthStats> monthStats = new ArrayList<>();
    private String year;

    public YearlyReport(String[] lines, String year) {
        for (int i = 1; i < lines.length; i +=2) {
            MonthStats monthStats1 = new MonthStats(lines[i], lines[i + 1]);
            monthStats.add(monthStats1);
        }
        this.year = year;
    }

    public YearlyReport() {}

    private int findAverageExpense() {
        int expense = 0;
        for (MonthStats monthStats : this.monthStats) {
            expense += monthStats.getExpense();
        }
        return expense/monthStats.size();
    }

    private int findAverageIncome() {
        int income = 0;
        for (MonthStats monthStats : this.monthStats) {
            income += monthStats.getIncome();
        }
        return income/monthStats.size();
    }

    public void printYearlyReport() {
        if (monthStats.isEmpty()) {
            System.out.println("Error: yearly report wasn't read");
            return;
        }

        System.out.println("YEAR: " + year);
        System.out.println("Average income: " + findAverageIncome());
        System.out.println("Average expense: " + findAverageExpense());
        for (MonthStats monthsStats : this.monthStats) {
            System.out.println("MONTH\tINCOME\n");
            System.out.print(monthsStats.getMonth() + "\t");
            System.out.print((monthsStats.getIncome() - monthsStats.getExpense()) + "\n");
        }
    }

    public void checkMonthlyReports(List<MonthlyReport> monthlyReports) {
        if (monthlyReports.isEmpty() || monthStats.isEmpty()) {
            System.out.println("Error: reports wasn't read");
            return;
        }

        for (MonthlyReport monthlyReport : monthlyReports) {
                for (MonthStats monthStats : this.monthStats) {
                    if (monthlyReport.getMonth().equals(monthStats.getMonth())) {
                        if (!monthlyReport.checkReport().equals(monthStats)) {
                            System.out.println("Month " + monthlyReport.getMonth()
                                    + ": found variance in data of monthly and yearly reports");
                        }
                    }
                }
        }
    }
}
