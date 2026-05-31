package se.kth.iv1350.repairelectricbike.model;

import se.kth.iv1350.repairelectricbike.integration.RepairOrderDTO;

/**
 * The interface for the repair order observer
 */
public interface RepairOrderObserver {
    void repairOrderWasUpdated(RepairOrderDTO oldOrder, RepairOrderDTO updatedOrder);
}
