package kepesitovizsga_gyakorlas.vaccine;

public class Person {
    private String name;
    private int age;
    private ChronicDisease chronic;
    private Pregnancy pregnant;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public ChronicDisease getChronic() {
        return chronic;
    }

    public Pregnancy getPregnant() {
        return pregnant;
    }

    public Person(String name) {
        this.name = name;

    }
}
