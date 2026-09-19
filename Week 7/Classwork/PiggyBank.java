class PiggyBank {

    // Private fields
    private double savings;
    private final String id;

    // Constructor
    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0;
    }

    // Deposit money
    public void deposit(double amount) {

        if (amount <= 0) {
            System.out.println("Deposit rejected: Invalid amount");
        } else {
            savings += amount;
            System.out.println("Savings after deposit: " + savings);
        }
    }

    // Withdraw money
    public void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Withdrawal rejected: Invalid amount");
        } else if (amount > savings) {
            System.out.println("Withdrawal rejected: Insufficient savings");
        } else {
            savings -= amount;
            System.out.println("Savings after withdrawal: " + savings);
        }
    }

    // Read-only access to savings
    public double getSavings() {
        return savings;
    }

    // Read-only access to ID
    public String getId() {
        return id;
    }

    public static void main(String[] args) {

        PiggyBank pb = new PiggyBank("PB-1");

        pb.deposit(100);
        pb.withdraw(30);
        pb.withdraw(500);

        System.out.println("Final savings: " + pb.getSavings());
        System.out.println("Piggy Bank ID: " + pb.getId());
    }
}