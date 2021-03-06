package duckie.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * A task type in charge of task containing Event date and time.
 */
public class Event extends Task implements Comparable<Event> {
    protected static final DateTimeFormatter DT_FORMATTER = DateTimeFormatter.ofPattern("E, MMM dd yyyy hh:mm a");
    protected LocalDateTime dateTime;

    /**
     * Instantiatess a Event task.
     *
     * @param description Description of the task.
     * @param dateTime Date and Time of the task.
     */
    public Event(String description, LocalDateTime dateTime) {
        super(description);
        this.dateTime = dateTime;
    }

    /**
     * Overrides method to return the type of the Event task.
     *
     * @return "E" string.
     */
    @Override
    public String getType() {
        return "E";
    }

    /**
     * Overrides method to return the date and time of the Event task.
     *
     * @return Date and Time string of Event Task.
     */
    @Override
    public String getDate() {
        return DT_FORMATTER.format(this.dateTime);
    }


    /**
     * Overrides method to return the String representation of a Event task.
     *
     * @return String representation of Event task.
     */
    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + DT_FORMATTER.format(this.dateTime) + ")";
    }

    /**
     * Compare the date of two event tasks.
     *
     * @param event2 Task to be compared with.
     * @return 1 if current task is later, -1 if current task is earlier and
     * 0 if current task and task2 have the same dates.
     */
    @Override
    public int compareTo(Event event2) {
        return this.dateTime.compareTo(event2.dateTime);
    }
}
