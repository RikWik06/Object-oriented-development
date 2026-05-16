package se.kth.iv1350.repairelectricbike.integration;

/**
 * The DTO for customer that stores their information
 */
public class CustomerDTO {
    private String name;
    private int phoneNumber;
    private String email;
    private String bikeBrand ;
    private String bikeModel;
    private String bikeSerialNo;
    
    /**
     * The definiton of the customer DTO that's used to create new ones
     * @param name The name of the customer
     * @param email The customer's e-mail address
     * @param bikeBrand The brand of the customer's bike
     * @param bikeModel The model of the customer's bike
     * @param bikeSerialNo The serial number of the customer's bike
     */
    public CustomerDTO(String name, int phoneNumber, String email, String bikeBrand, String bikeModel, String bikeSerialNo){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.bikeBrand = bikeBrand;
        this.bikeModel = bikeModel;
        this.bikeSerialNo = bikeSerialNo;
    }

    /**
     * It's used to get the name of a customer from a CustomerDTO
     * @return The customer's name
     */
    public String getName(){
        return name;
    }

    /**
     * It's used to get the phone number of a customer from a CustomerDTO
     * @return The customer's phone number
     */
    public int getPhoneNumber(){
        return phoneNumber;
    }

    /**
     * It's used to get the email of a customer from a CustomerDTO
     * @return The customer's email
     */
    public String getEmail(){
        return email;
    }

    /**
     * It's used to get the bike brand of a customer's bike from a CustomerDTO
     * @return The bike's brand
     */
    public String getBikeBrand(){
        return bikeBrand;
    }

    /**
     * It's used to get the bike model of a customer's bike from a CustomerDTO
     * @return The bike's model
     */
    public String getBikeModel(){
        return bikeModel;
    }

    /**
     * It's used to get the bike serial number of a customer's bike from a CustomerDTO
     * @return The bike's serial number
     */
    public String getBikeSerialNo(){
        return bikeSerialNo;
    }
}
