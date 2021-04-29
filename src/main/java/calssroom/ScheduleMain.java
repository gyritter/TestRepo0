package calssroom;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ScheduleMain {
    List<Schedule> sched= new ArrayList<>();

    public void readLines(BufferedReader reader) throws IOException {
        String line;
        while ((line = reader.readLine())  != null) {
           String subject=reader.readLine();
            String clss=reader.readLine();
            int num=Integer.parseInt(reader.readLine());
            sched.add(new Schedule(line,subject,clss,num));
        }
    }
    public int getNumberOfHoursPerTeacher(String name){
        int count=0;
        for(Schedule s:sched){
            if(s.getName().equals(name)){
                count+=s.getNumbeOfHours();
            }
        }
        return count;
    }

    public static void main(String[] args) {
        ScheduleMain schedule= new ScheduleMain();
            try (BufferedReader reader = Files.newBufferedReader(Path.of("beosztas.txt"))) {
                schedule.readLines(reader);
            } catch (IOException ioe) {
                throw new IllegalStateException("Can not read file", ioe);
            }
        System.out.println(schedule.getNumberOfHoursPerTeacher("Csincsilla Csilla"));
        }

}
