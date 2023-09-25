
public class changeBoxTest{
public static void main(String[] args) {
    
    //call upon all the functions from the coinbox
    //first create a new vending machine
    VendingMachineCoinbox coinbox = new VendingMachineCoinbox();
    System.out.println("Total current change is " + coinbox.getChangeValue());
    //need to accept coins and dispense change
    //while loop while user can continue to enter coins until they choose to vend
    //then vend, or at least decrement set and current change
    coinbox.acceptCoin('q');
    System.out.println("New total change" + coinbox.getChangeValue());

coinbox.dispenseChange();

    


}
}