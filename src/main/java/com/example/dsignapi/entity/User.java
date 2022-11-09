package com.example.dsignapi.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "User_TBL")
@Builder
public class User {



    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @Column(name = "userId",unique = true)
    private String userId;
    private String firstName;
    private String lastName;
    @Column(name = "email",unique = true)
    private String email;
    private String password;
    private String phoneNo;
    private String organization;
    private String designation;
    //    private String PdfLocation;
    private String profileImageLocation;
    private String signatureImageLocation;

}


