package utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public final class DataGenerator {
    public static String returnCurrentTimestamp(SimpleDateFormat simpleDateFormat) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());

        return simpleDateFormat.format(timestamp);

    }
}
