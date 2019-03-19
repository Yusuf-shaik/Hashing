import java.util.*;
//import static java.lang.Character.isDigit;
import static java.lang.Character.isLetter;

public class main {

    public static void digitFold(String password) {
        String fullString = "";
        for (int c = 0; c < password.length(); c++) {
            if (isLetter(password.charAt(c))) {

                int temp = (int) password.charAt(c);
                fullString += temp;

            } else {
                fullString += password.charAt(c);

            }
        }

        System.out.println("Full String:" + fullString);

        //Initialize Empty Variables
        String newTemp = "";
        int sum = 0;

        //Parse through string
        for (int i = 0; i < fullString.length() / 3; i++) {

            for (int j = 3 * i; j < 3 * i + 3; j++) {

                //Split string into pieces
                newTemp += fullString.charAt(j);
            }

            //Print out substrings
            System.out.println("Substring: " + newTemp);

            //Get sum
            sum += Integer.parseInt(newTemp);
            newTemp = "";

        }
        //Print out sum
        System.out.println(sum);

    }

    public static void main(String args[]) {

        // Get password from user
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your password");
        String password = in.nextLine();

        //Get what kind of hashing user wants
        System.out.println("What type of hashing would you like?");
        String type = in.nextLine();

        digitFold(password);

    }
}
