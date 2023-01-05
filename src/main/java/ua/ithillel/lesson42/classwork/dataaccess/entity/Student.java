package ua.ithillel.lesson42.classwork.dataaccess.entity;

import jakarta.persistence.*;
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

    @Column(name = "name")
    String name;

    @Column(name = "email", unique = true, length = 50)
    String email;
}
