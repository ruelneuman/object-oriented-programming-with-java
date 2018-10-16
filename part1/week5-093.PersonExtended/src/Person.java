
import java.util.Calendar;

public class Person {

    private String name;
    private MyDate birthday;

    public Person(String name, MyDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public Person(String name, int pp, int kk, int vv) {
        this(name, new MyDate(pp, kk, vv));
    }

    public Person(String name) {
        this.name = name;
        Calendar nyt = Calendar.getInstance();
        int year = nyt.get(Calendar.YEAR);
        int month = nyt.get(Calendar.MONTH) + 1;
        int day = nyt.get(Calendar.DATE);
        this.birthday = new MyDate(day, month, year);
    }

    public int age() {
        Calendar now = Calendar.getInstance();

        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH) + 1;
        int day = now.get(Calendar.DATE);

        return birthday.differenceInYears(new MyDate(day, month, year));
    }

    public boolean olderThan(Person compared) {
        return this.birthday.earlier(compared.birthday);
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return this.name + ", born " + this.birthday;
    }
}
