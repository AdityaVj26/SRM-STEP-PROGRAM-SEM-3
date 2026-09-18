class Employee {

    // Instance fields
    String empName;
    double salary;

    // Static fields shared by all employees
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    // Constructor
    public Employee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;

        employeeCount++;
    }

    // Static method
    static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}

public class EmployeeCompanyInformationManagement {

    public static void main(String[] args) {

        Employee e1 = new Employee("Aditya", 40000);
        Employee e2 = new Employee("Priya", 45000);
        Employee e3 = new Employee("Rahul", 50000);

        System.out.println("3 Employee objects created");
        System.out.println();

        // Calling static method through class name
        Employee.printCompanyInfo();
    }
}
