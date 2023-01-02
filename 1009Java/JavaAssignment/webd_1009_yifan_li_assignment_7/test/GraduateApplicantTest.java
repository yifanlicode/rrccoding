/**
 * This is a test class for GraduateApplicant class.
 * Module 7 Assignment
 * 
 * @author  yifanli
 * CreateDate     2022-12-11
 * Updated  2022-12-12
 * @version 1.1
 */


public class GraduateApplicantTest
{
    public static void main(String[] args){
        System.out.println("\nGraduateApplicant(String, String, String)");
        // Test #1 - Initialize the name.
        System.out.println("\nTest #1 - Initialize the name.");
        constructor_Graduate_Applicant_name();
        // Test #2 - Initialize the college.
        System.out.println("\nTest #2 - Initialize the college.");
        constructor_Graduate_Applicant_college();
        // Test #3 - Initialize the college of orgin.
        System.out.println("\nTest #3 - Initialize the college of origin.");
        constructor_Graduate_Applicant_collegeOfOrigin();

        System.out.println("\nsetName(String) : void");
        // Test #1 - Update the state of name.
        System.out.println("\nTest #1 - Update the state of name.");
        setName_Graduate_Applicant_name();

        System.out.println("\nsetCollege(String) : void");
        // Test #1 - Update the state of college.
        System.out.println("\nTest #1 - Update the state of college.");
        setCollege_Graduate_Applicant_college();

        System.out.println("\nsetCollegeOfOrigin(String) : void");
        // Test #1 - Update the state of college of origin.
        System.out.println("\nTest #1 - Update the state of college of origin.");
        setCollegeOfOrigin_Graduate_Applicant_collegeOfOrigin();

        System.out.println("\nisInside() : boolean");
        // Test #1 - Return true when the college and the college of origin are the same.
        System.out.println("\nTest #1 - Return true when the college and the college of origin are the same.");
        isInside_Graduate_Applicant_true();
        // Test #2 - Return false when the college and the college of origin are not the same.
        System.out.println("\nTest #2 - Return false when the college and the college of origin are not the same.");
        isInside_Graduate_Applicant_false();

        System.out.println("\nregisterForProgram(String) : String");
        // Test #1 - Return a String indicating the college of origin, college and program name
        System.out.println("\nTest #1 - Return a String indicating the college of origin, college and program name");
        registerForProgram_Graduate_Applicant_string();

        System.out.println("\ntoString() : String");
        // Test #1 - Return the correct String representation.
        System.out.println("\nTest #1 - Return the correct String representation.");
        toString_Graduate_Applicant_string();

    }


    /**
     * GraduateApplicant(String, String, String)
     * Test #1 - Initialize the name.
     * name = "Yifan", college = "Red River College", collegeOfOrigin = "Red River College"
     * Expected: Yifan
     * Actual: Yifan
     */
    public static void constructor_Graduate_Applicant_name(){
        GraduateApplicant applicant = new GraduateApplicant("Yifan", "Red River College", "Red River College");
        String expected = "Yifan";
        String actual = applicant.getName();
        System.out.printf("Expected: %s%nActual: %s%n", expected, actual);
    }

    /**
     * GraduateApplicant(String, String, String)
     * Test #2 - Initialize the college.
     * name = "Yifan", college = "Red River College", collegeOfOrigin = "Red River College"
     * Expected: Red River College
     * Actual: Red River College
     */

    public static void constructor_Graduate_Applicant_college(){
        GraduateApplicant applicant = new GraduateApplicant("Yifan", "Red River College", "Red River College");
        String expected = "Red River College";
        String actual = applicant.getCollege();
        System.out.printf("Expected: %s%nActual: %s%n", expected, actual);
    }

    /**
     * GraduateApplicant(String, String, String)
     * Test #3 - Initialize the college of origin.
     * name = "Yifan", college = "Red River College", collegeOfOrigin = "Red River College"
     * Expected: Red River College
     * Actual: Red River College
     */

    public static void constructor_Graduate_Applicant_collegeOfOrigin(){
        GraduateApplicant applicant = new GraduateApplicant("Yifan", "Red River College", "Red River College");
        String expected = "Red River College";
        String actual = applicant.getCollegeOfOrigin();
        System.out.printf("Expected: %s%nActual: %s%n", expected, actual);
    }

    /**
     * setName(String) : void
     * Test #1 - Update the state of name.
     * name = "Yifan", college = "Red River College", collegeOfOrigin = "Red River College"
     * Expected: Evonne
     * Actual: Evonne
     */

