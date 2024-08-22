package com.dat.furni.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id")
    private String id;

    @Column(name = "username", unique = true, columnDefinition = "VARCHAR(255)")
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private LocalDate dob;
    private String address;

    @OneToOne(mappedBy = "user" ,cascade = CascadeType.ALL)
    private Cart cart;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Order> orders;


}
