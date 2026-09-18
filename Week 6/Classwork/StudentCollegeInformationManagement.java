class Student {

    // Instance fields
    String name;
    double attendance;

    // Static fields shared by all students
    static String collegeName =
            "SRM Institute of Science and Technology";

    static int studentCount = 0;

    // Constructor
    public Student(String name, double attendance) {
        this.name = name;
        this.attendance = attendance;

        studentCount++;
    }

    // Static method
    static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }
}

public class StudentCollegeInformationManagement {

    public static void main(String[] args) {

        // Create two Student objects
        Student s1 = new Student("Aditya", 85.5);
        Student s2 = new Student("Priya", 90.0);

        System.out.println("2 Student objects created");
        System.out.println();

        // Call static method through class name
        Student.printCollegeInfo();
    }
}
