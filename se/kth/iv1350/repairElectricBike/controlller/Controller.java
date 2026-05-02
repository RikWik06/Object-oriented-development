package seminar3.javaproject.javaproject.src.se.kth.iv1350.repairElectricBike.controlller;

import seminar3.javaproject.javaproject.src.se.kth.iv1350.repairElectricBike.integration.RepairOrderDTO;
import seminar3.javaproject.javaproject.src.se.kth.iv1350.repairElectricBike.integration.RepairOrderRegistry;

/**
 * The controller to the code
 */
public class Controller {
    /**
     * It finds the repair order connected with the phone number and sets the given string as it's diagnostic result
     * @param repairOrderRegistry The registry of repair orders where the repair order is stored
     * @param phoneSearch The phone number used to identify the repair order
     * @param update The string that's the diagnostic result
     */
    public void addDiagnosticResult(RepairOrderRegistry repairOrderRegistry, int phoneSearch, String update){
        RepairOrderDTO[] registry = repairOrderRegistry.registry;
        int orderIndex = repairOrderRegistry.findRepairOrder(registry, phoneSearch);
        repairOrderRegistry.updateRepairOrder(registry, orderIndex, 1, update);
    }

    /**
     * It finds the repair order connected with the phone number and sets the given string as it's repair task
     * @param repairOrderRegistry The registry of repair orders where the repair order is stored
     * @param phoneSearch The phone number used to identify the repair order
     * @param update The string that's the repair task
     */
    public void addRepairTask(RepairOrderRegistry repairOrderRegistry, int phoneSearch, String update){
        RepairOrderDTO[] registry = repairOrderRegistry.registry;
        int orderIndex = repairOrderRegistry.findRepairOrder(registry, phoneSearch);
        repairOrderRegistry.updateRepairOrder(registry, orderIndex, 2, update);
    }

    /**
     * It finds the repair order connected with the phone number and sets the repair order as accepted
     * @param repairOrderRegistry The registry of repair orders where the repair order is stored
     * @param phoneSearch The phone number used to identify the repair order
     */
    public void acceptRepairOrder(RepairOrderRegistry repairOrderRegistry, int phoneSearch){
        RepairOrderDTO[] registry = repairOrderRegistry.registry;
        int orderIndex = repairOrderRegistry.findRepairOrder(registry, phoneSearch);
        repairOrderRegistry.updateRepairOrder(registry, orderIndex, 3, "Accepted");
    }

    /**
     * It finds the repair order connected with the phone number and sets the repair order as rejected
     * @param repairOrderRegistry The registry of repair orders where the repair order is stored
     * @param phoneSearch The phone number used to identify the repair order
     */
    public void rejectRepairOrder(RepairOrderRegistry repairOrderRegistry, int phoneSearch){
        RepairOrderDTO[] registry = repairOrderRegistry.registry;
        int orderIndex = repairOrderRegistry.findRepairOrder(registry, phoneSearch);
        repairOrderRegistry.updateRepairOrder(registry, orderIndex, 1, "Rejected");
    }

    /**
     * The definition of the controller used to create a new one
     */
    public Controller(){
    }
}
