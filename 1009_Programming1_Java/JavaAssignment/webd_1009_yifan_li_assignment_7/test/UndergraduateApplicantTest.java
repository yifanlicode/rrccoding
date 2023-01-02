/**
 * This is a test class for UndergraduateApplicant class.
 * Module 7 Assignment
 * 
 * @author  yifanli
 * CreateDate 2022-12-11
 * Updated  2022-12-12
 * @version 1.1
 */

public class UndergraduateApplicantTest {

   public static void main(String args[]){


     // UndergraduateApplicant(String, String, double, double)
      System.out.println("\nUndergraduateApplicant(String, String, double, double)");
      // Test #1 - Initialize the name.
      System.out.println("\nTest #1 - Initialize the name.");
      constructor_Undergraduate_Applicant_name();
      // Test #2 - Initialize the college.
      System.out.println("\nTest #2 - Initialize the college.");
      constructor_Undergraduate_Applicant_college();
      // Test #3 - Initialize the mark achieved on the standard aptitude test below the allowable range.
      System.out.println("\nTest #3 - Initialize the mark achieved on the standard aptitude test below the allowable range.");
      constructor_Undergraduate_Applicant_markBelowRange();
      // Test #4 - Initialize the mark achieved on the standard aptitude test above the allowable range.
      System.out.println("\nTest #4 - Initialize the mark achieved on the standard aptitude test above the allowable range.");
      constructor_Undergraduate_Applicant_markAboveRange();
      // Test #5 - Initialize the mark achieved on the standard aptitude test at the edge of the allowable range.
      System.out.println("\nTest #5 - Initialize the mark achieved on the standard aptitude test at the edge of the allowable range.");
      constructor_Undergraduate_Applicant_markAtEdge();
      // Test #6 - Initialize the mark achieved on the standard aptitude test.
      System.out.println("\nTest #6 - Initialize the mark achieved on the standard aptitude test.");
      constructor_Undergraduate_Applicant_mark();
      // Test #7 - Initialize the applicant's grade point average below the allowable range.
      System.out.println("\nTest #7 - Initialize the applicant's grade point average below the allowable range.");
      constructor_Undergraduate_Applicant_gradeBelowRange();
      // Test #8 - Initialize the applicant's grade point average above  the allowable range.
      System.out.println("\nTest #8 - Initialize the applicant's grade point average above the allowable range.");
      constructor_Undergraduate_Applicant_gradeAboveRange();
      // Test #9 - Initialize the applicant's grade point average at the edge of the  allowable range.
      System.out.println("\nTest #9 - Initialize the applicant's grade point average at the edge of the  allowable range.");
      constructor_Undergraduate_Applicant_gradeAtEdge();
      // Test #10 - Initialize the applicant's grade point average.
      System.out.println("\nTest #10 - Initialize the applicant's grade point average.");
      constructor_Undergraduate_Applicant_grade();

      //setStandardAptitudeTestScore(double) : void
      // Test #1 - Update the mark achieved on the standard aptitude test below the allowable range.
      System.out.println("\nTest #1 - Update the mark achieved on the standard aptitude test below the allowable range.");
      setStandardAptitudeTestScore_Undergraduate_Applicant_belowRange();
      // Test #2 - Update the mark achieved on the standard aptitude test above the allowable range.
      System.out.println("\nTest #2 - Update the mark achieved on the standard aptitude test above the allowable range.");
      setStandardAptitudeTestScore_Undergraduate_Applicant_aboveRange();
      // Test #3 - Update the mark achieved on the standard aptitude test at the edge of the allowable range.
      System.out.println("\nTest #3 - Update the mark achieved on the standard aptitude test at the edge of the allowable range.");
      setStandardAptitudeTestScore_Undergraduate_Applicant_atEdge();
      // Test #4 - Update the mark achieved on the standard aptitude test.
      System.out.println("\nTest #4 - Update the mark achieved on the standard aptitude test.");
      setStandardAptitudeTestScore_Undergraduate_Applicant();
      
      //setGradePointAverage() : double
      // Test #1 - Update the applicant's grade point average below the allowable range.
      System.out.println("\nTest #1 - Update the applicant's grade point average below the allowable range.");
      setGradePointAverage_Undergraduate_Applicant_belowRange();
      // Test #2 - Update the applicant's grade point average above  the allowable range.
      System.out.println("\nTest #2 - Update the applicant's grade point average above  the allowable range.");
      setGradePointAverage_Undergraduate_Applicant_aboveRange();
      // Test #3 - Update the applicant's grade point average at the edge of the  allowable range.
      System.out.println("\nTest #3 - Update the applicant's grade point average at the edge of the  allowable range.");
      setGradePointAverage_Undergraduate_Applicant_atEdge();
      // Test #4 - Update the applicant's grade point average.
      System.out.println("\nTest #4 - Update the applicant's grade point average.");
      setGradePointAverage_Undergraduate_Applicant();
      
      //registerForProgram(String) : String
      // Test #1 - Return a String indicating the college, program name, and standarde aptitude test score
      System.out.println("\nTest #1 - Return a String indicating the college, program name, and standarde aptitude test score");
      registerForProgram_Undergraduate_Applicant();

      //toString() : String
      // Test #1 - Return the correct String representation.
      System.out.println("\nTest #1 - Return the correct String representation.");
      toString_Undergraduate_Applicant();
   }

