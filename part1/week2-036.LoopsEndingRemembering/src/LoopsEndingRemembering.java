
import java.util.Scanner;

public class LoopsEndingRemembering {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        int number = 0;
        int sum = 0;
        int count = 0;
        int countEven = 0;
        int countOdd = 0;

        System.out.println("Type numbers: ");

        while (number != -1) {
            number = Integer.parseInt(reader.nextLine());
            if (number != -1) {
                sum += number;
                count++;
                if (number % 2 == 0) {
                    countEven++;
                } else {
                    countOdd++;
                }               
            }
        }
        double average = (double) sum / count;

        System.out.println("Thank you and see you later!");
        System.out.println("The sum is: " + sum);
        System.out.println("How many numbers: " + count);
        System.out.println("Average: " + average);
        System.out.println("Even numbers: " + countEven);
        System.out.println("Odd numbers: " + countOdd);
    }
}
