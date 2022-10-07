import java.util.ArrayList;

public class YearlyReport {
    private ArrayList<MonthStats> monthStats;

    public void printYearlyReport() {
        for (MonthStats monthsStats : this.monthStats) {
            System.out.println("MONTH\tAMOUNT\tIS EXPENSE\n");
            System.out.print(monthsStats.getMonth() + "\t");
            System.out.print(monthsStats.getIncome() + "\tfalse\n");
            System.out.print(monthsStats.getMonth() + "\t");
            System.out.print(monthsStats.getExpense() + "\ttrue\n");
        }
    }
}
