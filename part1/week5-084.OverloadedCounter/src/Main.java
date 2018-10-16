
public class Main {

    public static void main(String[] args) {
        // write testcode here
        Counter counter1 = new Counter(2, true);
        counter1.decrease(4);
        System.out.println(counter1.value());
    }
}
