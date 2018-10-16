
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rueln
 */
public class UserInterface {

    private Scanner reader;
    private Directory directory;

    public UserInterface() {
        this.reader = new Scanner(System.in);
        this.directory = new Directory();
    }

    public void start() {
        System.out.print("phone search\n"
                + "available operations:\n"
                + " 1 add a number\n"
                + " 2 search for a number\n"
                + " 3 search for a person by phone number\n"
                + " 4 add an address\n"
                + " 5 search for personal information\n"
                + " 6 delete personal information\n"
                + " 7 filtered listing\n"
                + " x quit\n\n");
        this.readCommand();
    }

    private void readCommand() {
        while (true) {
            String command = requestInput("command: ");

            if (command.equals("x")) {
                break;
            } else if (command.equals("1")) {
                this.addNumber();
            } else if (command.equals("2")) {
                this.searchNumberByName();
            } else if (command.equals("3")) {
                this.searchNameByNumber();
            } else if (command.equals("4")) {
                this.addAddress();
            } else if (command.equals("5")) {
                this.searchInfoByName();
            } else if (command.equals("6")) {
                this.deleteInfo();
            } else if (command.equals("7")) {
                this.printFilteredList();
            }
        }
    }

    private void addNumber() {
        String name = requestInput("whose number: ");
        String number = requestInput("number: ");
        directory.addNumber(number, name);
        System.out.println("");
    }

    private void searchNumberByName() {
        String name = requestInput("whose number: ");
        Contact contact = directory.searchByName(name);
        if (contact == null) {
            System.out.println(" not found");
        } else if (contact.getPhoneNumbers().isEmpty()) {
            System.out.println(" not found");
        } else {
            for (String number : contact.getPhoneNumbers()) {
                System.out.println(" " + number);
            }
        }
        System.out.println("");
    }

    private void searchNameByNumber() {
        String number = requestInput("number: ");
        Contact contact = this.directory.searchByNum(number);

        if (contact == null) {
            System.out.println(" not found");
        } else {
            System.out.println(" " + contact.getName());
        }
        System.out.println("");
    }

    private void addAddress() {
        String name = requestInput("whose address: ");
        String street = requestInput("street: ");
        String city = requestInput("city: ");
        directory.addAddress(street, city, name);
        System.out.println("");
    }

    private void searchInfoByName() {
        String name = requestInput("whose information: ");
        Contact contact = this.directory.searchByName(name);
        if (contact == null) {
            System.out.println("  not found");
        } else {
            System.out.println("address: " + contact.getAddress());
            System.out.println("phone numbers: ");
            if (contact.getPhoneNumbers().isEmpty()) {
                System.out.println("  not found");
            } else {
                for (String number : contact.getPhoneNumbers()) {
                    System.out.println("  " + number);
                }
            }
        }
        System.out.println("");
    }

    private void deleteInfo() {
        String name = requestInput("whose information: ");
        Contact contact = this.directory.searchByName(name);
        directory.clearContact(contact);
        System.out.println("");
    }

    private void printFilteredList() {
        String keyword = requestInput("keyword (if empty, all listed): ");
        System.out.println("");

        for (Contact contact : directory.filteredList(keyword)) {
            System.out.println(" " + contact.getName());
            System.out.println("  " + contact.getAddress());

            if (contact.getPhoneNumbers().isEmpty()) {
                System.out.println("  phone number not found");
            } else {
                for (String number : contact.getPhoneNumbers()) {
                    System.out.println("  " + number);
                }
            }
        }
        System.out.println("");
    }

    private String requestInput(String request) {
        System.out.print(request);
        return this.reader.nextLine();
    }

}
