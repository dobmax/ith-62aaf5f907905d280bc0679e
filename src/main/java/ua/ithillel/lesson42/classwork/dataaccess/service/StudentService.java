package ua.ithillel.lesson42.classwork.dataaccess.service;

import jakarta.persistence.EntityManagerFactory;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import ua.ithillel.lesson42.classwork.dataaccess.entity.Student;

import java.util.Optional;

@Service
public class StudentService implements EntityService<Student> {

    private final EntityManagerFactory emf;

    public StudentService(EntityManagerFactory emf) {
        this.emf = emf;
    }

    @Override
    public Optional<Student> findById(long id) {
        return Optional.ofNullable(
                emf.unwrap(SessionFactory.class)
                        .openSession()
                        .get(Student.class, id)
        );
    }
}
