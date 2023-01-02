/**
 * Name:Yifanli
 * Program:Full Stack Web Development
 * Course:ADEV-1009 Programming 1
 * Created:2022-11-11
 * Updated:2022-11-11
 */

 /**
 * Moudule5  Test all test cases outlined in the test plan
 * 
 * @author yifanli
 * @version 1.0
 * 
 */


public class CoinClient {

  public static void main(String[] args) {
    
    System.out.println("Coins(int, int, int)" );

    System.out.println( "Test #1 - Initialize the number of quarters.");
    constructor1_quarters_test();

    System.out.println( "Test #2 - Initialize the number of dimes.");
    constructor1_dimes_test();

    System.out.println( "Test #3 - Initialize the number of nickels.");
    constructor1_nickels_test();

    System.out.println("Coins()");
    System.out.println("Test #1 - Iniialize the number of quarters.");
    constructor2_quarters_test();

    System.out.println("Test #2 - Iniialize the number of dimes.");
    constructor2_dimes_test();

    System.out.println("Test #3 - Iniialize the number of nickels.");
    constructor2_nickels_test();

    System.out.println("setQuarters(int): void");
    System.out.println("Test #1 - Update the state of quarters.");
    setQuarters_quarters_updateState();

    System.out.println("setDimes(int) : void");
    System.out.println("Test #1 - Update the state of dimes.");
    setDimes_dimes_updateState();


    System.out.println("setNickels(int) : void");
    System.out.println("Test #1 - Update the state of nickels.");
    setNickels_nickels_updateState();

    System.out.println("getDollarAmount() : double");
    System.out.println("Test #1 - Return the correct dollar amount.");
    getDollarAmount_returnCorrectDollarAmount();

    System.out.println("getDollarAmount(CoinType) : double");
    System.out.println("Test #1 - Return the correct dollar amount for the quarter CoinType.");
    getDollarAmount_quarter_returnCorrectDollarAmount();

    System.out.println("Test #2 - Return the correct dollar amount for the dime CoinType.");
    getDollarAmount_dime_returnCorrectDollarAmount();

    System.out.println("Test #3 - Return the correct dollar amount for the nickel CoinType.");
    getDollarAmount_nickel_returnCorrectDollarAmount();

    System.out.println("(static) getDollarAmount(int, int, int) : double");
    System.out.println("Test #1 - Return the correct dollar amount.");
    getDollarAmount_static_returnCorrectDollarAmount();

    System.out.println("toString() : String");
    System.out.println("Test #1 - Return the correct String representation.");
    toString_returnCorrectStringRepresentation();
  }


 /*
  * Contrutor1 - Coins(int,int,int)  Initialize the number of quarters.
  */

  public static void constructor1_quarters_test(){

    //Setup test data
    int quarters = 3;
    int dimes = 6;
    int nickels = 9;

    //Act
    Coins target = new Coins(quarters, dimes, nickels);

    //Confirm
    int expected = 3;
    int actual = target.getQuarters();
    
    System.out.printf("Expected: %d%nActual : %d%n%n", expected, actual);
  }

  /*
  * Contrutor1 - Coins(int,int,int)  Initialize the number of dimes.
  */

  public static void constructor1_dimes_test(){

    //Setup test data
    int quarters = 3;
    int dimes = 6;
    int nickels = 9;

    //Act
    Coins target = new Coins(quarters, dimes, nickels);

    //Confirm
    int expected = 6;
    int actual = target.getDimes();
    
    System.out.printf("Expected: %d%nActual : %d%n%n", expected, actual);
  }

  /*
  * Contrutor1 - Coins(int,int,int)  Initialize the number of nickels.
  */

  public static void constructor1_nickels_test(){

    //Setup test data
    int quarters = 3;
    int dimes = 6;
    int nickels = 9;

    //Act
    Coins target = new Coins(quarters, dimes, nickels);

    //Confirm
    int expected = 9;
    int actual = target.getNickels();
    
    System.out.printf("Expected: %d%nActual : %d%n%n", expected, actual);
  }


  /*
  * Contrutor2 - Coins()  Initialize the number of quarters.
  */

  public static void constructor2_quarters_test(){

    //Act
    Coins target = new Coins();

    //Confirm
    int expected = 0;
    int actual = target.getQuarters();
    
    System.out.printf("Expected: %d%nActual : %d%n%n", expected, actual);
  }


  /*
  * Contrutor2 - Coins()  Initialize the number of dimes.
  */

  public static void constructor2_dimes_test(){

    //Act
    Coins target = new Coins();

    //Confirm
    int expected = 0;
    int actual = target.getDimes();
    
    System.out.printf("Expected: %d%nActual : %d%n%n", expected, actual);
  }

  /*
  * Contrutor2 - Coins()  Initialize the number of nickels.
  */