    /**
     * UndergraduateApplicant constructor tests.
     * Test #1 - Initialize the name.
     * name =" Yifan", college = "Red River College", standardApptitudeTestScore = 420.5, gradePointAverage = 4.1;
     * Expected: Yifan
     * Actual: Yifan
     */ 

    public static void constructor_Undergraduate_Applicant_name(){
      UndergraduateApplicant applicant = new UndergraduateApplicant("Yifan", "Red River College", 420.5, 4.1);
      String expected = "Yifan";
      String actual = applicant.getName();
      System.out.printf("Expected: %s%nActual: %s%n", expected, actual);
    }

    /**
     * UndergraduateApplicant constructor tests.
     * Test #2 - Initialize the college.
     * name =" Yifan", college = "Red River College", standardApptitudeTestScore = 420.5, gradePointAverage = 4.1;
     * Expected: Red River College
     * Actual: Red River College
     */

    public static void constructor_Undergraduate_Applicant_college(){
      UndergraduateApplicant applicant = new UndergraduateApplicant("Yifan", "Red River College", 420.5, 4.1);
      String expected = "Red River College";
      String actual = applicant.getCollege();
      System.out.printf("Expected: %s%nActual:%s%n", expected, actual);
    }

    /**
     * UndergraduateApplicant constructor tests.
     * Test #3 - Initialize the mark achieved on the standard aptitude test below the allowable range.
     * name =" Yifan", college = "Red River College", standardApptitudeTestScore = -3.0, gradePointAverage = 4.1;
     * Expected: 0.0
     * Actual: 0.0
     */

    public static void constructor_Undergraduate_Applicant_markBelowRange(){
      UndergraduateApplicant applicant = new UndergraduateApplicant("Yifan", "Red River College", -3.0, 4.1);
      double expected = 0.0;
      double actual = applicant.getStandardAptitudeTestScore();
      System.out.printf("Expected: %f%nActual: %f%n", expected, actual);

    }

    /**
     * UndergraduateApplicant constructor tests.
     * Test #4 - Initialize the mark achieved on the standard aptitude test above the allowable range.
     * name =" Yifan", college = "Red River College", standardApptitudeTestScore = 520.3, gradePointAverage = 4.1;
     * Expected: 0.0
     * Actual: 0.0
     */

    public static void constructor_Undergraduate_Applicant_markAboveRange(){
      UndergraduateApplicant applicant = new UndergraduateApplicant("Yifan", "Red River College", 520.3, 4.1);
      double expected = 0.0;
      double actual = applicant.getStandardAptitudeTestScore();
      System.out.printf("Expected: %f%nActual: %f%n", expected, actual);
    }

