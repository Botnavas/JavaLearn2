public class MonthStatistic {
    private String month;
    private int expense;
    private int income;


    public MonthStatistic(String month, int expense, int income) {
        this.month = month;
        this.income = income;
        this.expense = expense;
    }

    public MonthStatistic(String month) {
        this.month = month;
        expense = 0;
        income = 0;
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

    public void setExpense(int expense) {
        this.expense = expense;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public boolean equals(MonthStatistic monthStatistic) {
        return (this.expense == monthStatistic.getExpense()) && (this.income == monthStatistic.getIncome());
    }
}
