package be.jonasboon.constants;

import java.util.List;

import static be.jonasboon.utils.TimeUtils.formattedTimeStamp;

public class UIContstants {

    public static final List<String> UI_POSSIBLE_CHOICES = List.of("1", "2", "3", "4", "5");
    private static final String TASK_SEPERATOR = "=====================================================================================\n\n";
    public static String createTimeStamp() {
        StringBuilder timeStampOfTodayString = new StringBuilder();

        timeStampOfTodayString.append(TASK_SEPERATOR);
        timeStampOfTodayString.append(formattedTimeStamp()).append("\n\n");
        timeStampOfTodayString.append(TASK_SEPERATOR);

        return timeStampOfTodayString.toString();
    }
}
