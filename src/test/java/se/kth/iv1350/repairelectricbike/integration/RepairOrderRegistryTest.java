package se.kth.iv1350.repairelectricbike.integration;

import org.junit.jupiter.api.Test;

import se.kth.iv1350.repairelectricbike.util.LogHandler;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class RepairOrderRegistryTest {
    private RepairOrderRegistry repairOrderRegistry;
    private LogHandler logHandler;

    @BeforeEach
    public void setup() throws IOException{
        logHandler = new LogHandler();
        repairOrderRegistry = new RepairOrderRegistry(logHandler);
    }

    @AfterEach
    public void tearDown(){
        repairOrderRegistry = null;
    }



    @Test
    public void testAddRepairOrder(){
        RepairOrderDTO order = new RepairOrderDTO("The chain disconnected", 1111, "KD83", null, null, null, 0);
        repairOrderRegistry.addRepairOrder(order);
        int expectedIndex = 0;
        int orderIndex = repairOrderRegistry.findRepairOrderIndex(1111);
        assertEquals(expectedIndex, orderIndex, "The index isn't right.");
    }

    @Test
    public void testUpdateRepairOrder(){
        RepairOrderDTO order = new RepairOrderDTO("The chain disconnected", 1111, "KD83", null, null, null, 0);
        repairOrderRegistry.addRepairOrder(order);
        String expTask = "Update";
        repairOrderRegistry.updateRepairOrder(1111, 2, expTask, 2);
        RepairOrderDTO updatedOrder = repairOrderRegistry.findRepairOrder(1111);
        assertEquals(updatedOrder.getRepairTask(), expTask, "The repair order didn't update.");
    }

    @Test
    public void testFindRepairOrderIndex(){
        RepairOrderDTO order = new RepairOrderDTO("The chain disconnected", 1111, "KD83", null, null, null, 0);
        repairOrderRegistry.addRepairOrder(order);
        RepairOrderDTO otherOrder = new RepairOrderDTO("Spike in wheel", 1212, "LF91", null, null, null, 0);
        repairOrderRegistry.addRepairOrder(otherOrder);
        int expectedIndex = 1;
        int orderIndex = repairOrderRegistry.findRepairOrderIndex(1212);
        assertEquals(expectedIndex, orderIndex, "The index isn't right.");
    }

    @Test
    public void testFindRepairOrder(){
        RepairOrderDTO order = new RepairOrderDTO("The chain disconnected", 1111, "KD83", null, null, null, 0);
        repairOrderRegistry.addRepairOrder(order);
        RepairOrderDTO otherOrder = new RepairOrderDTO("Spike in wheel", 1212, "LF91", null, null, null, 0);
        repairOrderRegistry.addRepairOrder(otherOrder);
        String expProblem = "Spike in wheel";
        int expPhoneNr = 1212;
        String expBikeSerialNo = "LF91";
        RepairOrderDTO retrivedOrder = repairOrderRegistry.findRepairOrder(1212);
        assertEquals(expProblem, retrivedOrder.getProblemDesc(), "The found repair order isn't right.");
        assertEquals(expPhoneNr, retrivedOrder.getPhoneNumber(), "The found repair order isn't right.");
        assertEquals(expBikeSerialNo, retrivedOrder.getBikeSerialNo(), "The found repair order isn't right.");
        //I was worried about encaptulation of comparing it to a refrence to itself so isteam im testing all of it's destinktive data
    }

    @Test
    public void testServerDownSituation(){
        repairOrderRegistry.findRepairOrder(-1);
    }
}
