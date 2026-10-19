/*
 * Creates pets.db and populates the Pet table with sample data.
 * Running this program again resets the table and its contents.
 * @author T. Urness
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDB {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:pets.db";

        // try-with-resources automatically closes the connection and statement.
        try (Connection connection = DriverManager.getConnection(url);
             Statement statement = connection.createStatement()) {

            // WARNING: Deletes the existing Pet table and all its records.
            // This allows us to start with the same sample data each time.
            statement.executeUpdate("DROP TABLE IF EXISTS Pet");

            String sql = "CREATE TABLE Pet (" +
                    "id INTEGER PRIMARY KEY, " +
                    "name TEXT NOT NULL, " +
                    "type TEXT, " +
                    "birthday TEXT, " +       // Dates stored as YYYY-MM-DD
                    "lastVaccine TEXT, " +    // Dates stored as YYYY-MM-DD
                    "gender TEXT, " +
                    "color TEXT, " +
                    "spayedNeutered BOOLEAN, " + // SQLite stores true/false as 1/0
                    "breed TEXT" +
                    ")";
            statement.executeUpdate(sql);

            // Insert the sample pets into the database.
            statement.executeUpdate("insert into Pet values(1, 'Buddy', 'Dog', '2015-08-04', '2021-05-20', 'Male', 'Brown', true, 'Labrador')");
            statement.executeUpdate("insert into Pet values(2, 'Whiskers', 'Cat', '2023-08-11', '2022-11-22', 'Male', 'Black', true, 'Maine Coon')");
            statement.executeUpdate("insert into Pet values(3, 'Charlie', 'Dog', '2017-09-15', '2022-08-03', 'Female', 'White', false, 'Poodle')");
            statement.executeUpdate("insert into Pet values(4, 'Bella', 'Dog', '2018-07-21', '2022-06-12', 'Female', 'Golden', true, 'Golden Retriever')");
            statement.executeUpdate("insert into Pet values(5, 'Max', 'Dog', '2016-04-17', '2022-07-29', 'Male', 'Black', true, 'German Shepherd')");
            statement.executeUpdate("insert into Pet values(6, 'Daisy', 'Cat', '2019-03-11', '2022-05-09', 'Female', 'Tabby', false, 'Bengal')");
            statement.executeUpdate("insert into Pet values(7, 'Molly', 'Cat', '2021-01-30', '2023-04-14', 'Female', 'Grey', true, 'British Shorthair')");
            statement.executeUpdate("insert into Pet values(8, 'Shadow', 'Cat', '2020-05-25', '2023-01-08', 'Male', 'Black', true, 'Siamese')");
            statement.executeUpdate("insert into Pet values(9, 'Rocky', 'Dog', '2014-10-31', '2021-12-19', 'Male', 'Brindle', false, 'Boxer')");
            statement.executeUpdate("insert into Pet values(10, 'Luna', 'Dog', '2019-08-09', NULL, 'Female', 'Black and White', true, 'Border Collie')");
            statement.executeUpdate("insert into Pet values(11, 'Zoe', 'Dog', '2018-02-14', '2022-05-20', 'Female', 'Brown', true, 'Beagle')");
            statement.executeUpdate("insert into Pet values(12, 'Ginger', 'Cat', '2017-11-25', '2023-03-18', 'Female', 'Orange', false, 'Persian')");
            statement.executeUpdate("insert into Pet values(13, 'Jack', 'Dog', '2019-06-03', '2023-01-22', 'Male', 'Black', false, 'Rottweiler')");
            statement.executeUpdate("insert into Pet values(14, 'Samantha', 'Cat', '2016-08-09', '2022-12-07', 'Female', 'White', true, 'Ragdoll')");
            statement.executeUpdate("insert into Pet values(15, 'Oscar', 'Dog', '2020-05-17', '2023-04-10', 'Male', 'Grey', true, 'Schnauzer')");
            statement.executeUpdate("insert into Pet values(16, 'Baxter', 'Dog', '2017-07-21', '2022-06-19', 'Male', 'Brown and White', false, 'Bulldog')");
            statement.executeUpdate("insert into Pet values(17, 'Cleo', 'Cat', '2021-01-05', '2023-05-11', 'Female', 'Tabby', true, 'Egyptian Mau')");
            statement.executeUpdate("insert into Pet values(18, 'Stella', 'Dog', '2015-12-31', '2022-08-25', 'Female', 'Black and Tan', true, 'Doberman')");
            statement.executeUpdate("insert into Pet values(19, 'Ruby', 'Dog', '2016-03-22', '2022-07-13', 'Female', 'Red', false, 'Irish Setter')");
            statement.executeUpdate("insert into Pet values(20, 'Jasper', 'Cat', '2018-04-18', '2023-02-21', 'Male', 'Calico', true, 'Norwegian Forest Cat')");
            statement.executeUpdate("insert into Pet values(21, 'Rosie', 'Dog', '2017-09-14', '2022-10-05', 'Female', 'Golden', true, 'Labradoodle')");
            statement.executeUpdate("insert into Pet values(22, 'Felix', 'Cat', '2020-06-20', '2023-01-17', 'Male', 'Black and White', false, 'Tuxedo')");
            statement.executeUpdate("insert into Pet values(23, 'Bailey', 'Dog', '2014-11-11', '2021-09-30', 'Female', 'Brown', true, 'Cocker Spaniel')");
            statement.executeUpdate("insert into Pet values(24, 'Sophie', 'Cat', '2019-07-29', '2023-03-22', 'Female', 'Cream', false, 'Sphynx')");
            statement.executeUpdate("insert into Pet values(25, 'Cooper', 'Dog', '2021-02-06', '2023-06-12', 'Male', 'Tri-color', true, 'Bernese Mountain Dog')");
            statement.executeUpdate("insert into Pet values(26, 'Penny', 'Dog', '2018-10-09', '2022-04-15', 'Female', 'White and Black', false, 'Dalmatian')");
            statement.executeUpdate("insert into Pet values(27, 'Simba', 'Cat', '2017-05-20', '2022-11-10', 'Male', 'Orange', true, 'Abyssinian')");
            statement.executeUpdate("insert into Pet values(28, 'Lucy', 'Dog', '2019-01-30', '2023-07-19', 'Female', 'Black', false, 'Labrador Retriever')");
            statement.executeUpdate("insert into Pet values(29, 'Oliver', 'Cat', '2020-08-15', '2023-01-05', 'Male', 'Grey', true, 'Russian Blue')");
            statement.executeUpdate("insert into Pet values(30, 'Maggie', 'Dog', '2016-12-05', '2022-09-23', 'Female', 'Brown', true, 'Boxer')");
            statement.executeUpdate("insert into Pet values(31, 'Duke', 'Dog', '2018-03-15', '2022-10-25', 'Male', 'Black and White', true, 'Border Collie')");
            statement.executeUpdate("insert into Pet values(32, 'Lola', 'Cat', '2019-06-21', '2023-07-18', 'Female', 'Tortoiseshell', false, 'American Shorthair')");
            statement.executeUpdate("insert into Pet values(33, 'Toby', 'Dog', '2020-11-04', '2023-03-30', 'Male', 'Brown', false, 'Beagle')");
            statement.executeUpdate("insert into Pet values(34, 'Chloe', 'Cat', '2017-04-10', '2022-05-15', 'Female', 'White', true, 'Siamese')");
            statement.executeUpdate("insert into Pet values(35, 'Bear', 'Dog', '2016-09-09', '2022-08-20', 'Male', 'Black', true, 'Rottweiler')");
            statement.executeUpdate("insert into Pet values(36, 'Mia', 'Cat', '2020-12-25', '2023-06-01', 'Female', 'Grey', false, 'Persian')");
            statement.executeUpdate("insert into Pet values(37, 'Hank', 'Dog', '2015-07-30', '2021-11-07', 'Male', 'Brown', false, 'Mastiff')");
            statement.executeUpdate("insert into Pet values(38, 'Belle', 'Cat', '2018-08-14', '2023-02-09', 'Female', 'Black', true, 'Bombay')");
            statement.executeUpdate("insert into Pet values(39, 'Zeus', 'Dog', '2019-02-22', '2023-04-15', 'Male', 'Grey', true, 'Great Dane')");
            statement.executeUpdate("insert into Pet values(40, 'Nala', 'Cat', '2021-05-19', '2023-08-11', 'Female', 'Calico', false, 'Maine Coon')");
            statement.executeUpdate("insert into Pet values(41, 'Murphy', 'Dog', '2017-10-31', '2022-09-05', 'Male', 'Tan', false, 'Labrador Retriever')");
            statement.executeUpdate("insert into Pet values(42, 'Lily', 'Cat', '2016-06-03', '2022-07-20', 'Female', 'Siamese', true, 'Bengal')");
            statement.executeUpdate("insert into Pet values(43, 'Ollie', 'Dog', '2020-01-17', '2023-05-22', 'Male', 'Black and Tan', true, 'German Shepherd')");
            statement.executeUpdate("insert into Pet values(44, 'Angel', 'Cat', '2019-03-08', '2023-01-16', 'Female', 'White', false, 'Ragdoll')");
            statement.executeUpdate("insert into Pet values(45, 'Moose', 'Dog', '2018-05-21', '2022-06-30', 'Male', 'Brown', true, 'Saint Bernard')");
            statement.executeUpdate("insert into Pet values(46, 'Gizmo', 'Cat', '2017-11-11', '2022-12-25', 'Male', 'Black and White', false, 'Sphynx')");
            statement.executeUpdate("insert into Pet values(47, 'Thor', 'Dog', '2016-02-27', '2021-10-09', 'Male', 'Golden', false, 'Golden Retriever')");
            statement.executeUpdate("insert into Pet values(48, 'Peaches', 'Cat', '2020-07-04', '2023-03-19', 'Female', 'Orange', true, 'American Curl')");
            statement.executeUpdate("insert into Pet values(49, 'Frankie', 'Dog', '2019-09-15', '2023-08-07', 'Male', 'Brindle', true, 'Boxer')");
            statement.executeUpdate("insert into Pet values(50, 'Sasha', 'Cat', '2018-12-20', '2023-02-28', 'Female', 'Grey', false, 'Russian Blue')");
            statement.executeUpdate("insert into Pet values(51, 'Buddy', 'Dog', '2017-03-10', '2022-11-03', 'Male', 'Beige', true, 'Pug')");
            statement.executeUpdate("insert into Pet values(52, 'Misty', 'Cat', '2016-08-29', '2022-10-17', 'Female', 'Blue', false, 'British Shorthair')");
            statement.executeUpdate("insert into Pet values(53, 'Sam', 'Dog', '2020-06-22', '2023-07-14', 'Male', 'Black', true, 'Labradoodle')");
            statement.executeUpdate("insert into Pet values(54, 'Coco', 'Cat', '2019-05-07', NULL, 'Female', 'Brown', true, 'Burmese')");
            statement.executeUpdate("insert into Pet values(55, 'Winston', 'Dog', '2018-10-08', '2022-09-21', 'Male', 'White', false, 'Bichon Frise')");
            statement.executeUpdate("insert into Pet values(56, 'Pumpkin', 'Cat', '2017-07-19', '2022-08-03', 'Female', 'Tortoiseshell', true, 'Scottish Fold')");
            statement.executeUpdate("insert into Pet values(57, 'Nala', 'Cat', '2018-11-30', NULL, 'Female', 'Tabby', false, 'American Shorthair')");
            statement.executeUpdate("insert into Pet values(58, 'George', 'Dog', '2017-06-15', '2022-10-10', 'Male', 'White', true, 'West Highland White Terrier')");
            statement.executeUpdate("insert into Pet values(59, 'Frankie', 'Cat', '2019-03-21', '2023-02-05', 'Male', 'Black', false, 'Bombay')");
            statement.executeUpdate("insert into Pet values(60, 'Rusty', 'Dog', '2016-08-09', NULL, 'Male', 'Rust', false, 'Vizsla')");
            statement.executeUpdate("insert into Pet values(61, 'Chester', 'Dog', '2017-12-25', '2022-04-17', 'Male', 'Brown', true, 'Cocker Spaniel')");
            statement.executeUpdate("insert into Pet values(62, 'Piper', 'Cat', '2018-07-14', '2023-01-11', 'Female', 'White', true, 'Turkish Angora')");
            statement.executeUpdate("insert into Pet values(63, 'Harley', 'Dog', '2020-05-03', '2023-05-30', 'Female', 'Black and Tan', false, 'German Shepherd')");
            statement.executeUpdate("insert into Pet values(64, 'Gizmo', 'Cat', '2021-02-18', NULL, 'Male', 'Grey', false, 'Russian Blue')");
            statement.executeUpdate("insert into Pet values(65, 'Marley', 'Dog', '2015-10-31', '2022-11-07', 'Male', 'Golden', true, 'Labrador Retriever')");
            statement.executeUpdate("insert into Pet values(66, 'Willow', 'Cat', '2019-08-23', '2023-03-19', 'Female', 'Calico', true, 'Calico')");
            statement.executeUpdate("insert into Pet values(67, 'Sam', 'Dog', '2017-01-16', '2022-06-22', 'Male', 'Brown', true, 'Beagle')");
            statement.executeUpdate("insert into Pet values(68, 'Lily', 'Cat', '2020-04-12', '2023-04-08', 'Female', 'Tabby', false, 'Maine Coon')");
            statement.executeUpdate("insert into Pet values(69, 'Benji', 'Dog', '2018-09-05', NULL, 'Male', 'White and Brown', false, 'Shih Tzu')");
            statement.executeUpdate("insert into Pet values(70, 'Lola', 'Cat', '2021-07-27', '2023-07-01', 'Female', 'Black', true, 'Sphynx')");
            statement.executeUpdate("insert into Pet values(71, 'Hank', 'Dog', '2016-05-19', '2022-08-20', 'Male', 'Grey', true, 'Weimaraner')");
            statement.executeUpdate("insert into Pet values(72, 'Simba', 'Cat', '2020-11-13', '2023-01-24', 'Male', 'Orange', false, 'Abyssinian')");
            statement.executeUpdate("insert into Pet values(73, 'Boomer', 'Dog', '2019-02-28', '2023-02-15', 'Male', 'Brown', true, 'Boxer')");
            statement.executeUpdate("insert into Pet values(74, 'Coco', 'Cat', '2017-08-20', '2022-07-10', 'Female', 'Brown', true, 'Burmese')");
            statement.executeUpdate("insert into Pet values(75, 'Duke', 'Dog', '2015-12-07', NULL, 'Male', 'Black and White', false, 'Border Collie')");
            statement.executeUpdate("insert into Pet values(76, 'Bella', 'Cat', '2018-06-01', '2023-06-12', 'Female', 'White', false, 'Persian')");
            statement.executeUpdate("insert into Pet values(77, 'Murphy', 'Dog', '2017-03-24', '2022-09-03', 'Male', 'Brown', true, 'Irish Setter')");
            statement.executeUpdate("insert into Pet values(78, 'Zoe', 'Cat', '2019-10-09', '2023-05-28', 'Female', 'Grey', true, 'Chartreux')");
            statement.executeUpdate("insert into Pet values(79, 'Gunner', 'Dog', '2020-07-15', '2023-03-22', 'Male', 'Black', true, 'Labrador Retriever')");
            statement.executeUpdate("insert into Pet values(80, 'Mia', 'Cat', '2021-05-30', NULL, 'Female', 'Tabby', false, 'American Shorthair')");
            statement.executeUpdate("insert into Pet values(81, 'Toby', 'Dog', '2016-11-08', '2022-05-16', 'Male', 'Tan', true, 'Cavalier King Charles Spaniel')");
            statement.executeUpdate("insert into Pet values(82, 'Sasha', 'Cat', '2017-04-17', '2022-12-25', 'Female', 'Black and White', true, 'Tuxedo')");

            // Display the inserted records and count them.
            int count = 0;
            try (ResultSet rs = statement.executeQuery("SELECT * FROM Pet ORDER BY id")) {
                System.out.println("The following pets have been inserted into the database:");
                while (rs.next()) {
                    System.out.println(rs.getString("name") + " " +
                            rs.getString("type") + " id: " + rs.getInt("id"));
                    count++;
                }
            }
            System.out.println("Successfully created pets.db with " + count + " pets.");

        } catch (SQLException e) {
            System.err.println("Database error: " + e.getMessage());
        }
    }
}
