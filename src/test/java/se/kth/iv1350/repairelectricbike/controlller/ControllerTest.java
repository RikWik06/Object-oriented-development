package se.kth.iv1350.repairelectricbike.controlller;

import org.junit.jupiter.api.Test;

import se.kth.iv1350.repairelectricbike.controlller.Controller;
import se.kth.iv1350.repairelectricbike.integration.CustomerRegistry;
import se.kth.iv1350.repairelectricbike.integration.RepairOrderDTO;
import se.kth.iv1350.repairelectricbike.integration.RepairOrderRegistry;
import se.kth.iv1350.repairelectricbike.util.LogHandler;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class ControllerTest {
    private Controller contr;
    private CustomerRegistry customerRegistry;
    private RepairOrderRegistry repairOrderRegistry;
    private LogHandler logHandler;
    
    @BeforeEach
    public void setup() throws IOException{
        logHandler = new LogHandler();
        customerRegistry = new CustomerRegistry(logHandler);
        repairOrderRegistry = new RepairOrderRegistry(logHandler);
        contr = new Controller(repairOrderRegistry, customerRegistry);
    }

    @AfterEach
    public void tearDown(){
        customerRegistry = null;
        repairOrderRegistry = null;
        contr = null;
    }



    @Test
    public void testDiagnostic(){
        RepairOrderDTO order = new RepairOrderDTO("Paint scratched", 1111, "KD83", "a", null, null, 0);
        repairOrderRegistry.addRepairOrder(order);
        String expDiag = "The paint has been scaped off.";
        contr.addDiagnosticResult(1111, expDiag);
        RepairOrderDTO updatedOrder = repairOrderRegistry.findRepairOrder(1111);
        assertEquals(expDiag, updatedOrder.getDiagnosticResult(), "The diagnostic result didn't update.");
    }

    @Test
    public void testRepair(){
        RepairOrderDTO order = new RepairOrderDTO("Broken wheel", 1212, "KF41", "The wheel holder broke.", null, null, 0);
        repairOrderRegistry.addRepairOrder(order);
        String expTask = "Replace the wheel holder, 20kr. Install new wheel, 50kr";
        int expTotalCost = 70;
        contr.addRepairTask(1212, expTask, 70);
        RepairOrderDTO updatedOrder = repairOrderRegistry.findRepairOrder(1212);
        assertEquals(expTask, updatedOrder.getRepairTask(), "The repair task didn't update.");
        assertEquals(expTotalCost, updatedOrder.getTotalCost(), "The total cost didn't update.");
    }

    @Test
    public void testState(){
        RepairOrderDTO order = new RepairOrderDTO("The bell won't work", 1313, "SH78", "The inside of the bell broke", "Replace the bell, 22kr.", null, 22);
        repairOrderRegistry.addRepairOrder(order);
        String expState = "Accepted";
        contr.acceptRepairOrder(1313);
        RepairOrderDTO updatedOrder = repairOrderRegistry.findRepairOrder(1313);
        assertEquals(expState, updatedOrder.getState(), "The state didn't update.");
    }
}
