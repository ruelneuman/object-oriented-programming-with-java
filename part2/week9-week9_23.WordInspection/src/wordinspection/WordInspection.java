/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordinspection;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author rueln
 */
public class WordInspection {

    private File file;

    public WordInspection(File file) {
        this.file = file;
    }

    public int wordCount() throws Exception {
        Scanner reader = new Scanner(file, "UTF-8");
        int lineCount = 0;
        while (reader.hasNextLine()) {
            reader.nextLine();
            lineCount++;
        }
        reader.close();

        return lineCount;
    }

    public List<String> wordsContainingZ() throws Exception {
        Scanner reader = new Scanner(file, "UTF-8");
        List<String> zWords = new ArrayList<String>();

        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            if (line.contains("z")) {
                zWords.add(line);
            }
        }
        reader.close();

        return zWords;
    }

    public List<String> wordsEndingInL() throws Exception {
        Scanner reader = new Scanner(file, "UTF-8");
        List<String> endLWords = new ArrayList<String>();

        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            if (line.endsWith("l")) {
                endLWords.add(line);
            }
        }
        reader.close();

        return endLWords;
    }

    public List<String> palindromes() throws Exception {
        Scanner reader = new Scanner(file, "UTF-8");
        List<String> palindromes = new ArrayList<String>();

        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            if (isPalindrome(line)) {
                palindromes.add(line);
            }
        }
        reader.close();

        return palindromes;
    }

    private Boolean isPalindrome(String word) {
        for (int i = 0; i < word.length() / 2; i++) {
            if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public List<String> wordsWhichContainAllVowels() throws Exception {
        Scanner reader = new Scanner(file, "UTF-8");
        List<String> wordsWithAllVowels = new ArrayList<String>();

        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            if (containsAllVowels(line)) {
                wordsWithAllVowels.add(line);
            }
        }
        reader.close();

        return wordsWithAllVowels;
    }

    private Boolean containsAllVowels(String word) {
        String vowels = "aeiouyäö";
        for (char vowel : vowels.toCharArray()) {
            if (!word.contains("" + vowel)) {
                return false;
            }
        }
        return true;
    }

}
