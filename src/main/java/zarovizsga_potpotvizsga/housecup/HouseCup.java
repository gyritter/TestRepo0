package zarovizsga_potpotvizsga.housecup;


import org.w3c.dom.ls.LSOutput;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

    public class HouseCup {

        private DataSource dataSource;

        public HouseCup(DataSource dataSource) {
            this.dataSource = dataSource;
        }

        public int getPointsOfHouse(String house) {
            try (
                    Connection conn = dataSource.getConnection();
                    PreparedStatement stmt =
                      //      conn.prepareStatement("SELECT * FROM house_points WHERE house_name =?");
                    conn.prepareStatement("Select Sum(points_earned) as sum_points FROM house_points WHERE house_name =?");
            ) {
                stmt.setString(1, house);


                return giveBackPoints(stmt);
            } catch (SQLException sqle) {
                throw new IllegalArgumentException("Error", sqle);
            }
        }

        public int giveBackPoints(PreparedStatement stmt) {
            System.out.println(stmt);
            int result=0;
            System.out.println(result);

            try (
                    ResultSet rs = stmt.executeQuery();
            ) {
                while (rs.next()) {
                    System.out.println(rs);

                  //  result+=  rs.getInt("points_earned");
                    result = rs.getInt("sum_points");

                }
            } catch (SQLException sqle) {
                throw new IllegalArgumentException("Error no point found", sqle);
            }
            return result;
        }



    }
