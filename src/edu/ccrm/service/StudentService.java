package edu.ccrm.service;

import edu.ccrm.domain.Student;
import java.util.List;

public interface StudentService extends CrudService<Student, String> {
    List<Student> findByEnrolledCourseCode(String courseCode);
    List<Student> findByGpaGreaterThan(double gpa);
    void deactivateStudent(String studentId);
    List<Student> searchByName(String nameQuery);
    void updateGpa(String studentId);
    double calculateGpa(String studentId);
}