package se.kth.iv1350.repairelectricbike.startup;

import java.io.IOException;

import se.kth.iv1350.repairelectricbike.controlller.Controller;
import se.kth.iv1350.repairelectricbike.integration.CustomerRegistry;
import se.kth.iv1350.repairelectricbike.integration.Printer;
import se.kth.iv1350.repairelectricbike.integration.RepairOrderRegistry;
import se.kth.iv1350.repairelectricbike.util.LogHandler;
import se.kth.iv1350.repairelectricbike.view.View;

/**
 * The main class that starts the program and runs a few tests to test the functionality
 */
public class Main {
    /**
     * Starts the program and runs a few tests
     * @param args Arguments that are used by the computer, not the user
     * @throws IOException Is thrown by the log handler when the file already excists
     */
    public static void main(String[] args) throws IOException{
        LogHandler logHandler = new LogHandler();
        CustomerRegistry customerRegistry = new CustomerRegistry(logHandler);
        RepairOrderRegistry repairOrderRegistry = new RepairOrderRegistry(logHandler);
        Printer printer = new Printer();
        Controller contr = new Controller(repairOrderRegistry, customerRegistry);
        View view = new View(contr);
    }
}