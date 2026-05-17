package se.kth.iv1350.repairelectricbike.view;

import se.kth.iv1350.repairelectricbike.integration.RepairOrderDTO;
import se.kth.iv1350.repairelectricbike.model.RepairOrderObserver;

/**
 * The view that shows if repair orders have been updated
 */
public class RepairOrderView implements RepairOrderObserver{

    /**
     * The definition of the view used to create a new one
     */
    public RepairOrderView(){
    }

    /**
     * It prints out the update to a repair order
     * @param oldOrder The old repair order before the update
     * @param updatedOrder The updated repair order
     */
    @Override
    public void repairOrderWasUpdated(RepairOrderDTO oldOrder, RepairOrderDTO updatedOrder){
        printUpdate(oldOrder, updatedOrder);
    }

    private void printUpdate(RepairOrderDTO oldOrder, RepairOrderDTO updatedOrder){
        StringBuilder updateMsg = new StringBuilder();
        updateMsg.append(oldOrder);
        updateMsg.append(" updated to: ");
        updateMsg.append(updatedOrder);
        System.out.println(updateMsg);
    }
}
