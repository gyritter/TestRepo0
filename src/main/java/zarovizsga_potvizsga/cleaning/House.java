package zarovizsga_potvizsga.cleaning;

public class House implements Cleanable {


    private String address;
    private int surface;

    public int getSurface() {
        return surface;
    }

    public House(String address, int surface) {
        this.address = address;
        this.surface = surface;
    }

    @Override
    public int clean() {
        return surface * 80;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public int getLevel() {
        return 0;
    }

}
