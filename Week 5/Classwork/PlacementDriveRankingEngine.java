import java.util.Arrays;
import java.util.Scanner;

public class PlacementDriveRankingEngine
        implements Comparable<PlacementDriveRankingEngine> {

    private String name;
    private double cgpa;
    private int codingScore;

    // Constructor
    public PlacementDriveRankingEngine(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    // Overloaded method 1: CGPA-only eligibility
    public static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }

    // Overloaded method 2: CGPA and coding score eligibility
    public static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }

    // Calculate composite score
    private double getCompositeScore() {
        return (cgpa * 10) + (codingScore * 0.5);
    }

    // Compare candidates by composite score in descending order
    @Override
    public int compareTo(PlacementDriveRankingEngine other) {
        return Double.compare(
                other.getCompositeScore(),
                this.getCompositeScore()
        );
    }

    // Shortlist and rank candidates
    public static String shortlistAndRank(
            PlacementDriveRankingEngine[] candidates) {

        PlacementDriveRankingEngine[] shortlisted =
                new PlacementDriveRankingEngine[candidates.length];

        int count = 0;

        for (PlacementDriveRankingEngine candidate : candidates) {

            if (isEligible(candidate.cgpa)
                    || isEligible(candidate.cgpa, candidate.codingScore)) {

                shortlisted[count] = candidate;
                count++;
            }
        }

        shortlisted = Arrays.copyOf(shortlisted, count);

        // Sort using compareTo()
        Arrays.sort(shortlisted);

        String result = "";

        for (int i = 0; i < shortlisted.length; i++) {

            result += (i + 1) + ". "
                    + shortlisted[i].name
                    + " ("
                    + shortlisted[i].getCompositeScore()
                    + ")";

            if (i < shortlisted.length - 1) {
                result += " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of candidates: ");
        int n = sc.nextInt();
        sc.nextLine();

        PlacementDriveRankingEngine[] candidates =
                new PlacementDriveRankingEngine[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\nCandidate " + (i + 1));

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter CGPA: ");
            double cgpa = sc.nextDouble();

            System.out.print("Enter coding score: ");
            int codingScore = sc.nextInt();
            sc.nextLine();

            candidates[i] =
                    new PlacementDriveRankingEngine(
                            name, cgpa, codingScore
                    );
        }

        String result = shortlistAndRank(candidates);

        System.out.println("\nShortlisted Candidates:");
        System.out.println(result);

        sc.close();
    }
}