package zarovizsga_potpotvizsga.countchars;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


public class DaVinciCode {
//
//    public int encode(String file, char s) throws IOException {
//
//        if (s != 'x' & s != '1' & s != '0') throw new IllegalArgumentException();
//        BufferedReader reader = Files.newBufferedReader(Path.of(file));
//        String line;
//        int count = 0;
//        while ((line = reader.readLine()) != null) {
//            System.out.println(line);
//
//            for (char c : line.toCharArray()) {
//                if (c == s) {
//                    count++;
//                }
//            }
//        }
//        return count;
//    }
//}

//    public int encode(String file, char s) throws IOException {
//        System.out.println(s);
//        if (s == 'x' || s == '1' || s == '0') {
//            List<String> lines = Files.readAllLines(Path.of(file));
//            int count = 0;
//            for (String line : lines) {
//                System.out.println(line);
//                for (char c : line.toCharArray()) {
//                    if (c == s) {
//                        count++;
//                    }
//
//                }
//            }
//            return count;
//        }
//        throw new IllegalArgumentException();
//    }
//}

    public int encode(String file, char c) throws IOException {
        if (c == '0' || c == '1' || c == 'x') {
            int count = 0;
            try (BufferedReader reader = Files.newBufferedReader(Path.of(file))) {
                String line;

                while ((line = reader.readLine()) != null) {
                    char[] result = line.toCharArray();
                    for (char x : result) {
                        if (x == c) {
                            count++;
                        }
                    }
                }
                return count;
            }

        }
        throw new IllegalArgumentException();
    }
}






