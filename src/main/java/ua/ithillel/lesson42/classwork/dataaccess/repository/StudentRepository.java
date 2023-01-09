package ua.ithillel.lesson42.classwork.dataaccess.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.ithillel.lesson42.classwork.dataaccess.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAllByLastName(String lastName);
    Optional<Student> findByFirstNameAndLastName(String firstName, String lastName);

    // Example, but bad example
    @Query(value = "SELECT * FROM students WHERE lastName = ?1 AND (age >= ?2 AND age <= ?3)", nativeQuery = true)
    Optional<Student> findByLastNameAndAgeBetween(String lastName, int from, int to);
}
