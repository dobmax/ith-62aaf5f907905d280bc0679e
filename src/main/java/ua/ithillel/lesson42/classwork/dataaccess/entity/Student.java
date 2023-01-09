package ua.ithillel.lesson42.classwork.dataaccess.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "STUDENT")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student {
    @Id
    @GeneratedValue
    long id;

    @Column(name = "first_name", nullable = false, length = 30)
    String firstName;

    @Column(name = "last_name", nullable = false, length = 30)
    String lastName;

    @Column(name = "age", nullable = false)
    int age;

    @Column(name = "email", unique = true, length = 50)
    String email;
}
