class HallTicket {

    String studentName;
    int seatNumber;

    public HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }
}

public class ExamHallTicketReferenceManagement {

    public static void main(String[] args) {

        // Create one HallTicket object
        HallTicket priya = new HallTicket("Priya", 0);

        // Both variables point to the same object
        HallTicket copy = priya;

        // Change seat number using the second variable
        copy.seatNumber = 45;

        // Create a separate object with identical values
        HallTicket separate = new HallTicket("Priya", 45);

        // Display results
        System.out.println("Priya's seatNumber (via first variable):");
        System.out.println(priya.seatNumber);

        System.out.println("copy == priya: " + (copy == priya));

        System.out.println("separate == priya: " + (separate == priya));
    }
}