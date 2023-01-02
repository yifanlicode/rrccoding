/*
 * Name: YifanLi
 * Program: Full Stack Web Development
 * Course: WEBD-1009 Programming 1
 * Created: 2022-10-12
 * Updated: 2022-10-13
 */          

import java.util.Scanner;

public class ComparingPasswords {
    public static void main(String[] args) {

    // Input a password and the same password again. 
    // If both passwords match, the output "You are now registered as a new user"
    // Otherwise, output "Sorry, there is a typo in your password"


        Scanner password  = new Scanner(System.in);
        System.out.println("Please enter your password:  ");
        String password1 = password.nextLine();

        Scanner passwordAgain  = new Scanner(System.in);
        System.out.println("Please repeat your password: ");
        String password2 = passwordAgain.nextLine();

        // use conditional operator to compare two passwords

        String result =  (password1.equals(password2)) ? 
        "\nYou are now registered as a new user.\n" : "\nSorry, there is a typo in your password\n";

        System.out.println(result);

    }
}
