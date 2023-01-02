/*
 * Name: YifanLi
 * Program: Full Stack Web Development
 * Course: WEBD-1009 Programming 1 Module4
 * Created: 2022-10-27
 * Updated: 2022-10-28
 */  


import java.util.Scanner;

public class CalculateFactorial {
    public static void main(String[] args) {


        int number;
        long factorial = 1; 

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Please enter an integer value:");
        number = keyboard.nextInt();
    
        for(int i = 1; i <= number; i++){
            factorial *= i;
        }
       
        System.out.printf("The factorial of %d is %d", number, factorial);
        
     }

 }




