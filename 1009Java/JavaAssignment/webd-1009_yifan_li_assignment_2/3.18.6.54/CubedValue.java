/*
 * Name: YifanLi
 * Program: Full Stack Web Development
 * Course: WEBD-1009 Programming 1
 * Created: 2022-09-27
 * Updated: 2022-09-29
 */

import java.util.Scanner;
import java.lang.Math;

public class CubedValue {
    public static void main(String[] args) {

        //Please enter a value to be cubed: [Keyboard Input]
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Please enter a value to be cubed: ");

        //The cubed value of {value} is {cubed value}
        double value = keyboard.nextDouble();
        double cubedValue = Math.pow(value,3);

        System.out.println("\nThe cubed value of " + value  + " is " + cubedValue);
    }
}
