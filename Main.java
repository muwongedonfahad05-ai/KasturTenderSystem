import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        ArrayList<Bidder> bidders = new ArrayList<>();

        System.out.println("===== BID ENTRY =====");

        for (int i = 1; i <= 4; i++) {

            System.out.print("Bidder Name: ");
            String name = input.nextLine();

            double amount;

            while (true) {

                try {

                    System.out.print("Bid Amount: ");

                    amount = Double.parseDouble(input.nextLine());

                    if (amount <= 0) {
                        System.out.println("Bid must be positive.");
                        continue;
                    }

                    bidders.add(new Bidder(name, amount));
                    break;

                } catch (Exception e) {
                    System.out.println("Invalid amount.");
                }
            }
        }

        Bidder winner = bidders.get(0);

        for (Bidder b : bidders) {

            if (b.getBidAmount() < winner.getBidAmount()) {
                winner = b;
            }
        }

        System.out.println("\nWINNING BIDDER");
        System.out.println("Name: " + winner.getName());
        System.out.println("Bid: UGX " + winner.getBidAmount());

        System.out.println("\n===== PROJECT DETAILS =====");

        System.out.print("Tender Reference: ");
        String ref = input.nextLine();

        System.out.print("Contract Value: ");
        double contractValue =
                Double.parseDouble(input.nextLine());

        System.out.print("Outstanding Balance: ");
        double balance =
                Double.parseDouble(input.nextLine());

        Project project =
                new Project(ref, contractValue, balance);

        System.out.print("Number of Payments: ");
        int payments =
                Integer.parseInt(input.nextLine());

        for (int i = 1; i <= payments; i++) {

            System.out.print("Payment " + i + ": ");
            project.addPayment(
                    Double.parseDouble(input.nextLine()));
        }

        System.out.print("Number of Expenses: ");
        int expenses =
                Integer.parseInt(input.nextLine());

        for (int i = 1; i <= expenses; i++) {

            System.out.print("Expense " + i + ": ");
            project.addExpense(
                    Double.parseDouble(input.nextLine()));
        }

        double result =
                project.calculateProfitLoss();

        System.out.println("\n===== PROJECT REPORT =====");

        System.out.println("Tender Ref: "
                + project.getTenderRef());

        System.out.println("Contract Value: UGX "
                + project.getContractValue());

        System.out.println("Outstanding Balance: UGX "
                + project.getOutstandingBalance());

        System.out.println("Total Payments: UGX "
                + project.getTotalPayments());

        System.out.println("Total Expenses: UGX "
                + project.getTotalExpenses());

        if (result >= 0) {

            System.out.println("PROFIT = UGX "
                    + result);

        } else {

            System.out.println("LOSS = UGX "
                    + Math.abs(result));
        }
    }
}