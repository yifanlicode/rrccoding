/**
 *  Name:Yifanli
 * Program:Full Stack Web Development
 * Course:ADEV-1009 Programming 1
 * Created:2022-12-08
 * Updated:2022-12-13
 */

 /**
 * Moudule7 Inheritance and Polymorphism
 * 
 * @author yifanli
 * @version 1.0
 * 
 */

 /**
  *UndergraduateApplicant
  -------------------------------------
  -standardAptitudeTestScore: double
  -gradePointAverage: double
  -------------------------------------
  +UndergraduateApplicant(name: String, college: String, standardAptitudeTestScore: double, gradePointAverage: double)
  +getStandardAptitudeTestScore(): double
  +setStandardAptitudeTestScore(score: double): void
  +getGradePointAverage(): double
  +setGradePointAverage(gradePointAverage: double): void
  +registerForProgram(program: String): String
  +toString(): String
  */


  public class UndergraduateApplicant extends CollegeApplicant {


    /**
    * Fields
    * standardAptitudeTestScore:The score achieved on the standard aptitude test. Allowable values: 0.0 - 500.0 inclusive. If this field is set outside the allowable range, set the state to 0 (zero).
    * gradePointAverage: The grade point average.
    * 
    */

     private double standardAptitudeTestScore;
     private double gradePointAverage;

     /**
      * Initializes an instance of the UndergraduateApplicant class with the specified applicant name, college name, standard aptitude test score and grade point average.
      * 
      * @param name The name of the undergraduate applicant.
      * @param college The name of the college.
      * @param standardAptitudeTestScore The score achieved on the standard aptitude test. Allowable values: 0.0 - 500.0 inclusive. If this field is set outside the allowable range, set the state to 0 (zero).
      * @param gradePointAverage The grade point average.
      */

     public UndergraduateApplicant(String name, String college, double standardAptitudeTestScore, double gradePointAverage){
         super(name, college); 
         this.setStandardAptitudeTestScore(standardAptitudeTestScore);
         this.setGradePointAverage(gradePointAverage);
     }
       

     /**
      * Gets the score achieved on the standard aptitude test.
      * 
      * @return The score achieved on the standard aptitude test.
      */

     public double getStandardAptitudeTestScore(){
         return this.standardAptitudeTestScore;
     }

     /**
      * Sets the score achieved on the standard aptitude test.
      * 
      * @param standardAptitudeTestScore The score achieved on the standard aptitude test. 
      * Allowable values: 0.0 - 500.0 inclusive. If this field is set outside the allowable range, set the state to 0 (zero).
      */

     public void setStandardAptitudeTestScore(double standardAptitudeTestScore){
       this.standardAptitudeTestScore = getAllowableStandardAptitudeTestScore(standardAptitudeTestScore);
     }

     /**
      * Set the standard aptitude test score allowable values: 0.0 - 500.0 inclusive.
      * If this field is set outside the allowable range, set the state to 0 (zero).
      * 
      * @param standardAptitudeTestScore The score achieved on the standard aptitude test.
      * @return The score achieved on the standard aptitude test.
      */
     private double getAllowableStandardAptitudeTestScore(double standardAptitudeTestScore) {
       if (standardAptitudeTestScore >= 0.0 && standardAptitudeTestScore <= 500) {
           return standardAptitudeTestScore;
       }
       return 0.0;
     }


     /**
      * Gets the grade point average.
      * 
      * @return The grade point average.
      */

     public double getGradePointAverage(){
         return this.gradePointAverage;
     }

     /**
      * Sets the grade point average.
      * 
      * @param gradePointAverage The grade point average.
      */

     public void setGradePointAverage(double gradePointAverage){
       this.gradePointAverage = getAllowableGradePointAverage(gradePointAverage);
     }


     /**
      * Set the grade point average allowable values: 0.00 - 4.50 inclusive.
      * If this field is set outside the allowable range, set the state to 0 (zero).
      * 
      * @param gradePointAverage The grade point average.
      * @return The grade point average.
      */

     private double getAllowableGradePointAverage(double gradePointAverage) {
       if (gradePointAverage >= 0.0 && gradePointAverage <= 4.5) {
           return gradePointAverage;
       }
       return 0.0;
     }

     /**
      * Registers the applicant for the specified program.
      * 
      * @param program The name of the program.
      * @return The name of the program.
      * Returns the String "college_name - program_name [aptitude_test_score]". Example: "Red River College - Business Information Technology [465.3]".
      */

     @Override
     public String registerForProgram(String program){
         return String.format("%s - %s [%.1f]", this.getCollege(), program, this.getStandardAptitudeTestScore());
     }

        


     /**
      * Returns a string representation of the object.
      * 
      * @return A string representation of the object.
      */
     @Override
     public String toString(){

         String str = super.toString();
         String tmp = String.format( "%-12s %-15s%n","SAT Score:", this.getStandardAptitudeTestScore()) 
                     + String.format( "%-12s %-15s%n","GPA:", this.getGradePointAverage());
         return str + tmp;
     }
         
 
}