    /**
     * UndergraduateApplicant constructor tests.
     * Test #5 - Initialize the mark achieved on the standard aptitude test at the edge of the allowable range.
     * name =" Yifan", college = "Red River College", standardApptitudeTestScore = 500.0, gradePointAverage = 4.1;
     * Expected: 500.0
     * Actual: 500.0
     */

    public static void constructor_Undergraduate_Applicant_markAtEdge(){
      UndergraduateApplicant applicant = new UndergraduateApplicant("Yifan", "Red River College", 500.0, 4.1);
      double expected = 500.0;
      double actual = applicant.getStandardAptitudeTestScore();
      System.out.printf("Expected: %f%nActual: %f%n", expected, actual);
    }

    /**
     * UndergraduateApplicant constructor tests.
     * Test #6 - Initialize the mark achieved on the standard aptitude test.
     * name =" Yifan", college = "Red River College", standardApptitudeTestScore = 420.5, gradePointAverage = 4.1;
     * Expected: 420.5
     * Actual: 420.5
     */

    public static void constructor_Undergraduate_Applicant_mark(){
      UndergraduateApplicant applicant = new UndergraduateApplicant("Yifan", "Red River College", 420.5, 4.1);
      double expected = 420.5;
      double actual = applicant.getStandardAptitudeTestScore();
      System.out.printf("Expected: %f%nActual: %f%n", expected, actual);
    }

    /**
     * UndergraduateApplicant constructor tests.
     * Test #7 - Initialize the applicant's grade point average below the allowable range.
     * name =" Yifan", college = "Red River College", standardApptitudeTestScore = 420.5, gradePointAverage = -1.0;
     * Expected: 0.0
     * Actual: 0.0
     */

    public static void constructor_Undergraduate_Applicant_gradeBelowRange(){
      UndergraduateApplicant applicant = new UndergraduateApplicant("Yifan", "Red River College", 420.5, -1.0);
      double expected = 0.0;
      double actual = applicant.getGradePointAverage();
      System.out.printf("Expected: %f%nActual: %f%n", expected, actual);
    }

    /**
     * UndergraduateApplicant constructor tests.
     * Test #8 - Initialize the applicant's grade point average above the allowable range.
     * name =" Yifan", college = "Red River College", standardApptitudeTestScore = 420.5, gradePointAverage = 5.1;
     * Expected: 0.0
     * Actual: 0.0
     */

    public static void constructor_Undergraduate_Applicant_gradeAboveRange(){
      UndergraduateApplicant applicant = new UndergraduateApplicant("Yifan", "Red River College", 420.5, 5.1);
      double expected = 0.0;
      double actual = applicant.getGradePointAverage();
      System.out.printf("Expected: %f%nActual: %f%n", expected, actual);
    }

    /**
     * UndergraduateApplicant constructor tests.
     * Test #9 - Initialize the applicant's grade point average at the edge of the allowable range.
     * name =" Yifan", college = "Red River College", standardApptitudeTestScore = 420.5, gradePointAverage = 4.5;
     * Expected: 4.5
     * Actual: 4.5
     */

    public static void constructor_Undergraduate_Applicant_gradeAtEdge(){
      UndergraduateApplicant applicant = new UndergraduateApplicant("Yifan", "Red River College", 420.5, 4.5);
      double expected = 4.5;
      double actual = applicant.getGradePointAverage();
      System.out.printf("Expected: %f%nActual: %f%n", expected, actual);
    }

    /**
     * UndergraduateApplicant constructor tests.
     * Test #10 - Initialize the applicant's grade point average.
     * name =" Yifan", college = "Red River College", standardApptitudeTestScore = 420.5, gradePointAverage = 4.1;
     * Expected: 4.1
     * Actual: 4.1
     */

    public static void constructor_Undergraduate_Applicant_grade(){
      UndergraduateApplicant applicant = new UndergraduateApplicant("Yifan", "Red River College", 420.5, 4.1);
      double expected = 4.1;
      double actual = applicant.getGradePointAverage();
      System.out.printf("Expected: %f%nActual: %f%n", expected, actual);
    }

