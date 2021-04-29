package activitytracker;

import org.mariadb.jdbc.MariaDbDataSource;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ActivityTrackerMain {

    public static void main(String[] args) {
        ActivityTrackerMain activityTrackerMain= new ActivityTrackerMain();
        Activity activity1 = new Activity(LocalDateTime.of(2021, 02, 28, 6, 15), "túrázás", Type.HIKING);
        Activity activity2 = new Activity(LocalDateTime.of(2021, 02, 10, 8, 38), "tókör", Type.RUNNING);
        Activity activity3 = new Activity(LocalDateTime.of(2021, 01, 12, 16, 47), "kosár a téren", Type.BASKETBALL);
        Activity activity4 = new Activity(LocalDateTime.of(2021, 03, 8, 12, 21), "bicikli agárd", Type.BIKING);

        List<Activity> activities= new ArrayList<>();
        activities.add(activity1);
        activities.add(activity2);
        activities.add(activity3);
        activities.add(activity4);


        MariaDbDataSource dataSource;
        try {
            dataSource = new MariaDbDataSource();
            dataSource.setUrl("jdbc:mariadb://localhost:3306/atracker?useUnicode=true");
            dataSource.setUser("atracker");
            dataSource.setPassword("atracker");
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Connection failed!", sqlException);
        }

       /* try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("insert into activities(start_time,activity_desc,activity_type) values (?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {

            for(int i=1; i<activities.size();i++) {
                stmt.setTimestamp(1, Timestamp.valueOf(activities.get(i).getStartTime()));
                stmt.setString(2, activities.get(i).getDesc());
                stmt.setString(3, activities.get(i).getType().toString());
                stmt.executeUpdate();
            }

        } catch (SQLException sqlException) {
            throw new IllegalStateException("Connection failed!", sqlException);
        }*/

        //System.out.println(activityTrackerMain.selectActivityById(4,dataSource));
        System.out.println(activityTrackerMain.selectAllActivities(dataSource));
    }


    private List<Activity> selectActivityByPreparedSatement(PreparedStatement stmt) {
        List<Activity> result = new ArrayList<>();
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Activity activity = new Activity(rs.getLong("id"),
                        rs.getTimestamp("start_time").toLocalDateTime(),
                        rs.getString("activity_desc"),
                        Type.valueOf(rs.getString("activity_type")));
                result.add(activity);
            }
            return result;
        } catch (SQLException sqlException) {
            throw new IllegalStateException("Cannot execute", sqlException);
        }
    }

    public Activity selectActivityById(long id, DataSource dataSource) {
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt1 = conn.prepareStatement("select * from activities where id =?")) {
            //PreparedStatement stmt2 = conn.prepareStatement("select * from track_points where activityid = ?"))
            stmt1.setLong(1, id);
            List<Activity> result = selectActivityByPreparedSatement(stmt1);
            return result.get(0);
           /* if (result.size() == 1) {
                stmt2.setLong(1,id);
                List<TrackPoint> resultPoints = selectTrackPointsByPreparedSatement(stmt2);
                result.get(0).addTrackPoints(resultPoints);
                return result.get(0);
            }
            throw new IllegalArgumentException("Wrong ID");*/

        } catch (SQLException sqlException) {
            throw new IllegalStateException("Connection failed!", sqlException);
        }
    }

        public List <Activity> selectAllActivities (DataSource dataSource){
            try (Connection conn = dataSource.getConnection();
                 PreparedStatement stmt1 = conn.prepareStatement("select * from activities")) {
                //PreparedStatement stmt2 = conn.prepareStatement("select * from track_points where activityid = ?"))
                List<Activity> result = selectActivityByPreparedSatement(stmt1);
                return result;
           /* if (result.size() == 1) {
                stmt2.setLong(1,id);
                List<TrackPoint> resultPoints = selectTrackPointsByPreparedSatement(stmt2);
                result.get(0).addTrackPoints(resultPoints);
                return result.get(0);
            }
            throw new IllegalArgumentException("Wrong ID");*/

            } catch (SQLException sqlException) {
                throw new IllegalStateException("Connection failed!", sqlException);
            }
        }
    }



