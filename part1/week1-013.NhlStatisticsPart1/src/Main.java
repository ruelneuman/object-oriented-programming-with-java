
import nhlstats.NHLStatistics;

public class Main {

    public static void main(String[] args) {
        System.out.println("Top 10 by goals: ");
        NHLStatistics.sortByGoals();
        NHLStatistics.top(10);
        System.out.println("");

        System.out.println("Top 25 by penalties: ");
        NHLStatistics.sortByPenalties();
        NHLStatistics.top(25);
        System.out.println("");

        System.out.println("Sidney Crosby statistics: ");
        NHLStatistics.searchByPlayer("Sidney Crosby");
        System.out.println("");

        System.out.println("Statistics for PHI: ");
        NHLStatistics.teamStatistics("PHI");
        System.out.println("");

        System.out.println("Statistics for ANA: ");
        NHLStatistics.sortByPoints();
        NHLStatistics.teamStatistics("ANA");
        System.out.println("");
    }
}
