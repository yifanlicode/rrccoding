/**
 * Name:Yifanli
 * Program:Full Stack Web Development
 * Course:ADEV-1009 Programming 1
 * Created:2022-11-08
 * Updated:2022-11-11
 */

 /**
 * Moudule5 a class encapsulating the concept of Coins.
 * 
 * @author yifanli
 * @version 1.0
 * 
 */

 /**
  *Coins
  -------------------------------------
  -quarters : int
  -dimes int
  -nickels : int
  -QUARTER : double = .25
  -DIME : double = .1
  -NICKEL: double = .05
  -------------------------------------
  + Coins()
  + Coins(quarters : int, dimes : int, nickels : int)
  + getQuarters : int
  + getDimes() : int
  + getNickels() : int
  + setQuarters (quarters : int) : void
  + setDimes (dimes : int) : void
  + setNickels (nickels : int) : void
  + getDollarAmount(): double
  + getDollarAmount(type: CoinType) : double
  + getDollarAmount(quarters : int, dimes : int, nickels : int) : double
  + toString() : String
 */



 public class Coins{

    /**
     * Fields
     * quarters - The number of quarters.
     * dimes - The number of dimes.
     * nickels - The number of nickels.
     * QUARTER - The value of a quarter.
     * DIME - The value of a dime.
     * NICKEL - The value of a nickel.
     */
    private int quarters;
    private int dimes;
    private int nickels;
    private static final double QUARTER = .25;
    private static final double DIME = .1;
    private static final double NICKEL = .05;

   
    /**
     * Initializes a new instance of the Coins class with the specified number of coins for each coin type.
     * 
     * @param quarters The number of quarters.
     * @param dimes The number of dimes.
     * @param nickels The number of nickels.
     */
    public Coins(int quarters,int dimes,int nickels){
      this.setQuarters(quarters); 
      //this.quarters = quarter;
      this.setDimes(dimes);
      //this.dimes = dimes;
      this.setNickels(nickels);
      //this.nickels = nickels;

    }

    /**
     * default constructor that initializes a new instance of the Coins class
     * with 0 coins for each coin type.
     */
    public Coins(){
       this(0,0,0); 
    }

   /**
     * Returns the number of quarters.
     * 
     * @return The number of quarters.
     */

   public int getQuarters(){
     return this.quarters;
   }

   /**
     * Sets the number of quarters.
     * 
     * @param quarters The number of quarters.
     */

    public void setQuarters(int quarters){
        this.quarters = quarters;
    }

    /**
     * Returns number of dimes.
     *  
     * @return The number of dims.
     */
    public int getDimes(){
        return this.dimes;
    }

    /**
     * Sets the number of dimes.
     * 
     * @param dimes The number of dimes.
     */
    public void setDimes(int dimes){
        this.dimes = dimes;
    }

    /**
     * Returns the number of nickels
     * 
     * @return The number of nickels.
     */
    public int getNickels(){
        return this.nickels;
    }

    /**
     * Sets the number of nickels.
     * 
     * @param nickels The number of nickels.
     */
    public void setNickels(int nickels){
        this.nickels = nickels;
    }

  /**
     * Returns the combined dollar value of all coins.
     * 
     * @return dollarAomunt The combined dollar value of all coins.
     */
    public double getDollarAmount() {
        double dollarAmount;
        dollarAmount = this.getQuarters() * QUARTER + this.getDimes() * DIME + this.getNickels() * NICKEL;
        return dollarAmount;
    }
    
    /**
     * Returns the dollar value of all coins of the specified coin type.
     * 
     * @param type The coin type.
     * @return dollarAmount The dollar value of coins based on the CoinType specified.
     */
    public double getDollarAmount(CoinType type) {
        double dollarAmount;
        switch (type) {
            case QUARTER:
                dollarAmount = this.getQuarters() * QUARTER;
                break;
            case DIME:
                dollarAmount = this.getDimes() * DIME;
                break;
            case NICKEL:
                dollarAmount = this.getNickels() * NICKEL;
                break;
            default:
                dollarAmount = 0;
                break;
        }
        return dollarAmount;
    }
    
    /**
     * Returns a double representing the combined dollar value of the specified number of coins for each coin type.
     * 
     * @param quarters The number of quarters.
     * @param dimes The number of dimes.
     * @param nickels The number of nickels.
     * 
     * @return dollarAmount The combined dollar value of all coins.
     */

    public static double getDollarAmount(int quarters, int dimes, int nickels) {
        double dollarAmount;
        dollarAmount = quarters * QUARTER + dimes * DIME + nickels * NICKEL;
        return dollarAmount;
    }
    

    /**
     * Returns the String representation of the class.
     * 
     * @return The String representation of the class.
     */

    public String toString(){
        String str = "Quarters: %d%nDimes: %d%nNickels: %d%nTotal Value: $%.2f%n%n";
        return String.format(str, this.getQuarters(), this.getDimes(), this.getNickels(), this.getDollarAmount());
    }
}

  









   









