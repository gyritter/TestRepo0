package zarovizsga_potvizsga.cleaning;

public class Office implements Cleanable{
    private String address;
    private int surface;
    private int level;

    public Office(String address, int surface, int level) {
        this.address = address;
        this.surface = surface;
        this.level = level;
    }

    public int getSurface() {
        return surface;
    }


    @Override
    public int clean() {
        return surface*100*level;
    }

    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public int getLevel() {
        return level;
    }

}
