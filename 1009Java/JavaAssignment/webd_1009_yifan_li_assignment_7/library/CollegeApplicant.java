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
 * @version 1.0
 * 
 */

 /**
  *CollegeApplicant
  -------------------------------------
  -name: String
  -college: String
  -------------------------------------
  +CollegeApplicant()
  +CollegeApplicant(name: String, college: String)
  +getName(): String
  +setName(name: String): void
  +getCollege(): String
  +setCollege(college: String): void
  +registerForProgram(program: String): String
  +toString(): String
 */


public abstract class CollegeApplicant{
    /**
     * Fields
     * name: The name of the college applicant.
     * college: The name of the college.
     * 
     */

    private String name;
    private String college;


    /**
     * Initializes an instance of the CollegeApplicant class where the name and college are set to "unknown".
     * 
     * 
     */

    public CollegeApplicant(){
        this.name = "unknown";
        this.college = "unknown"; 
    }

    /**
     * Initializes an instance of the CollegeApplicant class where the name and college are set to the specified values.
     *  
     * @param name The name of the college applicant.
     * @param college The name of the college.
     */

    public CollegeApplicant(String name, String college){
        this.setName(name);
        this.setCollege(college);
    }

    
     /**
      * Returns the college applicant's name.
      *
      * @return The college applicant's name.
      */

    public String getName(){
        return this.name;
    }

    /**
     * Sets the college applicant's name.
     *
     * @param name The college applicant's name.
     */

    public void setName(String name){
        this.name = name;
    }

    /**
     * Returns the college applicant's college.
     *
     * @return The college applicant's college.
     */

    public String getCollege(){
        return this.college;
    }

    /**
     * Sets the college applicant's college.
     *
     * @param college The college applicant's college.
     */

    public void setCollege(String college){
        this.college = college;
    }

    /**
     * Returns a String representing the registration of a program.
     *
     * @param program The program to register for.
     * @return A String representing the registration of a program.
     */

    public String registerForProgram(String program){
        return this.getName() + " has registered for " + program;
    }

    /**
     * Returns a String representing the college applicant class.
     *
     * @return A String representing the college applicant object.
     */


    public String toString() {

        String str;
        str = "=======================\n"
            + "College Applicant\n" 
            + "=======================\n" ;
            
         
        String tmp1 = String.format("%-12s %-15s%n","Name:", this.getName());
        String tmp2 = String.format("%-12s %-15s%n","College:", this.getCollege());
        str += tmp1 + tmp2;
        return str;
        
            
       
      }

}