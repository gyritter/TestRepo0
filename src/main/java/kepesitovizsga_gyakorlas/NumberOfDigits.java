package kepesitovizsga_gyakorlas;

public class NumberOfDigits {

    public int getNumberOfDigits(int number) {
        int count = 0;
        int c = 0;
        if (number > 0) c = 2;
        if (number < 0){
            c = 0;
            number=-1*number;
        }
        if (number == 0) c = 1;

        int d = Integer.toString(number).length();
        String s = "9";
        s=s.repeat(d - 1);
        int y = Integer.parseInt(s);
        System.out.println(d);
        System.out.println(y);

        switch (c) {
            case 2:

                return (number - y) * d + y;

            case 0:

                return (number - y) * d + y + 1;

            case 1:
                return 1;

        }
        return 0;


    }

    public static void main(String[] args) {
        NumberOfDigits numberOfDigits = new NumberOfDigits();

        System.out.println(numberOfDigits.getNumberOfDigits(100));
    }
}
