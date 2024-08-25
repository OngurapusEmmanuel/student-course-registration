package student;

import java.util.ArrayList;
import java.util.List;

public class StudentDB {

    private List<Student> students;

    public StudentDB() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student findStudentById(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return student;
            }
        }
        return null;
    }

}
