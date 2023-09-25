/**
This is the inventory machine for ASYNC 709
@author luke 
@author colin
*/


public class VendingMachineInventory {
    private String[] itemNames;
    private int[][] numCosts;

    public VendingMachineInventory() {
        itemNames = new String[] {"Doritos", "Oreos", "Snickers", "Water", "Dr. Pepper"};
        numCosts = new int[][] {{5,5,5,5,5},{1,2,1,2,1}};
    }

    public String toString() {
        String summary = "Item Name\tQuantity\tCost\n";
        String tabs = "";
        for (int i = 0; i < itemNames.length; i++) {
            if (itemNames[i].length()<8) {
                tabs = "\t\t";
            } else {
                tabs = "\t";
            }
            summary += itemNames[i] + tabs + numCosts[0][i] + "\t\t" + numCosts[1][i] + "\n";
        }
        return summary;
    }
}