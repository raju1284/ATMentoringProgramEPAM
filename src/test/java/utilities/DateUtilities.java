package utilities;

import org.apache.commons.lang.time.DateUtils;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtilities {
    public String getDate(String transactionDate, DateFormat dateFormat)
    {
        return transactionDate.startsWith("today +") ? getFormattedFutureDate(transactionDate, dateFormat)
              :transactionDate.startsWith("today _") ? getFormattedPastDate(transactionDate, dateFormat)
                :transactionDate.startsWith("today") ? getTodayFormattedDate(dateFormat):transactionDate;
    }
    public String getTodayFormattedDate(DateFormat dateFormat)
    {
        return dateFormat.format(Calendar.getInstance().getTime());
    }
    public String getFormattedFutureDate(String days, DateFormat dateFormat)
    {
        int numberOfDays = Integer.parseInt(days.substring(days.indexOf("+")));
        return dateFormat.format(DateUtils.addDays(new Date(),+numberOfDays));
    }

    public String getFormattedPastDate(String days, DateFormat dateFormat)
    {
        int numberOfDays = Integer.parseInt(days.substring(days.indexOf("-")));
        return dateFormat.format(DateUtils.addDays(new Date(),--numberOfDays +1));
    }

}