      /**
       * setStandardAptitudeTestScore(double) : void
       * Test #1 - Update the mark achieved on the standard aptitude test below the allowable range.
       * initial name =" Yifan", college = "Red River College", standardApptitudeTestScore = 420.5  gradePointAverage = 4.1;
       * Expected: 0.0
       * Actual: 0.0
       */


    public static void setStandardAptitudeTestScore_Undergraduate_Applicant_belowRange(){
      UndergraduateApplicant applicant = new UndergraduateApplicant("Yifan", "Red River College", 420.5, 4.1);
      applicant.setStandardAptitudeTestScore(-3.0);
      double expected = 0.0;
      double actual = applicant.getStandardAptitudeTestScore();
      System.out.printf("Expected: %f%nActual: %f%n", expected, actual);
    }

    /**
     * setStandardAptitudeTestScore(double) : void
     * Test #2 - Update the mark achieved on the standard aptitude test above the allowable range.
     * initial name =" Yifan", college = "Red River College", standardApptitudeTestScore = 420.5  gradePointAverage = 4.1;
     * Expected: 0.0
     * Actual: 0.0
     */

    public static void setStandardAptitudeTestScore_Undergraduate_Applicant_aboveRange(){
      UndergraduateApplicant applicant = new UndergraduateApplicant("Yifan", "Red River College", 420.5, 4.1);
      applicant.setStandardAptitudeTestScore(520.3);
      double expected = 0.0;
      double actual = applicant.getStandardAptitudeTestScore();
      System.out.printf("Expected: %f%nActual: %f%n", expected, actual);
    }

    /**
     * setStandardAptitudeTestScore(double) : void
     * Test #3 - Update the mark achieved on the standard aptitude test at the edge of the allowable range.
     * initial name =" Yifan", college = "Red River College", standardApptitudeTestScore = 420.5  gradePointAverage = 4.1;
     * Expected: 500.0
     * Actual: 500.0
     */

    public static void setStandardAptitudeTestScore_Undergraduate_Applicant_atEdge(){
      UndergraduateApplicant applicant = new UndergraduateApplicant("Yifan", "Red River College", 420.5, 4.1);
      applicant.setStandardAptitudeTestScore(500.0);
      double expected = 500.0;
      double actual = applicant.getStandardAptitudeTestScore();
      System.out.printf("Expected: %f%nActual: %f%n", expected, actual);
    }

    /**
     * setStandardAptitudeTestScore(double) : void
     * Test #4 - Update the mark achieved on the standard aptitude test.
     * initial name =" Yifan", college = "Red River College", standardApptitudeTestScore = 420.5  gradePointAverage = 4.1;
     * Expected: 420.5
     * Actual: 420.5
     */
    public static void setStandardAptitudeTestScore_Undergraduate_Applicant(){
      UndergraduateApplicant applicant = new UndergraduateApplicant("Yifan", "Red River College", 420.5, 4.1);
      applicant.setStandardAptitudeTestScore(425.5);
      double expected = 425.5;
      double actual = applicant.getStandardAptitudeTestScore();
      System.out.printf("Expected: %f%nActual: %f%n", expected, actual);
    }



    /**setGradePointAverage(double) : void
     * Test #1 - Update the applicant's grade point average below the allowable range.
     * initial name =" Yifan", college = "Red River College", standardApptitudeTestScore = 420.5  gradePointAverage = 4.1;
     * Expected: 0.0
     * Actual: 0.0
     */

    public static void setGradePointAverage_Undergraduate_Applicant_belowRange(){
      UndergraduateApplicant applicant = new UndergraduateApplicant("Yifan", "Red River College", 420.5, 4.1);
      applicant.setGradePointAverage(-1.0);
      double expected = 0.0;
      double actual = applicant.getGradePointAverage();
      System.out.printf("Expected: %f%nActual: %f%n", expected, actual);
    }

