/**
 * Name:Yifanli
 * Program:Full Stack Web Development
 * Course:ADEV-1009 Programming 1
 * Created:2022-11-25
 * Updated:2022-11-26
 */

/**
 * Moudle 6 Part 2: Client Program with ArrayList 
 * 
 * @author  yifanli
 * @version 1.0
 */

import java.util.ArrayList; // import the ArrayList class
import java.util.Scanner; // import the Scanner class


public class ArrayListPro{
    public static void main(String[] args){

        //Create an instance of an ArrayList that  store 3 StudentGrades objects.
        ArrayList<StudentGrades> studentGrades = new ArrayList<StudentGrades>();
        
        //prompt the user to enter numberOfStudents

        Scanner scan = new Scanner(System.in);  
        System.out.println("\nEnter the number of students in the course: \n");  
        int numberOfStudents = scan.nextInt(); 
        //close the scanner
        scan.close();
      
        //add 3 new StudentGrades objects to the ArrayList.
        //The StudentGrades objects should be populated with random values from 0 - 100.
     
        for (int i = 0; i < 3; i++) { 
            int[] grades = new int[numberOfStudents];
            for(int j = 0; j < numberOfStudents; j++){
                grades[j] = (int)(Math.random() * 100); //random number from 0 to 100
            }
            StudentGrades student = new StudentGrades(grades);
            studentGrades.add(student);
        }
        

        //Use the enhanced for loop to print each of the StudentGrades objects  to the console.
        for (StudentGrades student : studentGrades) { 
            System.out.println(student.toString());
        }

        
        //Print the value of the final element in the ArrayList under the heading "LAST ELEMENT BEFORE REMOVE:".
        System.out.println("\nLAST ELEMENT BEFORE REMOVE: \n" 
                       + studentGrades.get(studentGrades.size() - 1).toString());

        //Remove the final StudentGrades objects from the ArrayList.
        studentGrades.remove(studentGrades.size() - 1);


        //Trim the ArrayList and print the value of the final element in the ArrayList under the heading "LAST ELEMENT AFTER REMOVE:".
     
        studentGrades.trimToSize();
        System.out.println("\nLAST ELEMENT AFTER REMOVE: \n" 
                       + studentGrades.get(studentGrades.size() - 1).toString());


    }
    
}

