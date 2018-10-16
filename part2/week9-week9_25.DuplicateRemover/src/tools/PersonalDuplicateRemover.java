/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author rueln
 */
public class PersonalDuplicateRemover implements DuplicateRemover {

    private Set<String> words;
    private int duplicateCount;
    
    public PersonalDuplicateRemover() {
        this.words = new HashSet<String>();
        this.duplicateCount = 0;
    }

    @Override
    public void add(String characterString) {
        if (!this.words.add(characterString)) {
            this.duplicateCount++;
        }      
    }

    @Override
    public int getNumberOfDetectedDuplicates() {
        return this.duplicateCount;
    }

    @Override
    public Set<String> getUniqueCharacterStrings() {
        return words;
    }

    @Override
    public void empty() {
        words.clear();
        this.duplicateCount = 0;
    }

}
