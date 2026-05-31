package se.kth.iv1350.repairelectricbike.controlller;

import se.kth.iv1350.repairelectricbike.integration.CustomerDTO;
import se.kth.iv1350.repairelectricbike.integration.CustomerRegistry;
import se.kth.iv1350.repairelectricbike.integration.CustomerRegistryException;
import se.kth.iv1350.repairelectricbike.integration.RepairOrderDTO;
import se.kth.iv1350.repairelectricbike.integration.RepairOrderRegistry;
import se.kth.iv1350.repairelectricbike.model.RepairOrderObserver;
import se.kth.iv1350.repairelectricbike.integration.Printer;

/**
 * The controller to the code
 */
public class Controller {
    private RepairOrderRegistry repairOrderRegistry;
    private CustomerRegistry customerRegistry;
    private Printer printer;

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
    public String acceptRepairOrder(int phoneSearch, String repairEstimation){
        repairOrderRegistry.updateRepairOrder(phoneSearch, 3, "Accepted", -1);
        RepairOrderDTO order = findRepairOrder(phoneSearch);
        return printer.printReceipt(order, repairEstimation);
    }

    /**
     * It finds the repair order connected with the phone number and sets the repair order as rejected
     * @param phoneSearch The phone number used to identify the repair order
     */
    public void rejectRepairOrder(int phoneSearch){
        repairOrderRegistry.updateRepairOrder(phoneSearch, 3, "Rejected", -1);
    }

    /**
     * The definition of the controller used to create a new one
     * @param repairOrderRegistry The registry of repair orders
     * @param customerRegistry The registry of customers
     */
    public Controller(RepairOrderRegistry repairOrderRegistry, CustomerRegistry customerRegistry, Printer printer) {
        this.customerRegistry = customerRegistry;
        this.repairOrderRegistry = repairOrderRegistry;
        this.printer = printer;
    }

    /**
     * It adds a repair order observer to the repair order registry
     * @param obs The observer that will be added
     */
    public void addRepairOrderObserver(RepairOrderObserver obs){
        repairOrderRegistry.addRepairOrderObserver(obs);
    }

    /**
     * It add the given customer to the registry
     * @param customer The customer that gets added to the registry
     */
    public void addCustomer(CustomerDTO customer){
        customerRegistry.addCustomer(customer);
    }

    /**
     * It adds the given order to the given registry at the first open slot
     * @param order The repair order the user wants to store
     */
    public void addRepairOrder(RepairOrderDTO order){
        repairOrderRegistry.addRepairOrder(order);
    }

    /**
     * It finds the customer in the registry
     * @param phoneSearch The phone number used to identify the customer
     * @return The customerDTO to the matching customer
     * @throws CustomerRegistryException Throws the exception if no customer can be found with the matching phone number
     */
    public CustomerDTO findCustomer(int phoneSearch) throws CustomerRegistryException{
        return customerRegistry.findCustomer(phoneSearch);
    }

    /**
     * It searches through the array to find the repair order with the matching phone number and returns it
     * @param phoneSearch The phone number used to identify the repair order 
     * @return The repair order with the matching phone number
     */
    public RepairOrderDTO findRepairOrder(int phoneSearch){
        return repairOrderRegistry.findRepairOrder(phoneSearch);
    }

    /**
     * It returns a customer's name
     * @param customer The customer that we want the name of
     * @return The customer's name
     */
    public String getCustomerName(CustomerDTO customer){
        return customer.getName();
    }
}
