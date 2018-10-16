
import java.util.Scanner;

public class SumOfThePowers {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.println("Type a number: ");
        int number = Integer.parseInt(reader.nextLine());
        int i = 0;
        int sum = 0;

        while (i <= number) {
            sum += (int) Math.pow(2, i);
            i++;
        }
        System.out.println("The result is " + sum);
    }
}
