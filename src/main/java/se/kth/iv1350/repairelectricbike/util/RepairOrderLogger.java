package se.kth.iv1350.repairelectricbike.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import se.kth.iv1350.repairelectricbike.integration.RepairOrderDTO;
import se.kth.iv1350.repairelectricbike.model.RepairOrderObserver;

/**
 * The log handler that logs any changes to a repair order
 */
public class RepairOrderLogger implements RepairOrderObserver {
    private static final String FILE_NAME = "repairorderupdates-log.txt";
    private PrintWriter logFile;

    /**
     * The definiton to the logger used to create a new one
     * @throws IOException Is thrown if the file already exists
     */
    public RepairOrderLogger() throws IOException{
        logFile = new PrintWriter(new FileWriter(FILE_NAME, true), true);
    }

    /**
     * It logs any changes to a repair order
     * @param oldOrder The old repair order before it was updated
     * @param updatedOrder The repair order after it was updated
     */
    @Override
    public void repairOrderWasUpdated(RepairOrderDTO oldOrder, RepairOrderDTO updatedOrder) {
        StringBuilder updateLog = new StringBuilder();
        updateLog.append(timeInfo());
        updateLog.append(", Update happend: ");
        updateLog.append(oldOrder);
        updateLog.append(" updated to: ");
        updateLog.append(updatedOrder);
        logFile.println(updateLog);
        logFile.println("\n");
    }
    
    private String timeInfo(){
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.
        ofLocalizedDateTime(FormatStyle.MEDIUM);
        return time.format(format);
    }
}
