import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean isWorking = true;
        Scanner scanner = new Scanner(System.in);
        ReportsController reportsController = new ReportsController();

        help();
        while (isWorking) {
            String command = scanner.nextLine();

            switch (command) {
                case "1" :
                    reportsController.readMonthlyReports("resources\\m.2021", ".csv");
                    help();
                    break;

                case "2":
                    reportsController.readYearlyReport("resources\\y.2021.csv", 2021);
                    help();
                    break;

                case "4":
                    reportsController.printMonthlyReports();
                    help();
                    break;

                case "5":
                    reportsController.printYearlyReport();
                    help();
                    break;

                case "3":
                    reportsController.checkReports();
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
        System.out.println();
        System.out.println("For reading monthly reports enter: 1");
        System.out.println("For reading yearly report enter: 2");
        System.out.println("For checking reports enter: 3");
        System.out.println("For watching monthly reports enter: 4");
        System.out.println("For watching yearly report enter: 5");
        System.out.println("For exit enter: exit");
    }
}