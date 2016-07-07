package sample;

import java.util.Date;

public class CalendarEntry {
    private Date start;
    private Date end;
    private String summary;

    private CalendarEntry(CalendarEntryBuilder builder) {
        start = builder.start;
        end = builder.end;
        summary = builder.summary;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    public String getSummary() {
        return summary;
    }

    @Override
    public String toString() {
        return start.toString() + " --- " + end.toString() + " --- " + summary;
    }

    public static class CalendarEntryBuilder {
        private Date start;
        private Date end;
        private String summary;

        public CalendarEntryBuilder() {

        }

        public CalendarEntryBuilder start(Date start) {
            this.start = start;
            return this;
        }

        public CalendarEntryBuilder end(Date end) {
            this.end = end;
            return this;
        }

        public CalendarEntryBuilder summary(String summary) {
            this.summary = summary;
            return this;
        }

        public CalendarEntry build() {
            return new CalendarEntry(this);
        }
    }
}
