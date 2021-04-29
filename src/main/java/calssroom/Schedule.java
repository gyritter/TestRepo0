package calssroom;

public class Schedule {

    private String name;
    private String subject;
    private String clss;
    private int numbeOfHours;

    public Schedule(String name, String subject, String clss, int numbeOfHours) {
        this.name = name;
        this.subject = subject;
        this.clss = clss;
        this.numbeOfHours = numbeOfHours;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public String getClss() {
        return clss;
    }

    public int getNumbeOfHours() {
        return numbeOfHours;
    }
}


