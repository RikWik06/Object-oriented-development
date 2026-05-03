package seminar3.javaproject.javaproject.src.se.kth.iv1350.repairElectricBike.startup;

import seminar3.javaproject.javaproject.src.se.kth.iv1350.repairElectricBike.controlller.Controller;
import seminar3.javaproject.javaproject.src.se.kth.iv1350.repairElectricBike.integration.CustomerDTO;
import seminar3.javaproject.javaproject.src.se.kth.iv1350.repairElectricBike.integration.CustomerRegistry;
import seminar3.javaproject.javaproject.src.se.kth.iv1350.repairElectricBike.integration.Printer;
import seminar3.javaproject.javaproject.src.se.kth.iv1350.repairElectricBike.integration.RepairOrderDTO;
import seminar3.javaproject.javaproject.src.se.kth.iv1350.repairElectricBike.integration.RepairOrderRegistry;
import seminar3.javaproject.javaproject.src.se.kth.iv1350.repairElectricBike.view.View;

/**
 * The main class that starts the program and runs a few tests to test the functionality
 */
public class Main {
    /**
     * Starts the program and runs a few tests
     * @param args Arguments that are not used by java but not the user
     */
    public static void main(String[] args) {
        CustomerDTO[] custRegistry = new CustomerDTO[10];
        CustomerRegistry customerRegistry = new CustomerRegistry(custRegistry);
        RepairOrderDTO[] reOrRegistry = new RepairOrderDTO[10];
        RepairOrderRegistry repairOrderRegistry = new RepairOrderRegistry(reOrRegistry);
        Printer printer = new Printer();
        Controller contr = new Controller();
        View view = new View(contr);

        RepairOrderDTO order = new RepairOrderDTO("The bike exploded",123555,"NO12");
        repairOrderRegistry.addRepairOrder(reOrRegistry, order);
        contr.addDiagnosticResult(repairOrderRegistry, 123555, "It's in smithereens.");
        contr.addRepairTask(repairOrderRegistry, 123555, "Ducktape.");
        contr.acceptRepairOrder(repairOrderRegistry, 123555);
        printer.printReceipt(order);
    }
}