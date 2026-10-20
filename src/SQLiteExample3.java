import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SQLiteExample3 {

    /**
     * Count the number of animals of a given color
     * @param color a String
     * @return an integer -- the number of animals in the DB of a certain color
     * @throws SQLException
     */
    public static int countOfColor(String color) throws SQLException {
        // create a database connection
        Connection connection = DriverManager.getConnection("jdbc:sqlite:pets.db");
        Statement statement = connection.createStatement();

        // Return all rows from Pet table
        String sqlQuery = "SELECT count(*) as count FROM Pet where color = '" + color + "'"; 
        ResultSet rs = statement.executeQuery(sqlQuery);
        int result = rs.getInt("count");
        if(connection != null) {
            connection.close();
        }
        return result;
    }

    /**
     * Count the number of animals of a given color and type
     * @param color a String, e.g. "Brown"
     * @param type a String, e.g. "Dog" or "Cat"
     * @return an integer -- the number of animals in the DB of a certain color and type
     * @throws SQLException
     */
    public static int countOfColorAndType(String color, String type) throws SQLException {
        // create a database connection
        Connection connection = DriverManager.getConnection("jdbc:sqlite:pets.db");
        Statement statement = connection.createStatement();

        // Return all rows from Pet table
        String sqlQuery = "SELECT count(*) as count FROM Pet where color = '" + 
                                    color + "' AND type = '" + type + "'"; 
        ResultSet rs = statement.executeQuery(sqlQuery);
        int result = rs.getInt("count");
        if(connection != null) {
            connection.close();
        }
        return result;
    }

    /**
     * Count the number of animals of a given type
     * @param animalType a String, e.g. "Dog" or "Cat"
     * @return an integer -- the number of animals in the DB of a certain type
     * @throws SQLException
     */
    public static int countOfType(String animalType) throws SQLException {
        // create a database connection
        Connection connection = DriverManager.getConnection("jdbc:sqlite:pets.db");
        Statement statement = connection.createStatement();

        // Return count of rows from Pet table
        String sqlQuery = "SELECT count(*) as count FROM Pet where type = '" + animalType + "'"; 
        ResultSet rs = statement.executeQuery(sqlQuery);
        int result = rs.getInt("count");
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

        // Return all rows from Pet table
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

    public static void main(String[] args) throws SQLException 
    {
        ArrayList<String> result = namesOfType("Dog");
        System.out.println("Here are the dogs:");
        for(String s : result)
        {
            System.out.println(s);
        } 
        System.out.println("There are " + countOfType("Dog") + " dogs.");
        System.out.println("There are " + countOfType("Cat") + " cats.");
        System.out.println("There are " + countOfColor("Brown") + " Brown animals.");
        System.out.println("There are " + countOfColorAndType("Brown","Dog") + " Brown dogs.");

    }
    
}
