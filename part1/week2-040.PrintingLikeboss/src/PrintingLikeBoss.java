
public class PrintingLikeBoss {

    // copy or rewrite the method of Assignment 39.1 here
    public static void printStars(int amount) {
        int printed = 0;
        while (printed < amount) {
            System.out.print("*");
            printed++;
        }
        System.out.println("");
    }

    public static void printWhitespaces(int amount) {
        // 40.1
        int printed = 0;
        while (printed < amount) {
            System.out.print(" ");
            printed++;
        }
    }

    public static void printTriangle(int size) {
        // 40.2
        int row = 1;
        while (row <= size) {
            printWhitespaces(size - row);
            printStars(row);
            row++;
        }
    }

    public static void xmasTree(int height) {
        // 40.3
        int row = 1;
        while (row <= height) {
            printWhitespaces(height - row);
            printStars(2 * row - 1);
            row++;
        }
        printWhitespaces(height - 2);
        printStars(3);
        printWhitespaces(height - 2);
        printStars(3);
    }

    public static void main(String[] args) {
        // Tests do not use main, yo can write code here freely!
        printTriangle(5);
        System.out.println("---");
        xmasTree(4);
        System.out.println("---");
        xmasTree(10);
        System.out.println("---");
    }
}

