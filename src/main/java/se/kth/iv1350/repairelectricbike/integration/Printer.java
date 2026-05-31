package se.kth.iv1350.repairelectricbike.integration;

/**
 * A class that acts as a placeholder for a real printer
 */
public class Printer {
    /**
     * The definition of a printer used to create a new one
     */
    public Printer(){
    }

    /**
     * It prints out all of the attributes of a repair order by printing them out in the terminal
     * @param order The repair order that's supposed to be printed out
     */
    public String printReceipt(RepairOrderDTO order, String repairEstimation) {
        String receipt = ("-----Receipt-----"
        + "\nThe inital issue: " + order.getProblemDesc()
        + "\nCustomer's phone number: " + order.getPhoneNumber()
        + "\nBike serial number: "+ order.getBikeSerialNo()
        + "\nDiagnostic result: "+ order.getDiagnosticResult()
        + "\nRepair task: "+ order.getRepairTask()
        + "\nState: "+ order.getState()
        + "\nTime estimation: "+ repairEstimation
    );
    return receipt;
    }
}
