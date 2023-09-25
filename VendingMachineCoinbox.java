/*
CSCI 70900 – E. Troudt Fall 2023 
Design a new class named VendingMachineCoinBox. This should allow you to centralize
the code from last week into one class. This is version 1 of the class.
a. This class should have two functions:
i. void acceptCoin( char coin_type ); // accept the same coin
types as last week.
ii. void dispenseChange( ); // Start this function as you did last week.
b. The class should also have a (non-static) instance (class) variable:
i. currentChange.
c. Complete this implementation before moving forward to version #2.
 */

public class VendingMachineCoinbox {

    //private double because acceptCoin is inputing and dispenseChange is outputting change,
    //but only we as the coinbox can actually change it. 
    private int currentChange = 0;
    
    public final static char[] acceptable_coin_chars = {'p','n','d','q','h','g'};

    public final static int[] acceptable_coin_vals = {1,5,10,25,50,100};

    public static void main(String[] args) {
    }

    public void acceptCoin(char coin_type) {
        
        System.out.print("Please enter a coin : ");
     
        // System.out.println("Coin in: " + moneyIn);

        switch (coin_type) {

            case ('p'): // penny
                currentChange += 1;
                break;
            case ('P'): // penny
                currentChange += 1;
                break;
            case ('n'): // nickel
                currentChange += 5;
                break;
            case ('N'): // nickel
                currentChange += 5;
                break;
            case ('d'): // dime
                currentChange += 10;
                break;
            case ('D'): // dime
                currentChange += 10;
                break;
            case ('q'): // quarter
                currentChange += 25;
                break;
            case ('Q'): // quarter
                currentChange += 25;
                break;
            case ('h'): // half dollar
                currentChange += 50;
                break;
            case ('H'): // half dollar
                currentChange += 50;
                break;
            case ('g'): // golden dollar
                currentChange += 100;
                break;
            case ('G'): // golder dollar
                currentChange += 100;
                break;
            default:
                System.out.println("Invalid Coin Entered");
        }


        //100.0 to be real special
        System.out.printf("Your currentChange is $%.2f\n", ((double)currentChange/100.0));
    }
/* [vendingcents.java] Vending machine change maker. On the command line accept an
integer representing the number of cents currently inside of a vending machine. (For
example: java vendingcents 35, would mean that there are $0.35 inside the machine.)
Return all of the money to the user using the largest possible change. (For example,
with $0.65, we do not return 65 pennies, we return 2 quarters and a dime and a nickel.)
The denominations you are using are golden dollar coin ($1.00 or 100 cents), half dollar
coin ($0.50), quarter ($0.25), dime ($0.10), nickel ($0.05), and penny ($0.01). HINT:
Modulus.
*/
public void dispenseChange() {
    //compare currentChange to acceptable_coin_vals
    //from greatest to least, subtract from currentChange the largest denominations of coin
    //until currentChange is zero
    //print out the number of each coin dispensed

    //find out the largest denomination of coin that can be taken from the currentChange
    //take the maximum number of that coin's value from the currentChange
    //check the currentChange again for each of the other coins

    for(int i = acceptable_coin_vals.length - 1; i >= 0; i--){
        int c = 0;
        while (currentChange / acceptable_coin_vals[i] > 1) {
            
            currentChange = currentChange - acceptable_coin_vals[i];
            c = c + 1;
            
        }
        System.out.print("Here is " + c + " " + acceptable_coin_chars[i]);
    }
    }
}
}