
public class Bird {

    private String name;
    private String latinName;
    private int ringingYear;

    public Bird(String name, String latinName, int ringingYear) {
        this.name = name;
        this.latinName = latinName;
        this.ringingYear = ringingYear;
    }

    @Override
    public String toString() {
        return this.latinName + " (" + this.ringingYear + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        Bird compared = (Bird) obj;

        return this.latinName.equals(compared.latinName) && this.ringingYear == compared.ringingYear;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + this.ringingYear;
        hash = 31 * hash + (this.latinName == null ? 0 : this.latinName.hashCode());
        return hash;
    }

}
