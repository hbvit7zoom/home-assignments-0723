package webinar06;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainSelect {

//    CREATE TABLE public.newtable (
//            column1 varchar NOT NULL,
//            column2 varchar NULL,
//            CONSTRAINT newtable_pk PRIMARY KEY (column1)
//    );
    public static void main(String[] args) {

        Connection connection  = ConnectionUtil.getConnection();

        try (Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("select * from newtable");

            while (resultSet.next()) {
//                String first = resultSet.getString(1);
//                String second = resultSet.getString(2);

                String first = resultSet.getString("column1");
                String second = resultSet.getString("column2");

                System.out.println("First: " + first + " second: " + second);
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
