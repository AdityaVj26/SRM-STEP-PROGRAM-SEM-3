class PlacementRecord {

    String studentName;
    String company;
    double packageLpa;

    // Constructor
    public PlacementRecord(String studentName, String company, double packageLpa) {
        this.studentName = studentName;
        this.company = company;
        this.packageLpa = packageLpa;
    }

    // Instance method
    void printRecord() {
        System.out.println(studentName + " -> " + company + " @ " + packageLpa + " LPA");
    }
}

public class StudentPlacementRecordManagement {

    public static void main(String[] args) {

        // Create three PlacementRecord objects
        PlacementRecord p1 = new PlacementRecord("Ravi", "TCS", 4.5);
        PlacementRecord p2 = new PlacementRecord("Anitha", "Zoho", 6.2);
        PlacementRecord p3 = new PlacementRecord("Karthik", "Infosys", 4.0);

        // Store objects in an array
        PlacementRecord[] records = {p1, p2, p3};

        // Print each record using a loop
        for (int i = 0; i < records.length; i++) {
            records[i].printRecord();
        }
    }
}
