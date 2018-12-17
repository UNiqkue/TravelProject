package com.netcracker.travel.entity;

import com.netcracker.travel.entity.enumeration.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "admin")
@Inheritance(strategy = InheritanceType.JOINED)
public class Admin extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "activation_code")
    private String activationCode;

    @Column(name = "role")
    @Enumerated(EnumType.ORDINAL)
    private Role role;

}
