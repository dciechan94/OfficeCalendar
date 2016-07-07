package sample;


import java.util.Date;
import java.util.List;

public interface EventProvider {
    List<CalendarEntry> getEvents(Date from, Date to);
}
