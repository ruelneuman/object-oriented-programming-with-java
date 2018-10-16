
public class Money {

    private final int euros;
    private final int cents;

    public Money(int euros, int cents) {

        if (cents > 99) {
            euros += cents / 100;
            cents %= 100;
        }

        this.euros = euros;
        this.cents = cents;
    }

    public int euros() {
        return euros;
    }

    public int cents() {
        return cents;
    }

    @Override
    public String toString() {
        String zero = "";
        if (cents < 10) {
            zero = "0";
        }

        return euros + "." + zero + cents + "e";
    }

    public Money plus(Money added) {
        int newTotalCents = 100 * (this.euros + added.euros) + (this.cents + added.cents);
        return new Money(0, newTotalCents);
    }

    public boolean less(Money compared) {
        return (this.euros == compared.euros && this.cents < compared.cents)
                || this.euros < compared.euros;
    }

    public Money minus(Money decremented) {
        if (this.less(decremented)) {
            return new Money(0, 0);
        }
        int newTotalCents = 100 * (this.euros - decremented.euros) + (this.cents - decremented.cents);
        return new Money(0,newTotalCents);
    }
}
