
/**
 * Name:Yifanli
 * Program:Full Stack Web Development
 * Course:ADEV-1009 Programming 1
 * Created:2022-12-08
 * Updated:2022-12-13
 */

 /**
 * Moudule7 Inheritance and Polymorphism
 * 
 * @author yifanli
 * @version 2.0
 * 
 */

 /**
  *GraduateApplicant
  -------------------------------------
  -collegeOfOrigin: String
  -------------------------------------
  +GraduateApplicant(name: String, college: String, collegeOfOrigin: String)
  +getCollegeOfOrigin(): String
  +setCollegeOfOrigin(collegeOfOrigin: String): void
  +isInside(): boolean
  +registerForProgram(program: String): String
  +toString(): String
  */


  public class GraduateApplicant extends CollegeApplicant{

    /**
    * Fields
    * collegeOfOrigin The name of the college where the graduate applicant received their degree.
    * 
    */

    private String collegeOfOrigin;


    /**
     * nitializes an instance of the GraduateApplicant class with a specified name, college name, and college of origin.
     *
     * @param name The name of the graduate applicant.
     * @param college The name of the college.
     * @param collegeOfOrigin The name of the college where the graduate applicant received their degree.
    */

   public GraduateApplicant(String name, String college, String collegeOfOrigin){
       super(name, college);
       this.collegeOfOrigin = collegeOfOrigin;
   }

   /**
    * Returns the college of origin.
    *  
    * @return The college of origin.
    */

       public String getCollegeOfOrigin(){
           return this.collegeOfOrigin;
       }
   
   /**
    * Sets the college of origin. void 
    *  
    * @param collegeOfOrigin The college of origin.
    */

       public void setCollegeOfOrigin(String collegeOfOrigin){
           this.collegeOfOrigin = collegeOfOrigin;
       }

   /**
    * Returns true when the college name and the college of origin are the same (case should not be a factor); otherwise false.
    * 
    * @return true when the college name and the college of origin are the same (case should not be a factor); otherwise false.
    */

       public boolean isInside(){ 
           return this.getCollege().equalsIgnoreCase(this.collegeOfOrigin); 
       }


   /**
    * Returns the String "{college_of_origin} > college_name - program_name". 
    * Example: "Red River College > Red River College - Business Administration".
    * 
    * @param program The name of the program.
    * @return The String "{college_of_origin} > college_name - program_name".
    */

       public String registerForProgram(String program){

       //     Format: {college_of_origin} > {college_name} - {program_name}
       return String.format("%s > %s - %s", this.collegeOfOrigin, this.getCollege(), program);
      
       }

   /**
    * Returns a String representation of the class.
    * 
    * @return A String representation of the class.
    */

       //     Format:
       // =======================
       // College Applicant
       // =======================
       // Name:            {name}
       // College:         {college}
       // Origin:          {collegeOfOrigin}
       
       @Override
       public String toString(){

       
           String str = super.toString(); 
           String tmp = String.format( "%-12s %-15s%n","Origin:", this.collegeOfOrigin);
           str = str+tmp;
           return str;
       }
           
}