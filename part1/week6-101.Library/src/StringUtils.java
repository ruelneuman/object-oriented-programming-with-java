/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rueln
 */
public class StringUtils {

    public static boolean included(String word, String searched) {
        if (word == null || searched == null) {
            return false;
        }
        
        searched = searched.trim().toUpperCase();
        word = word.trim().toUpperCase();
        
        return word.contains(searched);
    }
}
