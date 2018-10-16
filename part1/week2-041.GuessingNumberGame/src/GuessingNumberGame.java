
import java.util.Random;
import java.util.Scanner;

public class GuessingNumberGame {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int numberDrawn = drawNumber();

        // program your solution here. Do not touch the above lines!
        int guess;
        int count = 0;
        
        while (true) {
            System.out.print("Guess a number: ");
            count++;
            guess = Integer.parseInt(reader.nextLine());
            if (numberDrawn < guess) {
                System.out.println("The number is lesser, guesses made: " + count);
            } else if (numberDrawn > guess) {
                System.out.println("The number is greater, guesses made: " + count);
            } else if (numberDrawn == guess) {
                System.out.println("Congratulations, your guess is correct!");
                break;
            }
        }
    }
    

    // DO NOT MODIFY THIS!
    private static int drawNumber() {
        return new Random().nextInt(101);
    }
}
