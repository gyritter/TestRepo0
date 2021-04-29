package product;

public enum Currency {HUF(300), USD(1);
    private long conversion;

    Currency(long conversion) {
        this.conversion = conversion;
    }

    public long getConversion() {
        return conversion;
    }
}
