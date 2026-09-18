import java.util.Scanner;

class Employee {

    String empId;
    String empName;
    double salary;
    boolean isIntern;

    // Constructor for permanent employees
    public Employee(String empId, String empName, double salary) {

        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    // Constructor for interns
    public Employee(String empId, String empName) {

        this(empId, empName, 0);

        this.isIntern = true;
    }

    // Print employee profile
    public void printProfile() {

        System.out.println(
                empId + " | "
                + empName + " | Rs "
                + salary + " | Intern: "
                + isIntern
        );
    }
}

public class EmployeeProfileCreation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter permanent employee details:");

        System.out.print("Enter employee ID: ");
        String permanentId = sc.nextLine();

        System.out.print("Enter employee name: ");
        String permanentName = sc.nextLine();

        System.out.print("Enter salary: ");
        double permanentSalary = sc.nextDouble();
        sc.nextLine();

        Employee permanentEmployee =
                new Employee(
                        permanentId,
                        permanentName,
                        permanentSalary
                );

        System.out.println("\nEnter intern details:");

        System.out.print("Enter employee ID: ");
        String internId = sc.nextLine();

        System.out.print("Enter employee name: ");
        String internName = sc.nextLine();

        Employee internEmployee =
                new Employee(internId, internName);

        System.out.println("\nEmployee Profiles:");

        permanentEmployee.printProfile();
        internEmployee.printProfile();

        sc.close();
    }
}