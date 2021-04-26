package zarovizsga_potpotvizsga.uniquefinder;

import java.util.ArrayList;
import java.util.List;

public class UniqueFinder {

    public List<Character> uniqueChars(String input) {
        List<Character> result = new ArrayList<>();
        if (input == null) throw new IllegalArgumentException();
        for (char c : input.toCharArray()) {
            if (!result.contains(c)) {
                result.add(c);
            }

        }
        return result;


    }


}
