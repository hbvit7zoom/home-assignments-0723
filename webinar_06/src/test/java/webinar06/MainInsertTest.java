package webinar06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.DatabaseException;
import liquibase.exception.LiquibaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import org.junit.Assert;
import org.junit.Test;
import org.testcontainers.containers.PostgreSQLContainer;

public class MainInsertTest {

    PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer<>("postgres:13.10-alpine");

    @Test
    public void testSimpleSelect() {
        postgreSQLContainer.start();

        String jdbcUrl = postgreSQLContainer.getJdbcUrl();
        String username = postgreSQLContainer.getUsername();
        String password = postgreSQLContainer.getPassword();

        System.out.println(jdbcUrl);
        System.out.println(username);
        System.out.println(password);

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(jdbcUrl, username, password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }

//        try {
//            ResultSet resultSet = connection.createStatement().executeQuery("SELECT 1");
//            resultSet.next();
//            int i = resultSet.getInt(1);
//            System.out.println(i);
//            Assert.assertEquals(1, i);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

        try (Database database = DatabaseFactory.getInstance()
                .findCorrectDatabaseImplementation(new JdbcConnection(connection))) {
            Liquibase liquibase = new Liquibase("db/changelog.xml", new ClassLoaderResourceAccessor(), database);
            liquibase.update();
        } catch (DatabaseException e) {
            throw new RuntimeException(e);
        } catch (LiquibaseException e) {
            throw new RuntimeException(e);
        }

//        try {
//            connection.close();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//
//        try {
//            connection = DriverManager.getConnection(jdbcUrl, username, password);
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//            throw new RuntimeException();
//        }

        try (Statement statement = connection.createStatement()) {

            String first = "9";
            String second = "10";
            String query = "insert into newtable(column1, column2) values ('" + first+ "', '" + second +"');";

            System.out.println(query);
            statement.execute(query);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



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