  public static void constructor2_nickels_test(){

    //Act
    Coins target = new Coins();

    //Confirm
    int expected = 0;
    int actual = target.getNickels();
    
    System.out.printf("Expected: %d%nActual : %d%n%n", expected, actual);
  }

  
  /*
  * setQuarters(int)  Update the state of quarters.
  */

  public static void setQuarters_quarters_updateState(){

    //Setup test data
    int quarters = 3;
    int dimes = 6;
    int nickels = 9;

    //Act
    Coins target = new Coins(quarters, dimes, nickels);
    target.setQuarters(5);

    //Confirm
    int expected = 5;
    int actual = target.getQuarters();
    
    System.out.printf("Expected: %d%nActual : %d%n%n", expected, actual);
  }

  /*
  * setDimes(int)  Update the state of dimes.
  */

  public static void setDimes_dimes_updateState(){

    //Setup test data
    int quarters = 3;
    int dimes = 6;
    int nickels = 9;

    //Act
    Coins target = new Coins(quarters, dimes, nickels);
    target.setDimes(10);

    //Confirm
    int expected = 10;
    int actual = target.getDimes();
    
    System.out.printf("Expected: %d%nActual : %d%n%n", expected, actual);
  }

  /*
  * setNickels(int)  Update the state of nickels.
  */

  public static void setNickels_nickels_updateState(){

    //Setup test data
    int quarters = 3;
    int dimes = 6;
    int nickels = 9;

    //Act
    Coins target = new Coins(quarters, dimes, nickels);
    target.setNickels(15);

    //Confirm
    int expected = 15;
    int actual = target.getNickels();
    
    System.out.printf("Expected: %d%nActual : %d%n%n", expected, actual);
  }

  /*
  * getDollarAmount()  Return the correct dollar amount.
  */

  public static void getDollarAmount_returnCorrectDollarAmount(){

    //Setup test data
    int quarters = 3;
    int dimes = 6;
    int nickels = 9;

    //Act
    Coins target = new Coins(quarters, dimes, nickels);

    //Confirm
    double expected = 1.95;
    double actual = target.getDollarAmount();

    
    System.out.printf("Expected: %f%nActual : %f%n%n", expected, actual);
  }

  /*
  * getDollarAmount()  Return the correct dollar amount for the quarter CoinType.
  */

  public static void getDollarAmount_quarter_returnCorrectDollarAmount(){

    //Setup test data
    int quarters = 3;
    int dimes = 6;
    int nickels = 9;

    //Act
    Coins target = new Coins(quarters, dimes, nickels);

    //Confirm
    double expected = 0.75;
    double actual = target.getDollarAmount(CoinType.QUARTER);

    
    System.out.printf("Expected: %f%nActual : %f%n%n", expected, actual);
  }

  /*
  * getDollarAmount()  Return the correct dollar amount for the dime CoinType.
  */

  public static void getDollarAmount_dime_returnCorrectDollarAmount(){

    //Setup test data
    int quarters = 3;
    int dimes = 6;
    int nickels = 9;

    //Act
    Coins target = new Coins(quarters, dimes, nickels);

    //Confirm
    double expected = 0.60;
    double actual = target.getDollarAmount(CoinType.DIME);

    
    System.out.printf("Expected: %f%nActual : %f%n%n", expected, actual);
  }

  /*
  * getDollarAmount()  Return the correct dollar amount for the nickel CoinType.
  */

  public static void getDollarAmount_nickel_returnCorrectDollarAmount(){

    //Setup test data
    int quarters = 3;
    int dimes = 6;
    int nickels = 9;

    //Act
    Coins target = new Coins(quarters, dimes, nickels);

    //Confirm
    double expected = 0.45;
    double actual = target.getDollarAmount(CoinType.NICKEL);
    
    System.out.printf("Expected: %f%nActual : %f%n%n", expected, actual);
  }

  /*
  * (static) getDollarAmount(int, int, int) : double
  * Return the correct dollar amount.
  */

  public static void getDollarAmount_static_returnCorrectDollarAmount(){

    //Setup test data
    int quarters = 3;
    int dimes = 6;
    int nickels = 9;

    //Confirm
    double expected = 1.80;
    double actual = Coins.getDollarAmount(quarters, dimes, nickels);

    
    System.out.printf("Expected: %f%nActual : %f%n%n", expected, actual);
  }

  /*
  * toString() : String 
  * Return the correct string representation.
  */

  public static void toString_returnCorrectStringRepresentation(){

    //Setup test data
    int quarters = 3;
    int dimes = 6;
    int nickels = 9;

    //Act
    Coins target = new Coins(quarters, dimes, nickels);

    //Confirm
    String expected = "Quarters: 3\nDimes: 6\nNickels: 9\nTotal Value: $1.80\n";
    String actual = target.toString();
    
    System.out.printf("Expected:%n%s%nActual:%n%s%n%n", expected, actual);
  }

}
