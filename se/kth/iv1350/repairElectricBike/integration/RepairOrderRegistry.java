package seminar3.javaproject.javaproject.src.se.kth.iv1350.repairElectricBike.integration;

/**
 * The registry of all of the repair orders for the company
 */
public class RepairOrderRegistry {
    /**
     * The array of repair orders that replace the actual database
     */
    public RepairOrderDTO[] registry;

    /**
     * It adds the given order to the given registry at the first open slot
     * @param repairOrderRegistry The array where all of the repair orders are stored
     * @param order The repair order the user wants to store
     */
    public void addRepairOrder(RepairOrderDTO[] repairOrderRegistry, RepairOrderDTO order){
        int index = 0;
        while (repairOrderRegistry[index] != null)
            index++;
        repairOrderRegistry[index] = order;
    }

    /**
     * It updates the repair order at the given slot based on which method called it
     * @param repairOrderRegistry The array where all of the repair orders are stored
     * @param orderIndex The slot where the repair order is stored in the array
     * @param whatToUpdate A number that dictates what to update, given by computer based on which mehtod called it
     * @param update The update that replaces whatever's on that variable
     */
    public void updateRepairOrder(RepairOrderDTO[] repairOrderRegistry, int orderIndex, int whatToUpdate, String update){
        if (whatToUpdate == 1)
            repairOrderRegistry[orderIndex].diagnosticResult = update;
        if (whatToUpdate == 2)
            repairOrderRegistry[orderIndex].repairTask = update;
        if (whatToUpdate == 3)
            repairOrderRegistry[orderIndex].state = update;
    }

    /**
     * The definition of the repair order registry used to create a new one
     * @param repairRegistry The array that stores the repair orders
     */
    public RepairOrderRegistry(RepairOrderDTO[] repairRegistry){
        this.registry = repairRegistry;
    }
    
    /**
     * It serches through the array to find the repair order with the matching phone number
     * @param repairOrderRegistry The array it serches through
     * @param phoneSearch The phone number used to identify the repair order
     * @return
     */
    public int findRepairOrder(RepairOrderDTO[] repairOrderRegistry, int phoneSearch){
        int index = -1;
        for (int i = 0; i < repairOrderRegistry.length; i++){
            if (repairOrderRegistry[i].phoneNumber == phoneSearch)
                return i;
        }
        return index;

    }
}
