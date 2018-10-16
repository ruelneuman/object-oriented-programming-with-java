
import java.util.Random;

public class PasswordRandomizer {

    private final int length;
    private Random random = new Random();

    public PasswordRandomizer(int length) {
        this.length = length;
    }

    public String createPassword() {
        String characters = "abcdefghijklmnopqrstuvwxyz";
        int i = 0;
        String password = "";
        while (i < this.length) {
            int number = this.random.nextInt(characters.length());
            char c = characters.charAt(number);
            password += c;
            i++;
        }

        return password;
    }
}
