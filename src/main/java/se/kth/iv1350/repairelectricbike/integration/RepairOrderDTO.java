package se.kth.iv1350.repairelectricbike.integration;

/**
 * The DTO for repair orders
 */
public class RepairOrderDTO {
    private String problemDesc;
    private int phoneNumber;
    private String bikeSerialNo;
    private String diagnosticResult;
    private String repairTask;
    private String state;
    private int totalCost;

    /**
     * The definition of the DTO for repair orders that's used to create new ones
     * @param problemDesc A description of the problem with the bike given by the customer
     * @param phoneNumberThe customers phone number
     * @param bikeSerialNo The bike's serial number
     * @param diagnosticResult The bike's diagnostics result writen by the technicians
     * @param repairTask The bike's repair task writen by the technicians
     * @param state The repair order's state writen by the technicians
     * @param totalCost The total cost for all of the repair tasks, calculated by the technician
     */
    public RepairOrderDTO(String problemDesc,int phoneNumber,String bikeSerialNo, String diagnosticResult, String repairTask, String state, int totalCost){
        this.problemDesc = problemDesc;
        this.phoneNumber = phoneNumber;
        this.bikeSerialNo = bikeSerialNo;
        this.diagnosticResult = diagnosticResult;
        this.repairTask = repairTask;
        this.state = state;
        this.totalCost = totalCost;
    }

    /**
     * It's used to get the repair order's problem desciption
     * @return The repair order's problem description
     */
    public String getProblemDesc(){
        return problemDesc;
    }

    /**
     * It's used to get the phone number for the repair order's customer
     * @return The customer's phone number
     */
    public int getPhoneNumber(){
        return phoneNumber;
    }

    /**
     * It's used to get the bike's serial number
     * @return The bike's serial number
     */
    public String getBikeSerialNo(){
        return bikeSerialNo;
    }

    /**
     * It's used to get the repair order's diagnostic result
     * @return The repair order's diagnostic result
     */
    public String getDiagnosticResult(){
        return diagnosticResult;
    }

    /**
     * It's used to get the repair order's repair task(s)
     * @return The repair order's repair task(s)
     */
    public String getRepairTask(){
        return repairTask;
    }

    /**
     * It's used to get the repair order's state such as accepted/denied
     * @return The repair order's state
     */
    public String getState(){
        return state;
    }

    /**
     * It's used to get the total cost for all of the repair task(s)
     * @return The total cost
     */
    public int getTotalCost(){
        return totalCost;
    }
}
