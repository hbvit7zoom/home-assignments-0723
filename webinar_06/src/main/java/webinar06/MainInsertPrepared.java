package webinar06;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class MainInsertPrepared {

    public static void main(String[] args) {

        Connection connection  = ConnectionUtil.getConnection();

        try (PreparedStatement statement = connection.prepareStatement("insert into newtable(column1, column2) values (?, ?);")) {

            String first = "9";
            String second = "10');drop table newtable;---";
            statement.setString(1, first);
            statement.setString(2, second);

            statement.execute();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
