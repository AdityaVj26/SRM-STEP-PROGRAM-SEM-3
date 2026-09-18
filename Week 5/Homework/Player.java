import java.util.Arrays;
import java.util.Scanner;

public class Player implements Comparable<Player> {

    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    // Constructor
    public Player(String name, int matchesPlayed,
                  double battingAverage, boolean injured) {

        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    // Overloaded method 1: Experience-only rule
    public static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    // Overloaded method 2: Matches and fitness rule
    public static boolean isDraftable(
            int matchesPlayed, boolean injured) {

        return matchesPlayed >= 5 && !injured;
    }

    // Rank by batting average in descending order
    @Override
    public int compareTo(Player other) {

        return Double.compare(
                other.battingAverage,
                this.battingAverage
        );
    }

    // Draft and rank players
    public static String draftAndRank(Player[] players) {

        Player[] draftable = new Player[players.length];

        int count = 0;

        for (Player player : players) {

            if (isDraftable(player.matchesPlayed)
                    || isDraftable(
                            player.matchesPlayed,
                            player.injured)) {

                draftable[count] = player;
                count++;
            }
        }

        draftable = Arrays.copyOf(draftable, count);

        // Sort using compareTo()
        Arrays.sort(draftable);

        String result = "";

        for (int i = 0; i < draftable.length; i++) {

            result += (i + 1) + ". "
                    + draftable[i].name;

            if (i < draftable.length - 1) {
                result += " | ";
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of players: ");
        int n = sc.nextInt();
        sc.nextLine();

        Player[] players = new Player[n];

        for (int i = 0; i < n; i++) {

            System.out.println("\nPlayer " + (i + 1));

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            System.out.print("Enter matches played: ");
            int matchesPlayed = sc.nextInt();

            System.out.print("Enter batting average: ");
            double battingAverage = sc.nextDouble();

            System.out.print("Is player injured? (true/false): ");
            boolean injured = sc.nextBoolean();
            sc.nextLine();

            players[i] = new Player(
                    name,
                    matchesPlayed,
                    battingAverage,
                    injured
            );
        }

        String result = draftAndRank(players);

        System.out.println("\nDraftable Players:");
        System.out.println(result);

        sc.close();
    }
}