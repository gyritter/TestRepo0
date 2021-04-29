package zarovizsga_potpotvizsga.aquarium;

import zarovizsga_potpotvizsga.aquarium.Fish;

public class Kong extends Fish {
    public Kong(String name, int weight, String color) {
        super(name, weight, color);
    }


    @Override
    public String status() {
        return (getName()+", weight: "+getWeight()+", color: "+getColor()  + ", short term memory loss: " + isHasMemoryLoss());
    }

    @Override
    public void feed() {
        this.weight=getWeight()+2;

    }

    @Override
    public Boolean hasMemoryLoss() {
        return this.hasMemoryLoss=false;
    }


}
