package se.kth.iv1350.repairelectricbike.integration;

import java.io.IOException;

import se.kth.iv1350.repairelectricbike.model.RepairOrderObserver;
import se.kth.iv1350.repairelectricbike.util.LogHandler;
import se.kth.iv1350.repairelectricbike.util.RepairOrderLogger;
import se.kth.iv1350.repairelectricbike.view.ErrorMessageHandler;

/**
 * The registry of all of the repair orders for the company
 */
public class RepairOrderRegistry {
    private RepairOrderDTO[] registry;
    private LogHandler logHandler;
    private RepairOrderLogger repairOrderLogger;
    private RepairOrderObserver[] RepairOrderObservers;

    /**
     * It adds the given order to the given registry at the first open slot
     * @param order The repair order the user wants to store
     */
    public void addRepairOrder(RepairOrderDTO order){
        RepairOrderDTO[] registry = this.registry;
        int index = 0;
        while (registry[index] != null)
            index++;
        registry[index] = order;
    }

    /**
     * It updates the repair order at the given slot based on which method called it
     * @param orderIndex The slot where the repair order is stored in the array
     * @param whatToUpdate A number that dictates what to update, given by computer based on which mehtod called it
     * @param update The update that replaces whatever's on that variable
     * @param totalCost The total cost update, which is only changed if the repair task is changed
     */
    public void updateRepairOrder(int phoneSearch, int whatToUpdate, String update, int totalCost){
        int orderIndex = findRepairOrderIndex(phoneSearch);
        RepairOrderDTO[] registry = this.registry;
        RepairOrderDTO order = registry[orderIndex];
        if (whatToUpdate == 1) {
            RepairOrderDTO updatedOrder = new RepairOrderDTO(order.getProblemDesc(), order.getPhoneNumber(), order.getBikeSerialNo(), update, order.getRepairTask(), order.getState(), order.getTotalCost());
            notifyObservers(order, updatedOrder);
            registry[orderIndex] = updatedOrder;
        }
        if (whatToUpdate == 2) {
            RepairOrderDTO updatedOrder = new RepairOrderDTO(order.getProblemDesc(), order.getPhoneNumber(), order.getBikeSerialNo(), order.getDiagnosticResult(), update, order.getState(), totalCost);
            notifyObservers(order, updatedOrder);
            registry[orderIndex] = updatedOrder;
        }
        if (whatToUpdate == 3) {
            RepairOrderDTO updatedOrder = new RepairOrderDTO(order.getProblemDesc(), order.getPhoneNumber(), order.getBikeSerialNo(), order.getDiagnosticResult(), order.getRepairTask(), update, order.getTotalCost());
            notifyObservers(order, updatedOrder);
            registry[orderIndex] = updatedOrder;
        }
    }

    /**
     * It notifies the all of the observers if a repair order was updated and gives the repair orders so that the change can be shown
     * @param oldOrder The old repair order before it was updated
     * @param updatedOrder The new, updated repair order
     */
    private void notifyObservers(RepairOrderDTO oldOrder, RepairOrderDTO updatedOrder){
        for (int i = 0; i < RepairOrderObservers.length; i++){
            if(RepairOrderObservers[i] != null) {
                RepairOrderObservers[i].repairOrderWasUpdated(oldOrder, updatedOrder);
            }
        }
    }

    /**
     * The defintion of the repair order registry which is just an array or repair order DTOs
     * @param logHandler The log handler used to make logs when exceptions happen
     * @throws IOException If the repair order logger file already exsists
     */
    public RepairOrderRegistry(LogHandler logHandler) throws IOException{
        RepairOrderDTO[] registry = new RepairOrderDTO[10];
        this.registry = registry;
        this.logHandler = logHandler;
        this.repairOrderLogger = new RepairOrderLogger();
        this.RepairOrderObservers = new RepairOrderObserver[10];
    }
    
    /**
     * It searches through the array to find the repair order with the matching phone number and returns it's index
     * @param phoneSearch The phone number used to identify the repair order
     * @return The index of the repair order in the registry
     */
    public int findRepairOrderIndex(int phoneSearch){
        RepairOrderDTO[] registry = this.registry;
        int index = -1;
        for (int i = 0; i < registry.length; i++){
            if (registry[i].getPhoneNumber() == phoneSearch)
                return i;
        }
        return index;
    }

    /**
     * It searches through the array to find the repair order with the matching phone number and returns it
     * @param phoneSearch The phone number used to identify the repair order 
     * @return The repair order with the matching phone number
     * @throws DatabaseCanNotBeCalledException If the exception if the phone number is -1, which is just a way to simulate the database being unreachable
     */
    public RepairOrderDTO findRepairOrder(int phoneSearch) throws DatabaseCanNotBeCalledException{
        if (phoneSearch == -1){
            DatabaseCanNotBeCalledException exception = new DatabaseCanNotBeCalledException("The database is not reachable at the moment.");
            ErrorMessageHandler errorHandler = new ErrorMessageHandler();
            errorHandler.showErrorMsg(exception.getMessage());
            logHandler.logException(exception);
            throw exception;
        }
        RepairOrderDTO[] registry = this.registry;
        RepairOrderDTO order = null;
        for (int i = 0; i < registry.length; i++){
            if (registry[i].getPhoneNumber() == phoneSearch)
                return registry[i];
        }
        return order;
    }

    /**
     * Adds the given observer to the list of observers
     * @param obs The observer that is to be added
     */
    public void addRepairOrderObserver(RepairOrderObserver obs){
        RepairOrderObserver[] observers = this.RepairOrderObservers;
        int index = 0;
        while (observers[index] != null)
            index++;
        observers[index] = obs;
    }
}
