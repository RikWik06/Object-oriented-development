package se.kth.iv1350.repairelectricbike.view;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * The handler for error messages when exceptions happen
 */
public class ErrorMessageHandler{

    /**
     * The definiton for the handler used to create a new one
     */
    public ErrorMessageHandler(){
    }

    /**
     * It prints out the error message
     * @param msg The exception's message
     */
    public void showErrorMsg(String msg){
        StringBuilder errorMsg = new StringBuilder();
        errorMsg.append(timeInfo());
        errorMsg.append(", ERROR: ");
        errorMsg.append(msg);
        System.out.println(errorMsg);
    }

    private String timeInfo(){
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.
        ofLocalizedDateTime(FormatStyle.MEDIUM);
        return time.format(format);
    }
}
