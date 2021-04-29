package exam03;

import java.io.BufferedReader;
import java.io.IOException;

public class Histogram {

//    public String createHistogram(BufferedReader reader) throws IOException {
//        String line;
//        StringBuilder sb = new StringBuilder();
//        while ((line = reader.readLine()) != null) {
//            //System.out.println(line);
//            for (int i = 1; i <= Integer.parseInt(line); i++) {
//                sb = sb.append("*");
//
//            }
//sb= sb.append("\n");
//        }
//        return sb.toString();


    public String createHistogram(BufferedReader reader) throws IOException {
        String line;
        StringBuilder sb = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            sb.append("*".repeat(Integer.parseInt(line))).append("\n");

        }
        return sb.toString();

    }

}
