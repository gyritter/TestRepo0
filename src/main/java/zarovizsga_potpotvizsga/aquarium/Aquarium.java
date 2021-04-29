package zarovizsga_potpotvizsga.aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {

    private List<Fish> fishes = new ArrayList();

    public Aquarium() {
    }

    public void addFish(Fish f) {
        fishes.add(f);
        f.hasMemoryLoss();

    }

    public void feed() {
        for (Fish f : fishes) {
            f.feed();
        }
    }

    public void removeFish() {
        List<Fish> fishesToRemove = new ArrayList<>();
        for (Fish f : fishes) {
            if (f.getWeight() > 10) {
                fishesToRemove.add(f);

            }
        }
        fishes.removeAll(fishesToRemove);
    }

    public List<String> getStatus() {
        List<String> result = new ArrayList<>();
        for (Fish f : fishes) {
            result.add(f.status());
        }
        return result;
    }
}
