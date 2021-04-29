package activitytracker;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActivityDao {
    private DataSource dataSource;

    public ActivityDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Activity saveActivity(Activity activity){
        try (Connection conn = dataSource.getConnection();
             PreparedStatement stmt = conn.prepareStatement("insert into activities(start_time,activity_desc,activity_type) values (?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            stmt.setTimestamp(1, Timestamp.valueOf(activity.getStartTime()));
            stmt.setString(2, activity.getDesc());
            stmt.setString(3, activity.getType().toString());
            stmt.executeUpdate();
            Activity result = getIdAfterExecuted(activity, stmt);
            return result;

        } catch (SQLException sqlException) {
            throw new IllegalStateException("Connection failed!", sqlException);
        }
    }
    public Activity findActivityById(long id) {
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
    private Activity getIdAfterExecuted(Activity activity, PreparedStatement stmt) throws SQLException {
        try (ResultSet rs = stmt.getGeneratedKeys()) {
            if (rs.next()) {
                long id = rs.getLong(1);
                return new Activity(id, activity.getStartTime(), activity.getDesc(), activity.getType());
            }
        }
        throw new IllegalArgumentException("Cannot get key");
    }

}
