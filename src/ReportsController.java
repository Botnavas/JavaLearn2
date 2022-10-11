import java.util.HashMap;

public class ReportsController {
    private HashMap<String, MonthlyReport> monthlyReports = new HashMap<>();
    private YearlyReport yearlyReport;

    public  void printMonthlyReports() {
        if (monthlyReports.isEmpty()) {
            System.out.println("Monthly reports weren't read");
            return;
        }

        for (MonthlyReport monthlyReport : monthlyReports.values()) {
            monthlyReport.printReport();
        }
    }

    public void printYearlyReport() {
        if (yearlyReport == null) {
            System.out.println("Yearly report wasn't read");
            return;
        }

        yearlyReport.printYearlyReport();
    }

    public void checkReports() {
        if (monthlyReports.isEmpty() || yearlyReport == null) {
            System.out.println("Some reports weren't read");
            return;
        }

        yearlyReport.checkMonthlyReports(monthlyReports);
    }

    public void readMonthlyReports(String firstPartOfPath, int reportsQuantity, String lastPartOfPath) {
        for (int i = 1; i <= reportsQuantity; i++) {
            String path = firstPartOfPath + i + lastPartOfPath;
            monthlyReports.put(FileParser.getMonthName(path),
                    new MonthlyReport(FileParser.getLinesFromFile(path), FileParser.getMonthName(path)));
            System.out.println("Read report for month " + FileParser.getMonthName(path));
        }
    }

    public void readYearlyReport(String path) {
        yearlyReport = new YearlyReport(FileParser.getLinesFromFile(path), FileParser.getYearName(path));
        System.out.println("Read yearly report for year " + FileParser.getYearName(path));
    }
}
