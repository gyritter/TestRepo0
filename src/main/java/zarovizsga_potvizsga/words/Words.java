package zarovizsga_potvizsga.words;

public class Words {

    public boolean hasMoreDigits(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                count++;
            }
        }

        if ((s.length() - count) >= count || s=="" || s==null) {
            return false;
        }
        return true;
    }
}
