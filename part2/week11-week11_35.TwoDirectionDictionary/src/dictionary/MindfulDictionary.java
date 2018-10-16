/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MindfulDictionary {

    private Map<String, String> dictionary;
    private Map<String, String> reverseDictionary;
    private File file;

    public MindfulDictionary() {
        this.dictionary = new HashMap<String, String>();
        this.reverseDictionary = new HashMap<String, String>();
    }

    public MindfulDictionary(String file) {
        this();
        this.file = new File(file);
    }

    public void add(String word, String translation) {
        if (!this.dictionary.containsKey(word) && !this.reverseDictionary.containsKey(word)
                && !this.dictionary.containsKey(translation) && !this.reverseDictionary.containsKey(translation)) {
            this.dictionary.put(word, translation);
            this.reverseDictionary.put(translation, word);
        }
    }

    public String translate(String word) {
        if (this.dictionary.containsKey(word)) {
            return this.dictionary.get(word);
        } else if (this.reverseDictionary.containsKey(word)) {
            return this.reverseDictionary.get(word);
        }
        return null;
    }

    public void remove(String word) {
        if (this.dictionary.containsKey(word)) {
            String translation = this.dictionary.get(word);
            this.dictionary.remove(word);
            this.reverseDictionary.remove(translation);
        } else if (this.reverseDictionary.containsKey(word)) {
            String translation = this.reverseDictionary.get(word);
            this.reverseDictionary.remove(word);
            this.dictionary.remove(translation);
        }

    }

    public boolean load() {
        try {
            Scanner reader = new Scanner(this.file);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] parts = line.split(":");
                this.add(parts[0], parts[1]);
            }
            return true;
        } catch (FileNotFoundException ex) {
            return false;
        }
    }

    public boolean save() {
        try {
            FileWriter writer = new FileWriter(this.file);
            for (String key : this.dictionary.keySet()) {
                writer.write(key + ":" + this.dictionary.get(key) + "\n");
            }
            writer.close();
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

}
