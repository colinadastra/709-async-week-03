/**
This is the coinbox for ASYNC 709
@author luke 
@author colin
*/


/*
CSCI 70900 – E. Troudt Fall 2023 
Design a new class named VendingMachineCoinBox. This should allow you to centralize
the code from last week into one class. This is version 1 of the class.
a. This class should have two functions:
i. void acceptCoin( char coin_type ); // accept the same coin
types as last week.
CHECK
ii. void dispenseChange( ); // Start this function as you did last week.
CHECK
b. The class should also have a (non-static) instance (class) variable:
i. currentChange.
CHECK

c. Complete this implementation before moving forward to version #2. 
CHECK

As you know, a vending machine does not have unlimited coins of each type. We will
have to take into account the coins inside the machine’s coin box. (Do not eliminate
currentChange; you still need to keep track of how much money the current user
placed in the machine.)

b. The class should also have a final, static (shared) array (see Chapter 7’s reading):
i. char[] acceptableCoinChars.
CHECK
ii. int[] acceptableCoinVals.
CHECK
iii. Although these are two separate arrays, you should use them in parallel. That is,
if acceptableCoinChars[2] = ‘d’ then acceptableCoinVals[2]
= 10.
CHECK

c. Add an instance array (instance means non-static) and instance value-returning function:
i. int[] changeSet. This array should keep a count of how many of each of
the coin types are available in the machine.
CHECK
ii. int getChangeValue(), which returns the value of the current amount of
change in the machine. This should be dynamically calculated from the
changeSet. Please note that this is the total of the coins in the machine,
which is distinctly different than currentChange, which only takes into
account the current user.
CHECK

d. Update the functions from 4a/4b to properly use the changeSet array. This will mean
a significant update to both methods, as you now have to update an array of coins.
CHECK
i. For acceptCoin() – eliminate the switch statement and instead use a loop
that traverses the two parallel arrays to check if the coin letter matches and then
finds the corresponding value. It should update the appropriate field of the
changeSet[] in addition to currentChange.
CHECK
ii. For dispenseChange() – Please note that you can’t provide coins that you
do not have. So, be sure that your dispenseChange function is not doing so.
You can use a similar loop to the previous function and skip coins that are not
available in the machine (i.e., provide 2 dimes and a nickel when you’ve run out
of quarters).
CHECK

e. Build a new no-argument constructor (e.g., public
VendingMachineCoinBox(){... ) that initializes the changeSet to have 10 of
each coin type.
CHECK
f. This concludes version 2 of the VendingMachineCoinBox.
CHECK
 */

public class VendingMachineCoinbox {

    //private double because acceptCoin is inputing and dispenseChange is outputting change,
    //but only we as the coinbox can actually change it. 
    private int currentChange = 0;

    private int[] changeSet;
    
    public final static char[] acceptable_coin_chars = {'p','n','d','q','h','g'};

    public final static int[] acceptable_coin_vals = {1,5,10,25,50,100};

    public VendingMachineCoinbox() {
        changeSet = new int[6];
        for (int i = 0; i < changeSet.length; i++) {
            changeSet[i] = 10;
        }
    }

    //returning the amount of change that the machine has total
    public int getChangeValue() {
        //dynamically calculate the value of changeSet, how much money is in the machine at one time
        //as it dispenses and recieves coins, it calculates the value and returns it to the user
        int val = 0;
        for (int i = 0; i < changeSet.length; i++) {
            val += acceptable_coin_vals[i] * changeSet[i];
        }
        return val;
    }
    public static void main(String[] args) {
    }

    public void acceptCoin(char coin_type) {
        
    //System.out.print("Please enter a coin : ");
    // System.out.println("Coin in: " + moneyIn);
    for (int i = 0 ; i < changeSet.length; i++) {
        if (acceptable_coin_chars[i] == coin_type) {
            currentChange += acceptable_coin_vals[i];
            changeSet[i] += 1;
            break;
        }
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
        //for each coin, we want to first check if it exist in changeSet
        int c = 0;
        while ((currentChange / acceptable_coin_vals[i] >= 1) && (changeSet[i] > 0)) {
            currentChange = currentChange - acceptable_coin_vals[i];
            c = c + 1;
            changeSet[i] -= 1;
            //System.out.println("Here is a " + acceptable_coin_chars[i]);         
        }
        System.out.println("Here is " + c + " " + acceptable_coin_chars[i]);
    }
    //System.out.print(currentChange);
    }
}

