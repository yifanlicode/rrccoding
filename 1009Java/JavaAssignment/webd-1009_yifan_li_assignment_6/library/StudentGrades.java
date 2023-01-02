/**
 * Name:Yifanli
 * Program:Full Stack Web Development
 * Course:ADEV-1009 Programming 1
 * Created:2022-11-26
 * Updated:2022-11-27
 */

/**
  *StudentGrades
  -------------------------------------
  -grades:int[]
  -------------------------------------
  + StudentGrades(numberOfStudents:int)
  + StudentGrades(grades:int[])
  -copyArray(toCopy:int[]):int[]
  +getGrades():int[]
  +setGrades(grades:int[]):void
  +getSortedGrades():int[]
  +getHighestGrade():int[]
  +getAverageOfGrade():double
  +toSting():String 
 */


public class  StudentGrades{ 
  //instance variables array of grades
  private int[] grades;

  /**
   * Initializes a new instance of the StudentGrades class with the specified number of students.
   * The grade values are zero. 
   * 
   * @param numberOfStudents The number of students. 
   */

  public StudentGrades(int numberOfStudents) { 
    //initialize the array with the number of students
    grades = new int[numberOfStudents];
    //initialize the grades to zero
    for (int i = 0; i < grades.length; i++) {  
      grades[i] = 0; 
    }
  }


/**
   * Initializes grades to the specified array. 
   * Ensure that the reference to the grades is not accessible outside of the class.
   * 
   * @param grades The array of grades. 
   */


  public StudentGrades(int[] grades) { 
    //initialize the array with the number of students
    this.grades = new int[grades.length];
    //initialize the grades to zero
    for (int i = 0; i < grades.length; i++) {  
      this.grades[i] = grades[i]; 
    }
  }


 /**
   * Return a copy of the soecified array.  
   * 
   * @param toCopy The array of percentage values to be copied.
   * @return A copy of the specified array.
   */

   private int[] copyArray(int[] toCopy){

       
    int[]copy = new int[toCopy.length];
     // Iterate through each element in the array
    for (int i = 0; i < toCopy.length; i++) {
      // assign the current element to the copy array at the same index
      copy[i] = toCopy[i];
    }
    return copy; 
   }


/**
 * Return a copy of the array of grades.
 * 
 * @return a copy of the gardes array 
 */

  public int[] getGrades() { 
    return copyArray(grades);
  }



/**
 * Sets the grades array to the specified array.
 * Ensure that the reference to the grades is not accessible outside of the class.''
 * 
 * @param grades the array of grades
 */


  public void setGrades(int[] grades) { 
    this.grades = copyArray(grades);
  }



/**
 * Returns a new array containing the values of the grades attribute sorted in ascending order.
 * 
 * @return A new array containing the values of the grades attribute sorted in ascending order.
 */


public int[] getSortedGrades() { 
    //copy the array
    int[] sortedGrades = copyArray(grades);
    //sort the array
    for (int i = 0; i < sortedGrades.length; i++) {
      for (int j = i + 1; j < sortedGrades.length; j++) {
        if (sortedGrades[i] > sortedGrades[j]) {
          int temp = sortedGrades[i];
          sortedGrades[i] = sortedGrades[j];
          sortedGrades[j] = temp;
        }
      }
    }
    return sortedGrades;
  }


/**
 * Returns the highest grade in the grades attribute. 
 * 
 * @return The highest grade in the grades attribute.
 */

  public int getHighestGrade() { 
    //copy the array
    int[] sortedGrades = getSortedGrades();
    //return the last element
    return sortedGrades[sortedGrades.length - 1];
  }


 /**
  * Returns the average of the values in the grades attribute.
  *
  * @return The average of the values in the grades attribute.
  */

  public double getAverageOfGrade() { 
    //copy the array
    int[] sortedGrades = getSortedGrades();
    //calculate the average
    double sum = 0;
    for (int i = 0; i < sortedGrades.length; i++) {
      sum += sortedGrades[i];
    }
    return sum / sortedGrades.length;
  }


  /**
   * Returns a string representation of the class in the following format
   * 
   * @return A string representation of the object.
   */
   
  public String toString() {
   
    //format the string
    String str = "\n====================\n" +
                  "Student    " + "    Grade" +
                    "\n====================\n";
                  
    for (int i = 0; i < grades.length; i++) {
      String element = String.format("%-15d%-15d%n", i + 1, grades[i]);
      str += element;
    }
    return str;

  }

  

}

