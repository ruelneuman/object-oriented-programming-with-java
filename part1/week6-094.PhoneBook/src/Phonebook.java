/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rueln
 */
import java.util.ArrayList;

public class Phonebook {

    private ArrayList<Person> phonebook;

    public Phonebook() {
        this.phonebook = new ArrayList<Person>();
    }

    public void add(String name, String number) {
        this.phonebook.add(new Person(name, number));
    }

    public void printAll() {
        for (Person person : this.phonebook) {
            System.out.println(person);
        }
    }

    public String searchNumber(String name) {
        for (Person person : this.phonebook) {
            if (person.getName().equals(name)) {
                return person.getNumber();
            }
        }
        return "number not known";
    }
    
}
