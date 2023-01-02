/*
 * Name: Yifan Li
 * Program: Full Stack Web Development
 * Course: WEBD-1009 Programming 1
 * Created: 2022-09-27
 * Updated: 2022-09-29
 */

import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.Scanner;

public class CircleCalculate {

    public static void main(String[] args) {

        // Please enter a value for the radius of a circle in centimeters: [Keyboard Input]
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Please enter a value for the radius of a circle in centimeters: ");
        double radius = keyboard.nextDouble();

        //The circumference of a circle with a radius of {radius value} is {calculated circumference} cm.
        double circumference = 2 * Math.PI * radius;
        DecimalFormat formatter = new DecimalFormat("0.00");
        String formattedCircumference = formatter.format(circumference);
       
        System.out.println(
                "\nThe circumference of a circle with a radius of " +  radius + " is " + formattedCircumference + " cm.");


        //The area of a circle with a radius of {radius value} is {calculated area} cm²
        double area = Math.PI * Math.pow(radius, 2);
        PrintStream psValue  = new PrintStream(System.out);
        char power = '\u00b2'; 
        
        psValue.printf(
                "\nThe area of a circle with a radius of " +  radius + " is %.2f cm%c", area, power);

    }
}
