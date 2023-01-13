package pt.iscte.mei.school.util;

import java.time.LocalDateTime;

public final class DateUtils {

    public static LocalDateTime formatDate(String date) {
        return LocalDateTime.parse(date);
    }
}
