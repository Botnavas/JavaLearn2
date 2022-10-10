import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<MonthlyReport> monthlyReports = new ArrayList<>();
        YearlyReport yearlyReport = new YearlyReport();
        boolean isWorking = true;
        Scanner scanner = new Scanner(System.in);
        FileWork fileWork = new FileWork();

        help();
        while (isWorking) {
            String command = scanner.nextLine();

            switch (command) {
                case "Read monthly reports" :
                    for (int i = 1; i <= 3; i ++) {
                        String path = "m.20210" + i + ".csv";
                        monthlyReports.add(new MonthlyReport(fileWork.getLine(path),
                                fileWork.getMonthFromFileName(path)));
                    }
                    break;

                case "Read yearly report":
                    String path = "y.2021.csv";
                    yearlyReport = new YearlyReport(fileWork.getLine(path),
                            fileWork.getYearFromFileName(path));
                    break;

                case "Print monthly reports":
                    for (MonthlyReport monthlyReport : monthlyReports) {
                        monthlyReport.printReport();
                    }
                    break;

                case "Print yearly report":
                    yearlyReport.printYearlyReport();
                    break;

                case "Check reports":
                    yearlyReport.checkMonthlyReports(monthlyReports);
                    break;

                case "help":
                    help();
                    break;

                case "exit":
                    isWorking = false;
                    break;

                case "":

                default:
                    System.out.println("Incorrect command");
            }
        }

    }

     private static void help() {
        System.out.println("For reading monthly reports enter: Read monthly reports");
        System.out.println("For reading yearly report enter: Read yearly report");
        System.out.println("For checking reports enter: Check reports");
        System.out.println("For watching monthly reports enter: Print monthly reports");
        System.out.println("For watching yearly report enter: Print yearly report");
        System.out.println("For exit enter: exit");
        System.out.println("For help enter: help");
    }
}