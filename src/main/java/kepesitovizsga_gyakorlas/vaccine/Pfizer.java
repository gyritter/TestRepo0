package kepesitovizsga_gyakorlas.vaccine;

import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Pfizer extends Vaccine {
    private MariaDbDataSource dataSource;

    public Pfizer(List<Person> persons, MariaDbDataSource dataSource, MariaDbDataSource dataSource1) {
        super(persons, dataSource);
        this.dataSource = dataSource1;
    }

    @Override
    public List<Person> getVaccinationList() {
            try (
                    Connection conn = dataSource.getConnection();
                    PreparedStatement stmt =
                            conn.prepareStatement("SELECT * from  vaccine WHERE pregnancy =?");

            ) {
                stmt.setString(1, "igen");



                return giveBackList(stmt);
            } catch (SQLException sqle) {
                throw new IllegalArgumentException("Error", sqle);
            }
        }

        public List<Person> giveBackList(PreparedStatement stmt) {
        List <Person> result= new ArrayList<>();
            try (
                    ResultSet rs = stmt.executeQuery();
            ) {
                while (rs.next()) {
                   String name= rs.getString("person_name");
//                   int age= rs.getInt("age INT");
//                   String chronic_disease= rs.getString("chronic_disease");
//                   String pregnancy= rs.getString("pregnancy");
                   result.add(new Person(name));
                    System.out.println(result);
                    return result;
                }
            } catch (SQLException sqle) {
                throw new IllegalArgumentException("Error giveBackList", sqle);
            }
            return null;
        }

    }

