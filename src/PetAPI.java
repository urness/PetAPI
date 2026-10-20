/*
 * Methods for querying the Pet table in pets.db.
 * Run CreateDB first if pets.db does not exist.
 * @author T. Urness
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class PetAPI {

    /**
     * Return the names of all animals in the database
     * @return an ArrayList of Strings -- the names of all animals
     * @throws SQLException
     */
    public static ArrayList<String> allNames() throws SQLException {
        ArrayList<String> result = new ArrayList<String>();
        // create a database connection
        Connection connection = DriverManager.getConnection("jdbc:sqlite:pets.db");
        Statement statement = connection.createStatement();

        // Return all rows from Pet table
        String sqlQuery = "SELECT * FROM Pet";
        ResultSet rs = statement.executeQuery(sqlQuery);
        while(rs.next())
        {
            result.add(rs.getString("name"));
        }
        if(connection != null) {
            connection.close();
        }
        return result;
    }

    /**
     * Return the names of all animals of a given type
     * @param animalType a String e.g. "Dog" or "Cat"
     * @return an ArrayList of Strings -- the names of all animals of a given type
     * @throws SQLException
     */
    public static ArrayList<String> namesOfType(String animalType) throws SQLException {
        ArrayList<String> result = new ArrayList<String>();
        // create a database connection
        Connection connection = DriverManager.getConnection("jdbc:sqlite:pets.db");
        Statement statement = connection.createStatement();

        // Return all rows of the given type from Pet table
        String sqlQuery = "SELECT * FROM Pet where type = '" + animalType + "'";
        ResultSet rs = statement.executeQuery(sqlQuery);
        while(rs.next())
        {
            result.add(rs.getString("name"));
        }
        if(connection != null) {
            connection.close();
        }
        return result;
    }

    /**
     * Return the names of all animals whose birthday falls within the next
     * given number of days (including today)
     * @param days the number of days ahead to look, e.g. 30
     * @return an ArrayList of Strings -- each entry is a name followed by the birthday
     * @throws SQLException
     */
    public static ArrayList<String> namesWithUpcomingBirthday(int days) throws SQLException {
        ArrayList<String> result = new ArrayList<String>();
        LocalDate today = LocalDate.now();
        // create a database connection
        Connection connection = DriverManager.getConnection("jdbc:sqlite:pets.db");
        Statement statement = connection.createStatement();

        // Return all rows that have a birthday, sorted by month and day
        String sqlQuery = "SELECT * FROM Pet where birthday IS NOT NULL " +
                          "ORDER BY strftime('%m-%d', birthday)";
        ResultSet rs = statement.executeQuery(sqlQuery);
        while(rs.next())
        {
            // birthday is stored as YYYY-MM-DD
            LocalDate birthday = LocalDate.parse(rs.getString("birthday"));
            // next birthday is this year's, or next year's if it already passed
            // (withYear moves Feb 29 to Feb 28 in non-leap years)
            LocalDate next = birthday.withYear(today.getYear());
            if(next.isBefore(today)) {
                next = birthday.withYear(today.getYear() + 1);
            }
            long daysUntil = ChronoUnit.DAYS.between(today, next);
            if(daysUntil <= days) {
                result.add(rs.getString("name") + " (" + next + ")");
            }
        }
        if(connection != null) {
            connection.close();
        }
        return result;
    }

}
