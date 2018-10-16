
import java.util.Scanner;

public class UpToCertainNumber {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.println("Up to what number? ");
        int limit = Integer.parseInt(reader.nextLine());
        int n = 1;
        while (n <= limit) {
            System.out.println(n);
            n++;
        }
    }
}
