package Time;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class TimeHelper {

    public int getTime() {

        Date date = new Date();
        return (int) date.getTime();
    }

    public String getLocalTime() {

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.SHORT, Locale.ENGLISH);
        return dateFormat.format(date);
    }
}
