public class YearItem {
    private int month;
    private int expense;
    private int income;


    public YearItem(int month, int expense, int income) {
        this.month = month;
        this.income = income;
        this.expense = expense;
    }

    public YearItem(int month) {
        this.month = month;
        expense = 0;
        income = 0;
    }

    public int getMonth() {
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
