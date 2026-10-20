/*
 * Driver program that displays a menu for querying the Pet table in pets.db.
 * The database methods are in PetAPI.java.
 * Run CreateDB first if pets.db does not exist.
 * @author T. Urness
 */

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class Assignment10 {

    // number of days ahead that counts as an "upcoming" birthday
    public static final int UPCOMING_DAYS = 30;

    /**
     * Print a heading followed by each name in the list and a total count
     * @param heading a String to display above the list
     * @param names an ArrayList of Strings to display
     */
    public static void printList(String heading, ArrayList<String> names) {
        System.out.println();
        System.out.println(heading);
        for(String s : names)
        {
            System.out.println("  " + s);
        }
        System.out.println("Total: " + names.size());
    }

    public static void main(String[] args) throws SQLException
    {
        Scanner input = new Scanner(System.in);
        int choice = 0;

        while(choice != 5)
        {
            System.out.println();
            System.out.println("===== Pet Database Menu =====");
            System.out.println("1. List all animal names");
            System.out.println("2. List all cats");
            System.out.println("3. List all dogs");
            System.out.println("4. List animals with an upcoming birthday (next " + UPCOMING_DAYS + " days)");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");

            if(!input.hasNextInt()) {
                input.nextLine(); // discard invalid input
                System.out.println("Please enter a number from 1 to 5.");
                continue;
            }
            choice = input.nextInt();
            input.nextLine();

            switch(choice)
            {
                case 1:
                    printList("All animals:", PetAPI.allNames());
                    break;
                case 2:
                    printList("Cats:", PetAPI.namesOfType("Cat"));
                    break;
                case 3:
                    printList("Dogs:", PetAPI.namesOfType("Dog"));
                    break;
                case 4:
                    printList("Upcoming birthdays:", PetAPI.namesWithUpcomingBirthday(UPCOMING_DAYS));
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Please enter a number from 1 to 5.");
            }
        }
        input.close();
    }

}
