package zarovizsga.workhours;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class WorkHours {

//    private String name;
//
//    public String minWork(String path) {
//        try {
//            List<String> lines = Files.readAllLines(Path.of(path));
//            return findMin(lines);
//        } catch
//        (IOException ioe) {
//            throw new IllegalStateException("Can not read file", ioe);
//        }
//    }
//
//    private String findMin(List<String> lines) {
//        int minHours = 24;
//        String result = null;
//        for (String line : lines) {
//            String[] parts = line.split(",");
//            String name = parts[0];
//            int hours = Integer.parseInt(parts[1]);
//            String date = parts[2];
//            if (hours < minHours) {
//                minHours = hours;
//                result = name + ": " + date;
//            }
//
//        }
//        return result;
//    }

    public String minWork(String file) {
        String line;
        try (BufferedReader reader = Files.newBufferedReader(Path.of(file))) {
            int minHours = 24;
            String name = "";
            String date="";
            while ((line = reader.readLine()) != null) {
                String[] result = line.split(",");
                System.out.println(minHours);
                if (Integer.parseInt(result[1]) < minHours) {
                    minHours = Integer.parseInt(result[1]);
                    name = result[0];
                    date=result[2];
                }

            }
            return (name + ": " + date);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }
}

