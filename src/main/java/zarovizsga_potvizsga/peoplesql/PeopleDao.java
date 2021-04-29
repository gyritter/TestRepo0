package zarovizsga_potvizsga.peoplesql;

import org.w3c.dom.ls.LSOutput;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PeopleDao {

    private DataSource dataSource;

    //private JdbcTemplate jdbcTemplate;

    public PeopleDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public String findIpByName(String firstName, String lastName) {
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement("SELECT ip_address FROM people WHERE first_name =? and last_name = ?");
        ) {
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);

            return giveBackIP(stmt);
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Error", sqle);
        }
    }

    public String giveBackIP(PreparedStatement stmt) {
        System.out.println(stmt);

        try (
                ResultSet rs = stmt.executeQuery();
        ) {
            while (rs.next()) {
                System.out.println(rs);
                String result= rs.getString("ip_address");
                return result;
            }
        } catch (SQLException sqle) {
            throw new IllegalArgumentException("Error giveBackIP", sqle);
        }
        return null;
    }


}
