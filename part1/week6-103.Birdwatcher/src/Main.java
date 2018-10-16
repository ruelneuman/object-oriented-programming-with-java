
import java.util.Scanner;

public class Main {

    public static String ask(Scanner scanner, String text) {
        System.out.print(text + " ");
        return scanner.nextLine();
    }

    public static void add(Scanner scanner, ObservationDatabase db) {
        String name = ask(scanner, "Name:");
        String latinName = ask(scanner, "Latin Name:");

        db.addBird(name, latinName);
    }

    public static void observation(Scanner scanner, ObservationDatabase db) {
        String name = ask(scanner, "Name:");

        boolean success = db.observe(name);
        if (!success) {
            System.out.println("Is not a bird!");
        }
    }

    public static void show(Scanner scanner, ObservationDatabase db) {
        String name = ask(scanner, "Name:");
        String answer = db.showBird(name);
        if (answer == null) {
            System.out.println("Is not a bird!");
        } else {
            System.out.println(answer);
        }
    }
    
    public static void statistics(Scanner lukija, ObservationDatabase db) {
        System.out.print(db.statistics());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ObservationDatabase db = new ObservationDatabase();

        while (true) {
            String command = ask(scanner, "Enter a command (Add, Observation, Show, Statistics, Quit):");

            if (command.equals("Quit")) {
                break;
            } else if (command.equals("Add")) {
                add(scanner, db);
            } else if (command.equals("Observation")) {
                observation(scanner, db);
            } else if (command.equals("Show")) {
                show(scanner, db);
            } else if (command.equals("Statistics")) {
                statistics(scanner, db);
            } else {
                System.out.println("Unknown command!");
            }
        }

    }

}
