package se.kth.iv1350.repairelectricbike.view;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

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
        StringBuilder update = new StringBuilder();
        update.append(timeInfo());
        update.append(", Update happend: ");
        update.append(oldOrder.getProblemDesc() + "->" + updatedOrder.getProblemDesc() + ", ");
        update.append(oldOrder.getPhoneNumber() + "->" + updatedOrder.getPhoneNumber() + ", ");
        update.append(oldOrder.getBikeSerialNo() + "->" + updatedOrder.getBikeSerialNo() + ", ");
        update.append(oldOrder.getDiagnosticResult() + "->" + updatedOrder.getDiagnosticResult() + ", ");
        update.append(oldOrder.getRepairTask() + "->" + updatedOrder.getRepairTask() + ", ");
        update.append(oldOrder.getState() + "->" + updatedOrder.getState() + ", ");
        update.append(oldOrder.getTotalCost() + "->" + updatedOrder.getTotalCost() + ", ");
        System.out.println(update);
    }

    private String timeInfo(){
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.
        ofLocalizedDateTime(FormatStyle.MEDIUM);
        return time.format(format);
    }
}
