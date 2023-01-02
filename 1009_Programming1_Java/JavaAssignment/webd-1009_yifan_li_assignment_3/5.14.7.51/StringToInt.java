/*
 * Name: YifanLi
 * Program: Full Stack Web Development
 * Course: WEBD-1009 Programming 1
 * Created: 2022-10-12
 * Updated: 2022-10-12
 */         

import java.util.Scanner;

public class StringToInt {
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        System.out.println(" Please enter a 2-digit or 4-digit year: ");
        String year = keyboard.nextLine();

    
        if (year.length() == 2 || year.length() == 4)
        {
            if(year.length() == 2)
            {
                int yearInt2 = Integer.parseInt(year) + 2000;
                System.out.println(" The year entered is " + yearInt2);
            }
            else
            {
                int yearInt = Integer.parseInt(year);
                System.out.println(" The year entered is " + yearInt);
            }
        }
        else{
            System.out.println(" The year entered is not valid ");
        }

    }
}
