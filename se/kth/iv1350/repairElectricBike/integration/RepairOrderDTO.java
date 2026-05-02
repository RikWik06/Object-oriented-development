package seminar3.javaproject.javaproject.src.se.kth.iv1350.repairElectricBike.integration;

/**
 * The DTO for repair orders
 */
public class RepairOrderDTO {
    /**
     * All of the variables that each repair order has
     * problemDesc = A description of the problem with the bike given by the customer
     * phoneNumber = The customers phone number
     * bikeSerialNo = The bike's serial number
     * diagnosticResult = A string containing all of the problems with the bike that the technician could identify
     * repairTask = A string of all the taskes needed to repair the bike writen by the technician
     * state = The state of the repair order such as undefined, accepted or rejected
     */
    public String problemDesc;
    public int phoneNumber;
    public String bikeSerialNo;
    public String diagnosticResult;
    public String repairTask;
    public String state;

    /**
     * The definition of the DTO for repair orders that's used to create new ones
     * @param problemDesc A description of the problem with the bike given by the customer
     * @param phoneNumberThe customers phone number
     * @param bikeSerialNo The bike's serial number
     * @param diagnosticResult An empty string that'll be used by the technician later
     * @param repairTask An empty string that'll be used by the technician later
     * @param state An empty string that'll be used by the technician later
     */
    public RepairOrderDTO(String problemDesc,int phoneNumber,String bikeSerialNo,String diagnosticResult, String repairTask,String state){
        this.problemDesc = problemDesc;
        this.phoneNumber = phoneNumber;
        this.bikeSerialNo = bikeSerialNo;
        this.diagnosticResult = diagnosticResult;
        this.repairTask = repairTask;
        this.state = state;
    }
}
