//package BrotherMenu;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import Actors.Student;
//import Date.DataBase;
//import Exceptions.ExceededCreditException;
//import Science.*;
//import Interfaces.*;
//import Actors.*;
//import Enums.*;
//import Exceptions.*;
//import java.io.IOException;
//import java.util.Comparator.*;
//import Science.*;
//import java.util.*;
//import Interfaces.*;
//import Date.*;
//import Task.*;
//public class StudentMenu {
//
//    private Student student;
//    private DataBase dataBase;
//    private BufferedReader reader;
//
//    public StudentMenu(Student student) throws IOException, ClassNotFoundException {
//        this.student = student;
//        this.dataBase = DataBase.getInstance();
//        this.reader = new BufferedReader(new InputStreamReader(System.in));
//    }
//
//    public void showMenu() throws IOException, ClassNotFoundException {
//        String menuOptions = "\nWelcome, Student: " + student.getName() + """
//                \n1. View enrolled courses.
//                2. View transcript.
//                3. Register for a course.
//                4. View diploma project.
//                5. View major courses.
//                6. View minor courses.
//                7. View faculty.
//                8. View or join organizations.
//                9. View teacher info.
//                10. Update personal details.
//                0. Logout.""";
//        boolean isRunning = true;
//        while (isRunning) {
//            System.out.println(menuOptions);
//            String option = reader.readLine();
//            switch (option) {
//                case "1":
//                    viewEnrolledCourses();
//                    break;
//                case "2":
//                    viewTranscript();
//                    break;
//                case "3":
//                    registerForCourse();
//                    break;
//                case "4":
//                    viewDiplomaProject();
//                    break;
//                case "5":
//                    viewMajorCourses();
//                    break;
//                case "6":
//                    viewMinorCourses();
//                    break;
//                case "7":
//                    viewFacultyDetails();
//                    break;
//                case "8":
//                    manageOrganizations();
//                    break;
//                case "9":
//                    viewTeacherInfo();
//                    break;
//                case "10":
//                    updatePersonalDetails();
//                    break;
//                case "0":
//                    isRunning = false;
//                    System.out.println("Logged out successfully.");
//                    break;
//                default:
//                    System.out.println("Invalid option. Please try again.");
//            }
//        }
//    }
//
//    // Implementing all the methods from the Student class
//
//    private void viewEnrolledCourses() throws IOException, ClassNotFoundException {
//        System.out.println("Enrolled Courses: ");
//        student.getEnrolledCourses().forEach(System.out::println);
//    }
//
//    private void viewTranscript() throws IOException, ClassNotFoundException {
//        Transcript transcript = student.getTranscript();
//        System.out.println("Transcript: " + transcript);
//    }
//
//    private void registerForCourse() throws IOException {
//        System.out.println("Available Courses: ");
//        dataBase.getCourses().forEach(System.out::println);
//        System.out.print("Enter Course ID to register: ");
//        String courseId = reader.readLine();
//        try {
//            Course course = dataBase.getCourseById(courseId);
//            student.registerForCourse(course);
//            System.out.println("Registered successfully for course: " + course.getName());
//        } catch (ExceededCreditException e) {
//            System.out.println("Error: " + e.getMessage());
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    private void viewDiplomaProject() throws IOException, ClassNotFoundException {
//        System.out.println("Diploma Project: " + student.getDiplomaProject());
//    }
//
//    private void viewMajorCourses() throws IOException, ClassNotFoundException {
//        System.out.println("Major Courses: ");
//        student.getMajor().forEach(System.out::println);
//    }
//
//    private void viewMinorCourses() throws IOException, ClassNotFoundException {
//        System.out.println("Minor Courses: ");
//        student.getMinor().forEach(System.out::println);
//    }
//
//    private void viewFacultyDetails() {
//        System.out.println("Faculty: " + student.getFaculty());
//    }
//
//    private void manageOrganizations() throws IOException {
//        // Code to manage student's organization involvement
//        // This can include viewing current organizations or joining new ones
//    }
//
//    private void viewTeacherInfo() throws IOException {
//        // Code to view information about teachers of a specific course
//    }
//
//    private void updatePersonalDetails() {
//        // Implement functionality to update student's personal details
//    }
//
//    // Additional methods as required
//
//    // More methods can be added here as needed to provide full functionality
//}
