package zarovizsga_potpotvizsga.aquarium;

public abstract class Fish {
    protected String name;
    protected int weight;
    protected String colour;
    protected boolean hasMemoryLoss;

    public Fish(String name, int weight, String colour) {
        this.name = name;
        this.weight = weight;
        this.colour = colour;
        this.hasMemoryLoss = false;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return colour;
    }

    public boolean isHasMemoryLoss() {
        return hasMemoryLoss;
    }

    public abstract String status();

    public abstract void feed();

    public abstract Boolean hasMemoryLoss();
}



