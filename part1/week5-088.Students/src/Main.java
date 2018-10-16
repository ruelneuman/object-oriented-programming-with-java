
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);
        ArrayList<Student> list = new ArrayList<Student>();

        String name = "";
        String number = "";

        while (true) {

            System.out.print("Name: ");
            name = reader.nextLine();

            if (name.isEmpty()) {
                break;
            }

            System.out.print("Student Number: ");
            number = reader.nextLine();

            Student student = new Student(name, number);

            list.add(student);

        }

        System.out.println("");

        for (Student student : list) {
            System.out.println(student);
        }
        
        System.out.println("");
        System.out.print("Give search term: ");
        String searchTerm = reader.nextLine();
        System.out.println("");
        System.out.println("Result: ");

        for (Student student : list) {
            if (student.getName().contains(searchTerm)) {
                System.out.println(student);
            }
        }

    }
}
