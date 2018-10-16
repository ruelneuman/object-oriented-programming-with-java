
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] original = {1, 2, 3, 4};
        int[] copied = copy(original);
        int[] reversed = reverseCopy(original);

        // change the copied
        copied[0] = 99;

        // print both
        System.out.println("original: " + Arrays.toString(original));
        System.out.println("copied: " + Arrays.toString(copied));
        System.out.println("copied: " + Arrays.toString(reversed));
    }

    public static int[] copy(int[] array) {
        int[] copy = new int[array.length];
        for (int i = 0; i < copy.length; i++) {
            copy[i] = array[i];
        }
        return copy;
    }

    public static int[] reverseCopy(int[] array) {
        int[] rev = new int[array.length];
        for (int i = 0; i < rev.length; i++) {
            rev[i] = array[array.length - i - 1];
        }
        return rev;
    }

}
