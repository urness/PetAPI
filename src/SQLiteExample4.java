import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SQLiteExample4 {

    /**
     * Return the names of all animals born in a given month (any year)
     * @param month an integer from 1 (January) to 12 (December)
     * @return an ArrayList of Strings -- the names of all animals born in that month
     * @throws SQLException
     */
    public static ArrayList<String> namesBornInMonth(int month) throws SQLException {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("month must be between 1 and 12");
        }
        ArrayList<String> result = new ArrayList<String>();
        // create a database connection
        Connection connection = DriverManager.getConnection("jdbc:sqlite:pets.db");
        Statement statement = connection.createStatement();

        // birthday is stored as YYYY-MM-DD, so strftime('%m', ...) gives the
        // two-digit month, e.g. "08" for August
        String monthStr = String.format("%02d", month);
        String sqlQuery = "SELECT * FROM Pet where strftime('%m', birthday) = '" + monthStr + "'";
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
        ArrayList<String> result = namesBornInMonth(12);
        System.out.println("Here are the animals born in December:");
        for(String s : result)
        {
            System.out.println(s);
        }
        System.out.println("There are " + result.size() + " animals born in December.");
    }

}
