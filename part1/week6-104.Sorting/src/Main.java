
import java.util.Arrays;

public class Main {

    public static int smallest(int[] array) {
        return smallestStartingFrom(array, 0);
    }

    public static int smallestStartingFrom(int[] array, int index) {
        int smallest = Integer.MAX_VALUE;

        for (int i = index; i < array.length; i++) {
            if (array[i] < smallest) {
                smallest = array[i];
            }
        }
        return smallest;
    }

    public static int indexOfTheSmallest(int[] array) {
        return indexOfTheSmallestStartingFrom(array, 0);
    }

    public static int indexOfTheSmallestStartingFrom(int[] table, int startIndex) {
        int theIndexOfSmallest = startIndex;

        for (int i = startIndex; i < table.length; i++) {
            if (table[i] < table[theIndexOfSmallest]) {
                theIndexOfSmallest = i;
            }
        }

        return theIndexOfSmallest;
    }

    public static void swap(int[] table, int index1, int index2) {
        int index1OldValue = table[index1];
        table[index1] = table[index2];
        table[index2] = index1OldValue;
    }

    public static void sort(int[] array) {
        System.out.println(Arrays.toString(array));

        for (int i = 0; i < array.length - 1; i++) {
            int indexOfTheSmallest = indexOfTheSmallestStartingFrom(array, i);
            swap(array, indexOfTheSmallest, i);
            System.out.println(Arrays.toString(array));
        }

    }

    public static void main(String[] args) {
        int[] values = {8, 3, 7, 9, 1, 2, 4};
        sort(values);
    }

}
