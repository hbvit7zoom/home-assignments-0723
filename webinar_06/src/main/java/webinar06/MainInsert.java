package webinar06;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainInsert {

    public static void main(String[] args) {

        Connection connection  = ConnectionUtil.getConnection();

        try (Statement statement = connection.createStatement()) {

            String first = "9";
            String second = "10');drop table newtable;---";
            String query = "insert into newtable(column1, column2) values ('" + first+ "', '" + second +"');";

            System.out.println(query);
            statement.execute(query);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
