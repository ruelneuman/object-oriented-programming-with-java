
import java.util.Scanner;

public class Temperatures {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        // Write your code here. 
        while (true) {
            System.out.println("Input a temperature: ");
            double temp = Double.parseDouble(reader.next());

            if (temp >= -30 && temp <= 40) {
                Graph.addNumber(temp);
            } else {
            }
        }
    }
}
