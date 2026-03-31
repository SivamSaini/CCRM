package edu.ccrm;

import edu.ccrm.config.AppConfig;
import edu.ccrm.domain.*;
import edu.ccrm.io.ImportExportService;
import edu.ccrm.service.CourseService;
import edu.ccrm.service.EnrollmentService;
import edu.ccrm.service.impl.CourseServiceImpl;
import edu.ccrm.service.impl.EnrollmentServiceImpl;
import edu.ccrm.service.impl.StudentServiceImpl;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            AppConfig config = AppConfig.getInstance();
            Path dataDir = config.getDataFolderPath();

            StudentServiceImpl studentService = new StudentServiceImpl();
            CourseService courseService = new CourseServiceImpl(studentService);
            EnrollmentService enrollmentService =
                    new EnrollmentServiceImpl(studentService, courseService, config.getMaxCreditsPerSemester());

            studentService.setEnrollmentService(enrollmentService);

            ImportExportService importExport = new ImportExportService(dataDir);

            System.out.println("Importing sample data...");

            List<Student> students = importExport.importStudents(Paths.get("test-data/students.csv"));
            List<Course> courses = importExport.importCourses(Paths.get("test-data/courses.csv"));

            for (Student student : students) {
                studentService.create(student);
            }

            for (Course course : courses) {
                courseService.create(course);
            }

            System.out.println("\nImported Students:");
            studentService.findAll().forEach(System.out::println);

            System.out.println("\nImported Courses:");
            courseService.findAll().forEach(System.out::println);

            System.out.println("\nTesting enrollment...");
            Student student = students.get(0);
            Course course = courses.get(0);

            enrollmentService.enrollStudent(student.getId(), course.getCode());
            System.out.println("Enrolled " + student.getFullName() + " in " + course.getTitle());

            System.out.println("\nRecording grades...");
            enrollmentService.recordGrade(student.getId(), course.getCode(), Grade.A);
            System.out.println("Recorded grade for " + student.getFullName());

            Student updatedStudent = studentService.findById(student.getId()).orElse(student);
            System.out.println("Current GPA: " + updatedStudent.getGpa());

            System.out.println("\nEnrolled Courses for " + updatedStudent.getFullName() + ":");
            updatedStudent.getEnrolledCourses().forEach(System.out::println);

            System.out.println("\nAverage Grade in " + course.getCode() + ": " +
                    enrollmentService.getAverageGrade(course.getCode()));

            System.out.println("\nDemo completed successfully!");

        } catch (Exception e) {
            System.err.println("Error running demo: " + e.getMessage());
            e.printStackTrace();
        }
    }
}