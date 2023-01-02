/**
 * Name:Yifanli
 * Program:Full Stack Web Development
 * Course:ADEV-1009 Programming 1
 * Created:2022-11-25
 * Updated:2022-11-26
 */

 /**
 * Moudule6  Test all test cases outlined in the test plan
 * 
 * @author yifanli
 * @version 1.0
 * 
 */
import java.util.Arrays;

public class StudentGradesTest {

  public static void main(String[] args) {
    
    System.out.println("\nStudentGrades(int)");
    System.out.println("Test #1 - Initialize grades array without data");
    studentGrade_test1();

    System.out.println("\nStudentGrades(int[])");
    System.out.println("Test #2 - Initialize grades array with data");
    studentGrade_test2();

    System.out.println("\nsetGrades(int[])");
    System.out.println("Test #3 - Update the state of the grades.");
    setGrades_test3();

    System.out.println("\ngetSortedGrades()");
    System.out.println("Test #4 - Return a copy of the grades array sorted in ascending order.");
    getSortedGrades_test4();

    System.out.println("\ngetHighestGrade()");
    System.out.println("Test #5 - Return the correct highest grade value.");
    getHighestGrade_test5();

    System.out.println("\ngetAverageOfGrade()");
    System.out.println("Test #6 - Return the correct average of all the grades.");
    getAverageOfGrade_test6();

    System.out.println("\ntoString()");
    System.out.println("Test #7 - Return the correct String representation.");
    toString_test7();

  }

  /**
   * Test #1 - Initialize grades array without data
   */

   public static void studentGrade_test1() {
      //set test data
      int numberOfStudents = 6;
      //act
      StudentGrades test1 = new StudentGrades(numberOfStudents);
      //assert
      int[] expected = {0,0,0,0,0,0};
      int[] actual = test1.getGrades();

      //print results
      System.out.printf("Expected: %s\nActual: %s\n", 
      Arrays.toString(expected), Arrays.toString(actual));
    }


    /**
     * Test #2 - Initialize grades array with data  {45,89,90,65,77,88
     */

     public static void studentGrade_test2() {
      //set test data
      int[] grades = {45,89,90,65,77,88};
      //act
      StudentGrades test2 = new StudentGrades(grades);

      //assert
      int[] expected = {45,89,90,65,77,88};
      int[] actual = test2.getGrades();

      //print results
      System.out.printf("Expected: %s\nActual: %s\n", 
      Arrays.toString(expected), Arrays.toString(actual));

    }

    /**
     * Test #3 - Update the state of the grades. {70,77,96,87,55,66}
     */
     
     public static void setGrades_test3() {
      //set test data
      int[] grades = {70,77,96,87,55,66};
      //act
      StudentGrades test3 = new StudentGrades(grades);
      //assert
      int[] expected = {70,77,96,87,55,66};
      int[] actual = test3.getGrades();

      //print results
      System.out.printf("Expected: %s\nActual: %s\n",
      Arrays.toString(expected), Arrays.toString(actual));
    }



     /**
      * Test #4 - Return a copy of the grades array sorted in ascending order.
      */

      
      public static void getSortedGrades_test4() {
        //set test data
        int[] grades = {70,77,96,87,55,66};
        //act
        StudentGrades test4 = new StudentGrades(grades);
        //assert
        int[] expected = {55,66,70,77,87,96};
        int[] actual = test4.getSortedGrades();
        //print results
        System.out.printf("Expected: %s\nActual: %s\n",
        Arrays.toString(expected), Arrays.toString(actual));
      }

      /**
       * Test #5 - Return the correct highest grade value.
       */

  
      public static void getHighestGrade_test5() {
        //set test data
        int[] grades = {70,77,96,87,55,66};
        //act
        StudentGrades test5 = new StudentGrades(grades);
        //assert
        int expected = 96;
        int actual = test5.getHighestGrade();
        //print results
        System.out.printf("Expected: %s\nActual: %s\n",
        expected, actual);
      }


        /**
         * Test #6 - Return the correct average of all the grades.
         */

        public static void getAverageOfGrade_test6() {
          //set test data
          int[] grades = {70,77,96,87,55,66};
          //act
          StudentGrades test6 = new StudentGrades(grades);
          //assert
          double expected = 75.16666666666667;
          double actual = test6.getAverageOfGrade();
          //print results
          System.out.printf("Expected: %f\nActual: %f\n",
          expected, actual);
        }


        /**
         * Test #7 - Return the correct String representation.
         */

        public static void toString_test7() {
          //set test data
          int[] grades = {70,77,96,87,55,66};
          //act
          StudentGrades test7 = new StudentGrades(grades);
          //assert
          String expected = "Grades: [70,77,96,87,55,66]";
          String actual = test7.toString();
          //print results
          System.out.printf("Expected: %s\nActual: %s\n",
          expected, actual);
       }
}
