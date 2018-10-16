package wordinspection;

import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception{
        // test your code here

        File file = new File("src/shortList.txt");
        // all words are in file src/wordList.txt

        WordInspection inspection = new WordInspection(file);

        System.out.println("Number of words: " + inspection.wordCount());
        System.out.println("");
        System.out.println("Words containing \"z\": " + inspection.wordsContainingZ());
        System.out.println("");  
        System.out.println("Words ending in \"l\": " + inspection.wordsEndingInL());
        System.out.println("");
        System.out.println("Palindromes: " + inspection.palindromes());
        System.out.println("");
        System.out.println("Words containg all vowels: " + inspection.wordsWhichContainAllVowels());
    }
}
