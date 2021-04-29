package exam03retake;

import java.util.List;

public class CdvCheck {

//    public Boolean check(String cdv) {
//        if (cdv.length() != 10) throw new IllegalArgumentException();
//        int sum = 0;
//        for (int i = 0; i < 9; i++) {
//            String letter = cdv.substring(i, i + 1);
//            if ((!"0123456789".contains(letter))){
//                throw new IllegalArgumentException();
//            }
//            sum += Integer.parseInt(letter) * (i + 1);
//            }
//
//        if (sum % 11 == (cdv.charAt(9) - '0')) {
//            return true;
//        }
//
//
//        return false;


    public Boolean check (String TaxNo) {
        int result=0;
        for (char c: TaxNo.toCharArray()) {
            if (Character.isLetter(c) || TaxNo.length()!=10) throw new IllegalArgumentException();
        }
        for(int i=0; i<9;i++){
            result+=Integer.parseInt(TaxNo.substring(i,i+1))*(i+1);
        }
        if(result%11==Integer.parseInt(TaxNo.substring(9,10))){
            return true;
        }
        return false;

    }
}
