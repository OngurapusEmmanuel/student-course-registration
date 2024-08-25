package course;

public class Course {

    private String courseCode;
    private String title;
    private String description;
    private int capacity;
    private int enrolledStudents;
    private String schedule;

    public Course(String courseCode, String title, String description, int capacity, String schedule) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.enrolledStudents = 0;
        this.schedule = schedule;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getEnrolledStudents() {
        return enrolledStudents;
    }

    public String getSchedule() {
        return schedule;
    }

    public boolean hasAvailableSlots() {
        return enrolledStudents < capacity;
    }

    public boolean enrollStudent() {
        if (hasAvailableSlots()) {
            enrolledStudents++;
            return true;
        }
        return false;
    }

    public void dropStudent() {
        if (enrolledStudents > 0) {
            enrolledStudents--;
        }
    }

    public String getCourseDetails() {
        return String.format("Course Code: %s\nTitle: %s\nDescription: %s\nSchedule: %s\nAvailable Slots: %d/%d\n\n",
                courseCode, title, description, schedule, capacity - enrolledStudents, capacity);
    }
}


