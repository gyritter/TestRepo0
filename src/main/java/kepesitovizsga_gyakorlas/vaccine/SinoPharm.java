package kepesitovizsga_gyakorlas.vaccine;

import org.mariadb.jdbc.MariaDbDataSource;

import java.util.List;

public class SinoPharm extends Vaccine{
    private MariaDbDataSource dataSource;

    public SinoPharm(List<Person> persons, MariaDbDataSource dataSource, MariaDbDataSource dataSource1) {
        super(persons, dataSource);
        this.dataSource = dataSource1;
    }

    @Override
    public List<Person> getVaccinationList() {
        return null;
    }
}
