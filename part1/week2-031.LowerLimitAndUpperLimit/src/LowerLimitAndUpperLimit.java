
import java.util.Scanner;

public class LowerLimitAndUpperLimit {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.println("First: ");
        int start = Integer.parseInt(reader.nextLine());
        System.out.println("Last: ");
        int end = Integer.parseInt(reader.nextLine());
        
        int number = start;
        while (number <= end) {
            System.out.println(number);
            number++;
        }

    }
}
