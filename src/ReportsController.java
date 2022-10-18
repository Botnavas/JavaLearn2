import java.util.HashMap;

public class ReportsController {
    private HashMap<Integer, MonthlyReport> monthlyReports = new HashMap<>();
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

    public void readMonthlyReports(String firstPartOfPath, String lastPartOfPath) {
        for (int monthNumber = 1; monthNumber <= 12; monthNumber++) {
            String path = firstPartOfPath + String.format("%1$02d", monthNumber) + lastPartOfPath;
            monthlyReports.put(monthNumber,
                    new MonthlyReport(FileParser.getLinesFromFile(path), monthNumber));
        }
    }

    public void readYearlyReport(String path, int year) {
        yearlyReport = new YearlyReport(FileParser.getLinesFromFile(path), year);
        System.out.println("Read yearly report for year " + year);
    }
}
