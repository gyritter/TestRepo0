package kepesitovizsga_gyakorlas.vaccine;

import org.mariadb.jdbc.MariaDbDataSource;

import java.util.List;

public abstract class Vaccine {

    protected List<Person> persons;
    private MariaDbDataSource dataSource;


    public Vaccine(List<Person> persons, MariaDbDataSource dataSource) {
        this.persons = persons;
        this.dataSource = dataSource;

    }

    public List<Person> getPersons() {
        return persons;
    }

    public abstract List <Person> getVaccinationList();

}
