package se.kth.iv1350.repairelectricbike.integration;

/**
 * The exception used when something went wrong with the customer registry
 */
public class CustomerRegistryException extends RuntimeException {
    private String exceptionMsg;

    /**
     * The definiton used to create a new customer registry exception
     * @param msg The message for the exception
     */
    public CustomerRegistryException(String msg){
        super(msg);
        this.exceptionMsg = msg;
    }

    /**
     * It's used to get the exception's message
     * @return The exception's message
     */
    public String getMessage(){
        return exceptionMsg;
    }
}
