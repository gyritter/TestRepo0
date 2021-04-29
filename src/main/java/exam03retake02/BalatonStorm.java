package exam03retake02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.Collator;
import java.util.*;

public class BalatonStorm {

//    public List<String> getStationsInStorm(BufferedReader reader) {
//        List<String> result = new ArrayList<>();
//        String line;
//        String station="";
//        try {
//            while ((line = reader.readLine()) != null) {
//
//                if (line.contains("allomas")) {
//                    String[] div = line.split(": ");
//                    station = div[1].substring(1, div[1].length() - 2);
//                }
//                if (line.contains("level")) {
//                    String[] div = line.split(": ");
//                    int level = Integer.parseInt(div[1].substring(0, div[1].length() - 1));
//                    if (level == 3) {
//                        result.add(station);
//                    }
//                }
//
//            }
//
//        } catch (IOException ioe) {
//            throw new IllegalStateException("Can not read file", ioe);
//        }
//        Collections.sort(result, Collator.getInstance(new Locale("hu", "HU")));
//        return result;
//    }



    public List <String> getStationsInStorm (BufferedReader reader) throws IOException {
        List <String> result= new ArrayList<>();
        String line;
        while ((line = reader.readLine())  != null) {
           if(line.contains("allomas")){
               String station= isStorm(line, reader);
             if( !station.isBlank()){
                 result.add(station);
             }

               }
           }
        Collections.sort(result,Collator.getInstance(new Locale("hu", "HU")));
        return result;

        }

    private String isStorm(String line, BufferedReader reader) throws IOException{
        String állomás = line;
        reader.readLine();
        reader.readLine();
        reader.readLine();
        line = reader.readLine();
        String[] parts = line.split(":");
        if (Integer.parseInt(parts[1].substring(1,2)) == 3) {
            String[] div = állomás.split(":");

            return div[1].substring(2, div[1].length() - 2);
        }
        return"";
    }

}



