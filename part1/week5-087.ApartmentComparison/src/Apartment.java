
public class Apartment {

    private int rooms;
    private int squareMeters;
    private int pricePerSquareMeter;

    public Apartment(int rooms, int squareMeters, int pricePerSquareMeter) {
        this.rooms = rooms;
        this.squareMeters = squareMeters;
        this.pricePerSquareMeter = pricePerSquareMeter;
    }

    public boolean larger(Apartment otherApartment) {
        return this.squareMeters > otherApartment.squareMeters;
    }

    private int price() {
        return pricePerSquareMeter * squareMeters;
    }

    public int priceDifference(Apartment otherApartment) {
        int difference = this.price() - otherApartment.price();
        return Math.abs(difference);
    }

    public boolean moreExpensiveThan(Apartment otherApartment) {
        return this.price() > otherApartment.price();
    }
}
