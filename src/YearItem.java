public class YearItem {
    private String month;
    private int expense;
    private int income;


    public YearItem(String month, int expense, int income) {
        this.month = month;
        this.income = income;
        this.expense = expense;
    }

    public YearItem(String month) {
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

    public void addExpense(int expense) {
        this.expense += expense;
    }

    public void addIncome(int income) {
        this.income += income;
    }

    public boolean equals(YearItem yearItem) {
        return (this.expense == yearItem.getExpense()) && (this.income == yearItem.getIncome());
    }
}
