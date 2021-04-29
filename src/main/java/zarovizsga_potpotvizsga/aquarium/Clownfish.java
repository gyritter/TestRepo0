package zarovizsga_potpotvizsga.aquarium;

//public class Clownfish extends Fish{
//    public Clownfish(String name, int weight, String color) {
//        super(name, weight, color);
//    }
//
//    @Override
//    public String status() {
//        return (getName()+", weight: "+getWeight()+", color: "+getColor()  + ", short term memory loss: " + getShortTermMemoryLoss());
//    }
//
//    @Override
//    public void feed() {
//        this.weight=getWeight()+1;
//
//    }
//
//    @Override
//    public Boolean hasMemoryLoss() {
//        return this.shortTermMemoryLoss;
//    }
//
//
//}

public class Clownfish extends Fish{
    public Clownfish(String name, int weight, String colour) {
        super(name, weight, colour);
    }


    @Override
    public String status() {
        return (getName() + (", weight: ") + getWeight() + (", color: ") + getColor() + (", short-term memory loss:") + isHasMemoryLoss());
    }

    @Override
    public void feed() {
        this.weight=weight+1;
    }

    @Override
    public Boolean hasMemoryLoss() {
        return this.hasMemoryLoss=false;
    }
}
