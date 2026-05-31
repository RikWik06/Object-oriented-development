package se.kth.iv1350.repairelectricbike.view;

import java.io.IOException;

import se.kth.iv1350.repairelectricbike.controlller.Controller;
import se.kth.iv1350.repairelectricbike.integration.CustomerDTO;
import se.kth.iv1350.repairelectricbike.integration.CustomerRegistryException;
import se.kth.iv1350.repairelectricbike.integration.DatabaseCanNotBeCalledException;
import se.kth.iv1350.repairelectricbike.integration.RepairOrderDTO;
import se.kth.iv1350.repairelectricbike.util.RepairOrderLogger;

/**
 * The view class that replaces the normal view
 */
public class View {
    private Controller contr;
    private ErrorMessageHandler errorHandler;

    /**
     * Used to define and create a view
     * @param contr The controller used to create the view
     */
    public View(Controller contr) throws IOException{
        this.contr = contr;
        contr.addRepairOrderObserver(new RepairOrderView());
        contr.addRepairOrderObserver(new RepairOrderLogger());
        this.errorHandler = new ErrorMessageHandler();
        runBasicFlow();
    }

    private void runBasicFlow() throws CustomerRegistryException{
        CustomerDTO customerAlreadyInDatabase = new CustomerDTO("Lisa Stenson", 555, "lisa@gmail.com", "Volvo", "Speed-9000", "B1KE");
        contr.addCustomer(customerAlreadyInDatabase);

        System.out.println("---------------Receptionsist searches for customer with wrong number.");
        try {
            contr.findCustomer(5555);
        } catch (CustomerRegistryException customerRegistryException) {
            String customerRegistryErrorMsg = "Could not find customer with phone number: 5555";
            errorHandler.showErrorMsg(customerRegistryErrorMsg);
        }

        System.out.println("---------------Receptionsist searches for customer with right number after seeing error msg.");
        CustomerDTO customer = contr.findCustomer(555);
        String customerName = contr.getCustomerName(customer);
        System.out.println("Customer with the name " + customerName + "was found.");
        RepairOrderDTO order = new RepairOrderDTO("The chain broke",555, "B1KE", null, null, null, 0);
        contr.addRepairOrder(order);

        System.out.println("---------------Technician trying to find the repair order but the server is down.");
        try {
            contr.findRepairOrder(-1);
        } catch (DatabaseCanNotBeCalledException databaseException) {
            String databaseErrorMsg = "Database could not be reached at the moment.";
            errorHandler.showErrorMsg(databaseErrorMsg);
        }

        System.out.println("---------------Technician updates the repair order after server is back up again.");
        contr.addDiagnosticResult(555, "The chain is broken.");
        contr.addRepairTask(555, "Replace the chain for 25kr.", 25);

        System.out.println("---------------The customer accepts the repair order after seeing it.");
        String receipt = contr.acceptRepairOrder(555, "1-2 days");
        System.out.println(receipt);
    }
}
