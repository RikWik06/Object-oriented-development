package se.kth.iv1350.repairelectricbike.integration;

import se.kth.iv1350.repairelectricbike.util.LogHandler;
import se.kth.iv1350.repairelectricbike.view.ErrorMessageHandler;

/**
 * The registry used to store the information of customers
 */
public class CustomerRegistry {
    private CustomerDTO[] registry;
    private LogHandler logHandler;

    /**
     * It add the given customer to the registry
     * @param customer The customer that gets added to the registry
     */
    public void addCustomer(CustomerDTO customer){
        int index = 0;
        CustomerDTO[] registry = this.registry;
        while (registry[index] != null)
            index++;
        registry[index] = customer;
    }

    /**
     * The definition of the registry that's used to make new ones
     * @param logHandler The log handler used to print logs when exceptions happen
     */
    public CustomerRegistry(LogHandler logHandler){
        CustomerDTO[] registry = new CustomerDTO[10];
        this.registry = registry;
        this.logHandler = logHandler;
    }

    /**
     * It finds the customer's index in the registry
     * @param phoneSearch The phone number used to identify the customer
     * @return The customer's index in the registry
     * @throws CustomerRegistryException Throws the exception if no customer can be found with the matching phone number
     */
    public int findCustomerIndex(int phoneSearch) throws CustomerRegistryException{
        CustomerDTO[] registry = this.registry;
        for (int i = 0; i < registry.length; i++){
            if (registry[i].getPhoneNumber() == phoneSearch)
                return i;
        }
        manageNoCustomerFoundByPhoneNo(phoneSearch);
        return -1;
    }

    /**
     * It finds the customer in the registry
     * @param phoneSearch The phone number used to identify the customer
     * @return The customerDTO to the matching customer
     * @throws CustomerRegistryException Throws the exception if no customer can be found with the matching phone number
     */
    public CustomerDTO findCustomer(int phoneSearch) throws CustomerRegistryException{
        CustomerDTO[] registry = this.registry;
        for (int i = 0; i < registry.length; i++){
            if(registry[i] != null) {
                if (registry[i].getPhoneNumber() == phoneSearch)
                    return registry[i];
            }
        }
        manageNoCustomerFoundByPhoneNo(phoneSearch);
        return null;
    }

    /**
     * Manages all of the things that happen when no customer can be found with a phone number such as print to the view and log it
     * @param phoneNumber The phone number that didn't match any of the customers
     * @throws CustomerRegistryException Throws it because no customer could be found with the matching phone number
     */
    private void manageNoCustomerFoundByPhoneNo(int phoneNumber) throws CustomerRegistryException{
        CustomerRegistryException expection = new CustomerRegistryException("Could not find a customer in the registry with the phone number: " + phoneNumber);
        ErrorMessageHandler errorHandler = new ErrorMessageHandler();
        errorHandler.showErrorMsg(expection.getMessage());
        logHandler.logException(expection);
        throw expection;
    }
}
