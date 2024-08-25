package student;

import course.Course;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String studentId;
    private String name;
    private List<Course> registeredCourses;

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public boolean registerCourse(Course course) {
        if (course.enrollStudent()) {
            registeredCourses.add(course);
            return true;
        }
        return false;
    }

    public boolean dropCourse(String courseCode) {
        for (Course course : registeredCourses) {
            if (course.getCourseCode().equals(courseCode)) {
                course.dropStudent();
                registeredCourses.remove(course);
                return true;
            }
        }
        return false;
    }

    public void listRegisteredCourses() {
        if (registeredCourses.isEmpty()) {
            System.out.println("No registered courses.\n\n");
        } else {
            for (Course course : registeredCourses) {
                System.out.println(course.getCourseDetails());
            }
        }
    }

}
