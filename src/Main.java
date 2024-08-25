import course.Course;
import course.CourseDB;
import student.Student;
import student.StudentDB;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CourseDB courseDatabase = new CourseDB();
        StudentDB studentDatabase = new StudentDB();

        // Adding sample courses
        courseDatabase.addCourse(new Course("CSE 4406", "System Programming", "Basics of low level programming", 30, "Mon/Wed/Fri 10:00-11:00"));
        courseDatabase.addCourse(new Course("AMA 4103", "Calculus I", "Introduction to Calculus", 25, "Tue/Thu 12:00-13:30"));
        courseDatabase.addCourse(new Course("CSI 4406", "Computer Forensics and Investigation", "Digital investigations on digital evidences", 15, "Wed/Thu 14:00-15:30"));
        // Adding sample students
        studentDatabase.addStudent(new Student("S001", "Alice"));
        studentDatabase.addStudent(new Student("BSCS/047J/2020", "Georges"));
        studentDatabase.addStudent(new Student("BSCS/023J/2020", "Ongurerhpus Emmerhnuel"));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\t\t*****Welcome to student course registration system****\n");
            System.out.println("1. List available courses");
            System.out.println("2. Register for a course");
            System.out.println("3. Drop a course");
            System.out.println("4. List registered courses");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    courseDatabase.listAvailableCourses();
                    break;
                case 2:
                    System.out.print("Enter your student ID: ");
                    String studentId = scanner.nextLine();
                    Student student = studentDatabase.findStudentById(studentId);

                    if (student != null) {
                        System.out.print("Enter course code to register: ");
                        String courseCode = scanner.nextLine();
                        Course course = courseDatabase.findCourseByCode(courseCode);

                        if (course != null) {
                            if (student.registerCourse(course)) {
                                System.out.println("Course registered successfully.\n\n");
                            } else {
                                System.out.println("Course is full or already registered.\n\n");
                            }
                        } else {
                            System.out.println("Course not found.\n\n");
                        }
                    } else {
                        System.out.println("Student not found.\n\n");
                    }
                    break;
                case 3:
                    System.out.print("Enter your student ID: ");
                    studentId = scanner.nextLine();
                    student = studentDatabase.findStudentById(studentId);

                    if (student != null) {
                        System.out.print("Enter course code to drop: ");
                        String courseCode = scanner.nextLine();

                        if (student.dropCourse(courseCode)) {
                            System.out.println("Course dropped successfully.\n\n");
                        } else {
                            System.out.println("Course not found or not registered.\n\n");
                        }
                    } else {
                        System.out.println("Student not found.\n\n");
                    }
                    break;
                case 4:
                    System.out.print("Enter your student ID: ");
                    studentId = scanner.nextLine();
                    student = studentDatabase.findStudentById(studentId);

                    if (student != null) {
                        student.listRegisteredCourses();
                    } else {
                        System.out.println("Student not found.\n\n");
                    }
                    break;
                case 5:
                    System.out.println("Exiting the system.\n\n");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.\n\n");
            }
        }
    }
}