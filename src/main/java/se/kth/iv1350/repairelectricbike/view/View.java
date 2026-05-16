package se.kth.iv1350.repairelectricbike.view;

import se.kth.iv1350.repairelectricbike.controlller.Controller;

/**
 * The view class that replaces the normal view
 */
public class View {
    private Controller contr;

    /**
     * Used to define and create a view
     * @param contr The controller used to create the view
     */
    public View(Controller contr){
        this.contr = contr;
        contr.addRepairOrderObserver(new RepairOrderView());
    }
}
