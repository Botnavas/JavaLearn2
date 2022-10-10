public class MonthStats {
    private String month;
    private int expense;
    private int income;


    public MonthStats(String month, int expense, int income) {
        this.month = month;
        this.income = income;
        this.expense = expense;
    }

    public MonthStats(String expense, String income) {
        String[] expenseData = expense.split(",");
        String[] incomeData = income.split(",");

        month = expenseData[0];
        if (Boolean.parseBoolean(expenseData[2])) {
            this.expense = Integer.parseInt(expenseData[1]);
            this.income = Integer.parseInt(incomeData[2]);
        } else {
            this.expense = Integer.parseInt(incomeData[1]);
            this.income = Integer.parseInt(expenseData[2]);
        }
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

    public boolean equals(MonthStats monthStats) {
        return (this.expense == monthStats.expense) && (this.income == monthStats.income);
    }
}
