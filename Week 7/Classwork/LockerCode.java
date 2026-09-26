class Locker {

    // Private combination - no getter
    private String combination;

    // Final locker number
    private final int lockerNumber;

    // Constructor
    public Locker(int lockerNumber, String combination) {
        this.lockerNumber = lockerNumber;
        this.combination = combination;
    }

    // Change the combination
    public void changeCode(String currentCode, String newCode) {

        // Check current code first
        if (combination.equals(currentCode)) {
            combination = newCode;
            System.out.println("Code changed successfully");
        } else {
            System.out.println("Code change rejected: Incorrect current code");
        }
    }

    // Locker number can be read
    public int getLockerNumber() {
        return lockerNumber;
    }
}

public class LockerCode {

    public static void main(String[] args) {

        Locker l = new Locker(101, "1234");

        // Correct current code
        l.changeCode("1234", "5678");

        // Wrong current code
        l.changeCode("0000", "9999");

        System.out.println("Locker Number: " + l.getLockerNumber());
    }
}