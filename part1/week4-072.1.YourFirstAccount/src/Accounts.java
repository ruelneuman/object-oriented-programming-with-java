
import java.util.Scanner;

public class Accounts {

    public static void main(String[] args) {
        // Code in Account.Java should not be touched!
        // write your code here

        Account ruelsAccount = new Account("Ruel's account", 100.00);
        
        ruelsAccount.deposit(20);
        
        System.out.print(ruelsAccount);
    }

}
