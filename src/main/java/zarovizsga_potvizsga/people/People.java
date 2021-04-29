package zarovizsga_potvizsga.people;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class People {

    int getNumberOfMales(String path) {
        try (BufferedReader reader = Files.newBufferedReader(Path.of(path))) {
            String line;
            int count = 0;
            while ((line = reader.readLine()) != null) {
                String[] div = line.split(",");
                if (div[4].equals("Male"))
                    count++;
            }
            return count;
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file", ioe);
        }
    }


}


