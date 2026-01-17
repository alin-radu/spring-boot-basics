package com.dev.spring_boot_jpa_hibernate_advanced.dao;

import com.dev.spring_boot_jpa_hibernate_advanced.entity.Course;
import com.dev.spring_boot_jpa_hibernate_advanced.entity.Instructor;
import com.dev.spring_boot_jpa_hibernate_advanced.entity.InstructorDetail;
import com.dev.spring_boot_jpa_hibernate_advanced.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO {

    private final EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager) {

        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void saveInstructor(Instructor instructor) {

        entityManager.persist(instructor);
    }

    @Override
    public Instructor findInstructorSummaryById(int id) {

        return entityManager.find(Instructor.class, id);
    }

    // delete the instructor and the instructor details;
    @Override
    @Transactional
    public void deleteInstructorById(int id) {

        Instructor tempInstructor = entityManager.find(Instructor.class, id);

        System.out.println("---> tempInstructor will be deleted: " + tempInstructor + " ...");

        for (Course tempCourse : tempInstructor.getCourses()) {

            System.out.println("---> course: " + tempCourse);

            tempCourse.setInstructor(null);
        }

        entityManager.remove(tempInstructor);

    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {

        return entityManager.find(InstructorDetail.class, id);
    }

    // delete instructorDetails, keep the instructor
    @Override
    @Transactional
    public void deleteInstructorDetailById(int id) {

        InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class, id);

        System.out.println("---> tempInstructorDetail will be deleted: " + tempInstructorDetail);

        // break the bidirectional link
        tempInstructorDetail.getInstructor().setInstructorDetail(null);

        entityManager.remove(tempInstructorDetail);

    }

    // findCoursesByInstructorId
    @Override
    public List<Course> findCoursesByInstructorId(int id) {
//        TypedQuery<Course> query = entityManager.createQuery(
//                "SELECT c FROM Course c " +
//                        "INNER JOIN  Instructor as i ON i.id = c.instructor.id " +
//                        "WHERE i.id = :data", Course.class
//        );

        TypedQuery<Course> query = entityManager.createQuery(
                "FROM Course WHERE instructor.id = :data", Course.class
        );

        query.setParameter("data", id);

        return query.getResultList();
    }

    @Override
    public Instructor findInstructorFullInfoById(int id) {

        TypedQuery<Instructor> query = entityManager.createQuery(
                "SELECT i FROM Instructor i " +
                        "JOIN FETCH i.courses " +
                        "JOIN FETCH i.instructorDetail " +
                        "WHERE i.id = :data", Instructor.class
        );

        query.setParameter("data", id);

        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void updateInstructor(Instructor instructor) {

        entityManager.merge(instructor);
    }

    @Override
    public Course findCourseById(int id) {

        return entityManager.find(Course.class, id);
    }

    @Override
    @Transactional
    public void updateCourse(Course course) {

        entityManager.merge(course);
    }

    @Override
    @Transactional
    public void deleteCourseById(int id) {

        Course tempCourse = entityManager.find(Course.class, id);

        entityManager.remove(tempCourse);
    }

    @Override
    @Transactional
    public void saveCourse(Course course) {

        entityManager.persist(course);
    }

    @Override
    public Course findCourseAndReviewsByCourseId(int id) {

        TypedQuery<Course> query = entityManager.createQuery(
                "SELECT c FROM Course c "
                        + "JOIN FETCH c.reviews "
                        + "WHERE c.id = :data", Course.class);

        query.setParameter("data", id);

        return query.getSingleResult();
    }

    @Override
    public Course findCourseAndStudentsByCourseId(int id) {

        TypedQuery<Course> query = entityManager.createQuery(
                "select c from Course c "
                        + "JOIN FETCH c.students "
                        + "where c.id = :data", Course.class);

        query.setParameter("data", id);

        return query.getSingleResult();
    }

    @Override
    public Student findStudentAndCoursesByStudentId(int id) {

        TypedQuery<Student> query = entityManager.createQuery(
                "select s from Student s "
                        + "JOIN FETCH s.courses "
                        + "where s.id = :data", Student.class);

        query.setParameter("data", id);

        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void updateStudent(Student tempStudent) {

        entityManager.merge(tempStudent);
    }

    @Override
    @Transactional
    public void deleteStudentById(int id) {

        Student tempStudent = entityManager.find(Student.class, id);

        entityManager.remove(tempStudent);
    }
}




























