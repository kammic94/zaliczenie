package pl.jkan.carrentalapp.carcatalog;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
class Car {
    @Id
    Long id;

    @Column
    String name;
    @Column
    String model;

    String segment;
    String capacity;
}
