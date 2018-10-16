
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author rueln
 */
public class Contact implements Comparable<Contact> {

    private String name;
    private String address;
    private Set<String> phoneNumbers;

    public Contact(String name) {
        this.name = name;
        this.address = "address unknown";
        this.phoneNumbers = new HashSet<String>();
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public Set<String> getPhoneNumbers() {
        return this.phoneNumbers;
    }

    public void setAddress(String street, String city) {
        this.address = street + " " + city;
    }

    public void addPhoneNumber(String phoneNumber) {
        this.phoneNumbers.add(phoneNumber);
    }
      
    @Override
    public int compareTo(Contact contact) {
        return this.name.compareToIgnoreCase(contact.getName());
    }

}
