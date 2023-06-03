package ru.netology.home03.dao;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "customers")
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 50)
    String name;

    @Column(length = 50)
    String surname;

    @Column
    Integer age;

    @Column(length = 20, name = "phone_number")
    String phoneNumber;
}
