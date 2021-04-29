package zarovizsga_potvizsga.cleaning;

import java.util.ArrayList;
import java.util.List;

public class CleaningService {

    private List<Cleanable> cleanables = new ArrayList<>();


    public List<Cleanable> getCleanables() {
        return cleanables;
    }

    public void add(Cleanable cleanable) {
        cleanables.add(cleanable);

    }

    public int cleanAll() {
        int sum = 0;
        List<Cleanable> alls= new ArrayList<>();
        for (Cleanable c : cleanables) {
            alls.add(c);
            sum += c.clean();
        }
        cleanables.removeAll(alls);
        return sum;
    }

    public int cleanOnlyOffices() {
        int sum = 0;
        List<Cleanable> offices = new ArrayList<>();
        for (Cleanable c : cleanables) {
            if (c.getLevel()>0) {
                offices.add(c);
                sum += c.clean();
            }
        }
        cleanables.removeAll(offices);
        return sum;
    }




    public List<Cleanable> findByAddressPart(String address) {
        List<Cleanable> result = new ArrayList<>();
        for (Cleanable c : cleanables) {
            if (c.getAddress().contains(address)) {
                result.add(c);
            }
        }
        return result;
    }

    public String getAddresses() {
        StringBuilder sb = new StringBuilder();

        for (Cleanable c : cleanables) {
            sb.append(c.getAddress());
            sb.append(", ");
        }
        return sb.toString().substring(0, sb.length() - 2);
    }

}
