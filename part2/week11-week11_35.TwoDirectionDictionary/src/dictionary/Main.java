package dictionary;

public class Main {

    public static void main(String[] args) {
        MindfulDictionary dict = new MindfulDictionary("src/words.txt");
        dict.load();
        dict.add("hello", "bye");
        dict.add("what", "bye");
        dict.add("what", "gooooo");

        dict.save();
    }
}
