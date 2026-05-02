package seminar3.javaproject.javaproject.src.se.kth.iv1350.repairElectricBike.integration;

/**
 * The DTO for customer that stores their information
 */
public class CustomerDTO {
    /**
     * All of the variables that a customer has stored
     * name = The name of the customer
     * email = The customer's e-mail address
     * bikeBrand = The brand of the customer's bike
     * bikeModel = The model of the customer's bike
     * bikeSerialNo = The serial number of the customer's bike
     */
    public String name;
    public String email;
    public String bikeBrand ;
    public String bikeModel;
    public String bikeSerialNo;
    
    /**
     * The definiton of the customer DTO that's used to create new ones
     * @param name The name of the customer
     * @param email The customer's e-mail address
     * @param bikeBrand The brand of the customer's bike
     * @param bikeModel The model of the customer's bike
     * @param bikeSerialNo The serial number of the customer's bike
     */
    public CustomerDTO(String name, String email, String bikeBrand, String bikeModel, String bikeSerialNo){
        this.name = name;
        this.email = email;
        this.bikeBrand = bikeBrand;
        this.bikeModel = bikeModel;
        this.bikeSerialNo = bikeSerialNo;
    }
}
