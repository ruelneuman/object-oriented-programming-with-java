
import java.util.Scanner;

public class TheEndPart {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.print("Type a word: ");
        String word = reader.nextLine();

        System.out.print("Length of the end part: ");
        int lengthEnd = Integer.parseInt(reader.nextLine());

        System.out.print("Result: ");
        String result = word.substring(word.length() - lengthEnd, word.length());
        System.out.print(result);
    }
}
