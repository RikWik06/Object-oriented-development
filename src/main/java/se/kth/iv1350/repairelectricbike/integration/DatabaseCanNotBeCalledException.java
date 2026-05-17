package se.kth.iv1350.repairelectricbike.integration;

/**
 * The exception that is thrown when the database can not be reached, in this case when a hard coded phone number is used 
 */
public class DatabaseCanNotBeCalledException extends RuntimeException{
    private String exceptionMsg;

    /**
     * The definiton of the exception used to create a new one
     * @param msg The exception's message
     */
    public DatabaseCanNotBeCalledException(String msg){
        super(msg);
        this.exceptionMsg = msg;
    }

    /**
     * It returns the exception's message
     */
    public String getMessage(){
        return exceptionMsg;
    }
}