    /**
     * setGradePointAverage(double) : void
     * Test #2 - Update the applicant's grade point average above the allowable range.
     * initial name =" Yifan", college = "Red River College", standardApptitudeTestScore = 420.5  gradePointAverage = 4.1;
     * Expected: 0.0
     * Actual: 0.0
     */
    public static void setGradePointAverage_Undergraduate_Applicant_aboveRange(){
      UndergraduateApplicant applicant = new UndergraduateApplicant("Yifan", "Red River College", 420.5, 4.1);
      applicant.setGradePointAverage(5.1);
      double expected = 0.0;
      double actual = applicant.getGradePointAverage();
      System.out.printf("Expected: %f%nActual: %f%n", expected, actual);
    }

    /**
     * setGradePointAverage(double) : void
     * Test #3 - Update the applicant's grade point average at the edge of the allowable range.
     * initial name =" Yifan", college = "Red River College", standardApptitudeTestScore = 420.5  gradePointAverage = 4.1;
     * Expected: 4.5
     * Actual: 4.5
     */
    public static void setGradePointAverage_Undergraduate_Applicant_atEdge(){
      UndergraduateApplicant applicant = new UndergraduateApplicant("Yifan", "Red River College", 420.5, 4.1);
      applicant.setGradePointAverage(4.5);
      double expected = 4.5;
      double actual = applicant.getGradePointAverage();
      System.out.printf("Expected: %f%nActual: %f%n", expected, actual);
    }

    /**
     * setGradePointAverage(double) : void
     * Test #4 - Update the applicant's grade point average.
     * initial name =" Yifan", college = "Red River College", standardApptitudeTestScore = 420.5  gradePointAverage = 4.1;
     * Expected: 4.2
     * Actual: 4.2
     */
    public static void setGradePointAverage_Undergraduate_Applicant(){
      UndergraduateApplicant applicant = new UndergraduateApplicant("Yifan", "Red River College", 420.5, 4.1);
      applicant.setGradePointAverage(4.2);
      double expected = 4.2;
      double actual = applicant.getGradePointAverage();
      System.out.printf("Expected: %f%nActual: %f%n", expected, actual);
    }


    /** registerForProgram(String):String
    * Test1 - Return a String indicating the college, program name, and standarde aptitude test score
    * initial name =" Yifan", college = "Red River College", standardApptitudeTestScore = 420.5  gradePointAverage = 4.1;
    * Expected: Red River College - Computer Science[420.5]
    * Actual: Red River College - Computer Science[420.5]
    */


    public static void registerForProgram_Undergraduate_Applicant(){
      UndergraduateApplicant applicant = new UndergraduateApplicant("Yifan", "Red River College", 420.5, 4.1);
      String expected = "Red River College - Computer Science[420.5]";
      String actual = applicant.registerForProgram("Computer Science");
      System.out.printf("Expected: %s%nActual: %s%n", expected, actual);
    }

    /** toString():String
     * Test #1 - Return a String representation of the applicant's name, college, standard aptitude test score, and grade point average.
     * initial name =" Yifan", college = "Red River College", standardApptitudeTestScore = 420.5  gradePointAverage = 4.1;
     * Expected: =======================
                  College Applicant
                  =======================
                  Name:        Yifan          
                  College:     Red River College
                  SAT Score:   420.5.            
                  GPA:         4.1 
     * Actual: =======================
                  College Applicant
                  =======================
                  Name:        Yifan          
                  College:     Red River College
                  SAT Score:   420.5.            
                  GPA:         4.1 
      */


    public static void toString_Undergraduate_Applicant(){
      UndergraduateApplicant applicant = new UndergraduateApplicant("Yifan", "Red River College", 420.5, 4.1);
      String expected = " =======================\n" +
                        " College Applicant\n" +
                        " =======================\n" +
                        " Name:        Yifan          \n" +
                        " College:     Red River College\n" +
                        " SAT Score:   420.5          \n" +
                        " GPA:         4.1 ";
      String actual = applicant.toString();
      System.out.printf("Expected: %s%nActual: %n%s%n", expected, actual);
    }


   }





















  

