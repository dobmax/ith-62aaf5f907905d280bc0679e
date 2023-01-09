package ua.ithillel.lesson41.homework.persitent.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "STUDENT")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @Column(name = "EMAIL", nullable = false, unique = true, length = 50)
    String email;

    @Column(name = "NAME", nullable = false, length = 30)
    String name;

}
