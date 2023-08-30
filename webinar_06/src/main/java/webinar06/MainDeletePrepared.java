package webinar06;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MainDeletePrepared {

    public static void main(String[] args) {

        Connection connection  = ConnectionUtil.getConnection();

        try (PreparedStatement statement = connection.prepareStatement("delete from newtable where column1 = ?")) {

            String first = "9";
            statement.setString(1, first);

            statement.execute();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
