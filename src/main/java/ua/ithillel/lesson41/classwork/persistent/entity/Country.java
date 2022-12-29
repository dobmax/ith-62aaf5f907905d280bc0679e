package ua.ithillel.lesson41.classwork.persistent.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "Country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    long id;

    @Column(unique = true, nullable = false, length = 30)
    String name;

    @OneToOne
    @JoinColumn(
            name = "mainland_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "country_mainland_fk")
    )
    Mainland mainland;
}
