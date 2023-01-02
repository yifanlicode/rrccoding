/*
 * Name: YifanLi
 * Program: Full Stack Web Development
 * Course: WEBD-1009 Programming 1
 * Created: 2022-09-27
 * Updated: 2022-09-29
 */

import java.util.Scanner;
import java.lang.String;

public class FormatPhoneNumber {
    public static void main(String[] args) {

        //Please enter 10 digits: [Keyboard Input]
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Please enter 10 digts : ");

        String phoneNumber= keyboard.nextLine();

        //phoneNumber formatted in (nnn) nnn-nnnn
        String firstThreeDigits = phoneNumber.substring(0,3);
        String secondThreeDigits = phoneNumber.substring(3,6);
        String lastFourDigits = phoneNumber.substring(6,10);

        String formattedPhoneNumber = String.format("(%s) %s-%s", firstThreeDigits, secondThreeDigits, lastFourDigits);

        System.out.println("The supplied number formatted as a telephone number is " + formattedPhoneNumber);
    }

}