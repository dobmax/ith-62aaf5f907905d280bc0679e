package ua.ithillel.lesson41.classwork.persistent.repository;

import jakarta.persistence.EntityManagerFactory;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.ithillel.lesson41.homework.persitent.entity.Student;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class StudentOurRepository implements OurRepository<Student, Long> {

    EntityManagerFactory emf;

    @Override
    @Transactional
    public void save(Student entity) {
        try (var session = emf.unwrap(SessionFactory.class).openSession()) {
            session.persist(entity);
            session.flush();
        }
    }

    @Override
    @Transactional
    public void update(Student entity) {
        try (var session = emf.unwrap(SessionFactory.class).openSession()) {
            session.merge(entity);
            session.flush();
        }
    }

    @Override
    public void delete(Student entity) {
        try (var session = emf.unwrap(SessionFactory.class).openSession()) {
            session.remove(entity);
            session.flush();
            session.clear();
        }
    }

    @Override
    public Optional<Student> findById(Long id) {
        try (var session = emf.unwrap(SessionFactory.class).openSession()) {
            return Optional.ofNullable(session.get(Student.class, id));
        }
    }
}
