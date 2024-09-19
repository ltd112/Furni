package com.dat.furni.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
@Builder
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

    @ManyToMany
    private Set<Role> roles;


}
