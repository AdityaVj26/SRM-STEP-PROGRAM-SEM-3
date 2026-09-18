import java.util.Scanner;

public class MaskedPhoneNumberFormatter {

    public static String maskPhoneNumber(String phone) {

        // Validate length
        if (phone.length() != 10) {
            return "Invalid phone number";
        }

        // Validate all characters are digits
        for (int i = 0; i < phone.length(); i++) {
            if (!Character.isDigit(phone.charAt(i))) {
                return "Invalid phone number";
            }
        }

        // Extract last 4 digits
        String lastFourDigits = phone.substring(6);

        // Create masked number using StringBuilder
        StringBuilder maskedNumber = new StringBuilder("XXXXXX");

        // Insert hyphen before last 4 digits
        maskedNumber.insert(6, "-");

        maskedNumber.append(lastFourDigits);

        return maskedNumber.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter phone number: ");
        String phone = sc.nextLine();

        String result = maskPhoneNumber(phone);

        System.out.println(result);

        sc.close();
    }
}