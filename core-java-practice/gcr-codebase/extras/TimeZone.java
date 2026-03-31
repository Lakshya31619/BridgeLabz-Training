import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
public class TimeZone {
    public static void main(String[] args) {
        //DateTimeFormatter to extract Time from ZonedDateTime
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        //ZonedDateTime to fetch GMT. IST and PST
        ZonedDateTime gmt = ZonedDateTime.now(ZoneId.of("GMT"));
        ZonedDateTime ist = ZonedDateTime.now(ZoneId.of("Asia/Kolkata"));
        ZonedDateTime pst = ZonedDateTime.now(ZoneId.of("America/Vancouver"));
        //Output
        System.out.println("Current time in GMT : "+gmt.format(formatter));
        System.out.println("Current time in IST : "+ist.format(formatter));
        System.out.println("Current time in PST : "+pst.format(formatter));
    }
}