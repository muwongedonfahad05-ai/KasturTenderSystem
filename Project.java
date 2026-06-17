public class Project {

    private String tenderRef;
    private double contractValue;
    private double outstandingBalance;
    private double totalPayments;
    private double totalExpenses;

    public Project(String tenderRef,
                   double contractValue,
                   double outstandingBalance) {

        this.tenderRef = tenderRef;
        this.contractValue = contractValue;
        this.outstandingBalance = outstandingBalance;
    }

    public void addPayment(double payment) {
        totalPayments += payment;
    }

    public void addExpense(double expense) {
        totalExpenses += expense;
    }

    public double calculateProfitLoss() {
        return totalPayments - totalExpenses;
    }

    public String getTenderRef() {
        return tenderRef;
    }

    public double getContractValue() {
        return contractValue;
    }

    public double getOutstandingBalance() {
        return outstandingBalance;
    }

    public double getTotalPayments() {
        return totalPayments;
    }

    public double getTotalExpenses() {
        return totalExpenses;
    }
}