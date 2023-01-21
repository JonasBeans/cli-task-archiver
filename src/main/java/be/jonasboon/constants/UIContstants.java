package be.jonasboon.constants;

import java.time.LocalDateTime;
import java.util.List;

public class UIContstants {

    public static final List<String> UI_POSSIBLE_CHOICES = List.of("1", "2", "3", "4", "5");
    private static final String TASK_SEPERATOR = "=====================================================================================\n\n";
    public static String createTimeStamp() {
        StringBuilder timeStampOfToday = new StringBuilder(TASK_SEPERATOR);
        timeStampOfToday.append(LocalDateTime.now() + "\n\n");
        timeStampOfToday.append(TASK_SEPERATOR);
        return timeStampOfToday.toString();
    }
}
