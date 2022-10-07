public class MonthStats {
    private String month;
    private int expense;
    private int income;


    public MonthStats(String month, int expense, int income) {
        this.month = month;
        this.income = income;
        this.expense = expense;
    }

    public String getMonth() {
        return month;
    }

    public int getExpense() {
        return expense;
    }

    public int getIncome() {
        return income;
    }
}
