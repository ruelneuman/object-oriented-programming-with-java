
public class Reformatory {

    private int weightCount;

    public Reformatory() {
        this.weightCount = 0;
    }
    
    public int weight(Person person) {
        // return the weight of the person
        this.weightCount++;
        return person.getWeight();
    }

    public void feed(Person person) {
        int weight = person.getWeight();
        weight++;
        person.setWeight(weight);
    }

    public int totalWeightsMeasured() {
        return this.weightCount;
    }

}
