package product;

public class Prod {

    private Long price;
    private Currency currency;

    public Prod(Long price, Currency currency) {
        this.price = price;
        this.currency = currency;
    }


    public double convertPrice(Currency currency) {
        if (this.currency == (currency)) {
            return this.price;
        }
        if (this.currency == (Currency.HUF)) {
            return (double) this.price / Currency.HUF.getConversion();
        }
        return this.price * Currency.HUF.getConversion();
    }
}

