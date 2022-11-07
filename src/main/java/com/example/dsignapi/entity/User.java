package com.example.dsignapi.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "User_TBL")
@Builder
public class User {

    public String getUserid() {
        return Userid;
    }

    public void setUserid(String userid) {
        Userid = userid;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String lastname) {
        Lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public int getPhoneNo() {
        return PhoneNo;
    }

    public void setPhoneNo(int phoneNo) {
        PhoneNo = phoneNo;
    }

    public String getOrganization() {
        return Organization;
    }

    public void setOrganization(String organization) {
        Organization = organization;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String designation) {
        Designation = designation;
    }

    public String getProfileImageLocation() {
        return ProfileImageLocation;
    }

    public void setProfileImageLocation(String profileImageLocation) {
        ProfileImageLocation = profileImageLocation;
    }

    public String getSignatureImageLocation() {
        return SignatureImageLocation;
    }

    public void setSignatureImageLocation(String signatureImageLocation) {
        SignatureImageLocation = signatureImageLocation;
    }

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String Userid;
    private String Firstname;
    private String Lastname;
    @Column(name = "email",unique = true)
    private String email;
    private String Password;
    private int PhoneNo;
    private String Organization;
    private String Designation;
    //    private String PdfLocation;
    private String ProfileImageLocation;
    private String SignatureImageLocation;


}


