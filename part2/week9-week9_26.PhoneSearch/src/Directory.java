
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author rueln
 */
public class Directory {

    private Set<Contact> contacts;

    public Directory() {
        this.contacts = new HashSet();
    }

    public void addNumber(String number, String name) {
        Contact contact = searchByName(name);
        if (contact == null) {
            contact = new Contact (name);
            this.contacts.add(contact);
        }
        contact.addPhoneNumber(number);
    }

    public void addAddress(String street, String city, String name) {
        Contact contact = searchByName(name);
        if (contact == null) {
            contact = new Contact (name);
            this.contacts.add(contact);
        }
        contact.setAddress(street, city);
    }

    public Contact searchByName(String name) {
        for (Contact contact : this.contacts) {
            if (contact.getName().equals(name)) {
                return contact;
            }
        }
        return null;
    }

    public Contact searchByNum(String number) {
        for (Contact contact : this.contacts) {
            if (hasNumber(number, contact)) {
                return contact;
            }
        }
        return null;
    }

    public void clearContact(Contact contact) {
        this.contacts.remove(contact);
    }

    public List<Contact> filteredList(String keyword) {
        List<Contact> filteredList = new ArrayList<Contact>();

        for (Contact contact : this.contacts) {
            if (containsKeyword(keyword, contact)) {
                filteredList.add(contact);
            }
        }

        Collections.sort(filteredList);
        return filteredList;
    }

    private Boolean hasNumber(String number, Contact contact) {
        Set<String> numbers = contact.getPhoneNumbers();
        return numbers.contains(number);
    }

    private Boolean containsKeyword(String keyword, Contact contact) {
        return contact.getName().contains(keyword) || contact.getAddress().contains(keyword);
    }

}
