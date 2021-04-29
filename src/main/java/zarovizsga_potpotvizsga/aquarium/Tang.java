package zarovizsga_potpotvizsga.aquarium;

public class Tang extends Fish {

    public Tang(String name, int weight, String color) {
        super(name, weight, color);
    }

    @Override
    public String status() {
        return (getName()+", weight: "+getWeight()+", color: "+getColor()  + ", short term memory loss: " + isHasMemoryLoss());
    }

    @Override
    public void feed() {
        this.weight=getWeight()+1;

    }

    @Override
    public Boolean hasMemoryLoss() {
        return this.hasMemoryLoss=true;
    }

}
