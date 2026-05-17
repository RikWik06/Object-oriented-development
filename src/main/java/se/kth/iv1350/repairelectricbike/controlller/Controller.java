package se.kth.iv1350.repairelectricbike.controlller;

import se.kth.iv1350.repairelectricbike.integration.CustomerRegistry;
import se.kth.iv1350.repairelectricbike.integration.RepairOrderRegistry;
import se.kth.iv1350.repairelectricbike.model.RepairOrderObserver;

/**
 * The controller to the code
 */
public class Controller {
    private RepairOrderRegistry repairOrderRegistry;
    private CustomerRegistry customerRegistry;

    /**
     * It finds the repair order connected with the phone number and sets the given string as it's diagnostic result
     * @param phoneSearch The phone number used to identify the repair order
     * @param update The string that's the diagnostic result
     */
    public void addDiagnosticResult(int phoneSearch, String update){
        repairOrderRegistry.updateRepairOrder(phoneSearch, 1, update, -1);
    }

    /**
     * It finds the repair order connected with the phone number and sets the given string as it's repair task
     * @param phoneSearch The phone number used to identify the repair order
     * @param update The string that's all of the repair tasks. The cost of each seprate task is included in the string together with the task
     * @param totalCost The total cost for all of the repair tasks that the technician has calculated
     */
    public void addRepairTask(int phoneSearch, String update, int totalCost){
        repairOrderRegistry.updateRepairOrder(phoneSearch, 2, update, totalCost);
    }

    /**
     * It finds the repair order connected with the phone number and sets the repair order as accepted
     * @param phoneSearch The phone number used to identify the repair order
     */
    public void acceptRepairOrder(int phoneSearch){
        repairOrderRegistry.updateRepairOrder(phoneSearch, 3, "Accepted", -1);
    }

    /**
     * It finds the repair order connected with the phone number and sets the repair order as rejected
     * @param phoneSearch The phone number used to identify the repair order
     */
    public void rejectRepairOrder(int phoneSearch){
        repairOrderRegistry.updateRepairOrder(phoneSearch, 1, "Rejected", -1);
    }

    /**
     * The definition of the controller used to create a new one
     * @param repairOrderRegistry The registry of repair orders
     * @param customerRegistry The registry of customers
     */
    public Controller(RepairOrderRegistry repairOrderRegistry, CustomerRegistry customerRegistry) {
        this.customerRegistry = customerRegistry;
        this.repairOrderRegistry = repairOrderRegistry;
    }

    /**
     * It adds a repair order observer to the repair order registry
     * @param obs The observer that will be added
     */
    public void addRepairOrderObserver(RepairOrderObserver obs){
        repairOrderRegistry.addRepairOrderObserver(obs);
    }
}
