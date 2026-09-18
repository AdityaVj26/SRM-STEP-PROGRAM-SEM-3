import java.util.Scanner;

class PayrollAccount {

    private double basicSalary;
    private double bonus;

    // Constructor
    public PayrollAccount(double basicSalary) {

        if (basicSalary < 0) {
            System.out.println(
                    "Warning: Negative salary not allowed. Starting at Rs 0."
            );
            this.basicSalary = 0;
        } else {
            this.basicSalary = basicSalary;
        }

        this.bonus = 0;
    }

    // Credit bonus
    public void creditBonus(double amount) {

        if (amount <= 0) {
            System.out.println(
                    "Invalid bonus: Amount must be positive."
            );
        } else {
            bonus += amount;
            System.out.println(
                    "Bonus credited: Rs " + amount
            );
        }
    }

    // Deduct tax
    public void deductTax(double percent) {

        if (percent < 0 || percent > 100) {
            System.out.println(
                    "Invalid tax: Percentage must be between 0 and 100."
            );
        } else {
            basicSalary = basicSalary - (basicSalary * percent / 100);

            System.out.println(
                    "Tax deducted: " + percent + "%"
            );
        }
    }

    // Read-only access to net salary
    public double getNetSalary() {
        return basicSalary + bonus;
    }
}

public class PayrollSalaryManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter basic salary: ");
        double basicSalary = sc.nextDouble();

        PayrollAccount account = new PayrollAccount(basicSalary);

        System.out.print("Enter bonus amount: ");
        double bonus = sc.nextDouble();
        account.creditBonus(bonus);

        System.out.print("Enter tax percentage: ");
        double taxPercent = sc.nextDouble();
        account.deductTax(taxPercent);

        System.out.println(
                "Net salary: Rs " + account.getNetSalary()
        );

        sc.close();
    }
}