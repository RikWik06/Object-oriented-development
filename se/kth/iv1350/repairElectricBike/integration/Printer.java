package seminar3.javaproject.javaproject.src.se.kth.iv1350.repairElectricBike.integration;

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
    public void printReceipt(RepairOrderDTO order) {
        System.out.println("The inital issue: " + order.problemDesc 
        + "\nCustomer's phone number: " + order.phoneNumber 
        + "\nBike serial number: "+ order.bikeSerialNo
        + "\nDiagnostic result: "+ order.diagnosticResult
        + "\nRepair task: "+ order.repairTask
        + "\nState: "+ order.state
    );
    }
}
