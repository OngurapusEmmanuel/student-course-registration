package course;

import java.util.ArrayList;
import java.util.List;

public class CourseDB {

    private List<Course> courses;

    public CourseDB() {
        this.courses = new ArrayList<>();
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public Course findCourseByCode(String courseCode) {
        for (Course course : courses) {
            if (course.getCourseCode().equals(courseCode)) {
                return course;
            }
        }
        return null;
    }

    public void listAvailableCourses() {
        for (Course course : courses) {
            System.out.println(course.getCourseDetails());
            System.out.println("------------------------------");
        }
    }

}
