/*
 * Name: YifanLi
 * Program: Full Stack Web Development
 * Course: WEBD-1009 Programming 1 Module4
 * Created: 2022-10-27
 * Updated: 2022-10-27
 */  


import java.util.Scanner;

public class CheckEmail {
  
    public static void main(String[] args) {


        int count = 0 ;
        String emailAddress;


        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter your email address:");
        emailAddress = keyboard.next();

        for ( int i = 0 ; i < emailAddress.length();i++){ 

            //check if there is @
            boolean isAt = emailAddress.charAt(i) == '@'; 
            //conditional operator must be used.
            count += isAt ? 1 : 0;
          
        }
            //conditional operator must be used.
        String result = (count == 1) ? " valid " : " invalid ";
        System.out.printf("The email address entered is %s", result);

    }
}
