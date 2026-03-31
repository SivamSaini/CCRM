package edu.ccrm.service;

import edu.ccrm.domain.Course;
import edu.ccrm.domain.Semester;
import java.util.List;

public interface CourseService extends CrudService<Course, String> {
    List<Course> findByDepartment(String department);
    List<Course> findBySemester(Semester semester);
    List<Course> findByInstructor(String instructorId);
    void assignInstructor(String courseCode, String instructorId);
    void deactivateCourse(String courseCode);
    List<Course> searchByTitle(String titleQuery);
    List<Course> filterByCredits(int minCredits, int maxCredits);
    List<Course> filterActiveByDepartmentAndSemester(String department, Semester semester);
}