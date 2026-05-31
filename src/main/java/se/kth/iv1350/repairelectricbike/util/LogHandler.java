package se.kth.iv1350.repairelectricbike.util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * The log handler responseble for writing logs when exceptions are thrown
 */
public class LogHandler{
    private static final String FILE_NAME = "repairelectricbike-log.txt";
    private PrintWriter logFile;

    /**
     * The definiton of the log handler used to create a new one
     * @throws IOException If the file already exists
     */
    public LogHandler() throws IOException {
        logFile = new PrintWriter(new FileWriter(FILE_NAME, true), true);
    }

    /**
     * It logs the given exception
     * @param exception The exception that is to be logged
     */
    public void logException(Exception exception) {
        StringBuilder logMsg = new StringBuilder();
        logMsg.append(timeInfo());
        logMsg.append(", Exception was thrown: ");
        logMsg.append(exception.getMessage());
        logFile.println(logMsg);
        exception.printStackTrace(logFile);
        logFile.println("\n");
    }
    
    private String timeInfo(){
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.
        ofLocalizedDateTime(FormatStyle.MEDIUM);
        return time.format(format);
    }
}