    public static void setName_Graduate_Applicant_name(){
        GraduateApplicant applicant = new GraduateApplicant("Yifan", "Red River College", "Red River College");
        applicant.setName("Evonne");
        String expected = "Evonne";
        String actual = applicant.getName();
        System.out.printf("Expected: %s%nActual: %s%n", expected, actual);
    }

    /**
     * setCollege(String) : void
     * Test #1 - Update the state of college.
     * name = "Yifan", college = "Red River College", collegeOfOrigin = "Red River College"
     * Expected: Fanshawe College
     * Actual: Fanshawe College
     */
    public static void setCollege_Graduate_Applicant_college(){
        GraduateApplicant applicant = new GraduateApplicant("Yifan", "Red River College", "Red River College");
        applicant.setCollege("Fanshawe College");
        String expected = "Fanshawe College";
        String actual = applicant.getCollege();
        System.out.printf("Expected: %s%nActual: %s%n", expected, actual);
    }

    /**
     * setCollegeOfOrigin(String) : void
     * Test #1 - Update the state of college of origin.
     * name = "Yifan", college = "Red River College", collegeOfOrigin = "Red River College"
     * Expected: Fanshawe College
     * Actual: Fanshawe College
     */

    public static void setCollegeOfOrigin_Graduate_Applicant_collegeOfOrigin(){
        GraduateApplicant applicant = new GraduateApplicant("Yifan", "Red River College", "Red River College");
        applicant.setCollegeOfOrigin("Fanshawe College");
        String expected = "Fanshawe College";
        String actual = applicant.getCollegeOfOrigin();
        System.out.printf("Expected: %s%nActual: %s%n", expected, actual);
    }

    /**
     * isInside() : boolean
     * Test #1 - Return true when the college and the college of origin are the same.
     * name = "Yifan", college = "Red River College", collegeOfOrigin = "Red River College"
     * Expected: true
     * Actual: true
     */

    public static void isInside_Graduate_Applicant_true(){
        GraduateApplicant applicant = new GraduateApplicant("Yifan", "Red River College", "Red River College");
        boolean expected = true;
        boolean actual = applicant.isInside();
        System.out.printf("Expected: %s%nActual: %s%n", expected, actual);
    }

    /**
     * isInside() : boolean
     * Test #2 - Return false when the college and the college of origin are not the same.
     * name = "Yifan", college = "Red River College", collegeOfOrigin = "Fanshawe College"
     * Expected: false
     * Actual: false
     */

    public static void isInside_Graduate_Applicant_false(){
        GraduateApplicant applicant = new GraduateApplicant("Yifan", "Red River College", "Fanshawe College");
        boolean expected = false;
        boolean actual = applicant.isInside();
        System.out.printf("Expected: %s%nActual: %s%n", expected, actual);
    }

   
    /**
     * registerForProgram(String) : String
     * Test #1 - Return a String indicating the college of origin, college and program name
     * collegeOfOrigin = "Red River College", college = "Red River College", program = "Full Stack Web Development"
     * Expected: Red River College > Red River College - Full Stack Web Development
     * Actual: Red River College > Red River College - Full Stack Web Development
     */

    public static void registerForProgram_Graduate_Applicant_string(){
        GraduateApplicant applicant = new GraduateApplicant("Yifan", "Red River College", "Red River College");
        String expected = "Red River College > Red River College - Full Stack Web Development";
        String actual = applicant.registerForProgram("Full Stack Web Development");
        System.out.printf("Expected: %s%nActual: %s%n", expected, actual);
    }
    
    /**
     * registerForProgram(String) : String
     * Test #2 - Return a String indicating the college of origin, college and program name
     * name="Yifan" college ="Red River College" collegeOfOrigin = "Red River College", 
     * Expected: =======================
                College Applicant
                =======================
                Name:            Yifan
                College:         Red River College
                Origin:          Red River College
      * Actual:=======================
                  College Applicant
                  =======================
                  Name:            Yifan
                  College:         Red River College
                  Origin:          Red River College
     */

    public static void toString_Graduate_Applicant_string(){
        GraduateApplicant applicant = new GraduateApplicant("Yifan", "Red River College", "Red River College");
        String expected = "=======================\nCollege Applicant\n=======================\nName:        Yifan\nCollege:     Red River College\nOrigin:      Red River College";
        String actual = applicant.toString();
        System.out.printf("Expected: %n%s%n %nActual: %n%s%n", expected, actual);
    }




}
