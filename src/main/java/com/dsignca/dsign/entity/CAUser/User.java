package com.dsignca.dsign.entity.CAUser;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user_tbl")
public class User {
    @Id
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private Double password;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "phone_no")
    private int phoneNo;
    @Column(name = "organization")
    private String organization;
    @Column(name = "designation")
    private String designation;
    @Column(name = "profile_image_location")
    private String profileImageLocation;
    @Column(name = "sign_image_location")
    private String signImageLocation;
}
