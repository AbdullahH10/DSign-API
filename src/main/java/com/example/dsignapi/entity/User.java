package com.example.dsignapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "User_TBL")
public class User {
    @Id
    @GeneratedValue
    private int Userid;

    public int getUserid() {
        return Userid;
    }

    public void setUserid(int userid) {
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
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
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

    private String Firstname;
    private String Lastname;
    private String Email;
    private String Password;
    private int PhoneNo;
    private String Organization;
    private String Designation;
    //    private String PdfLocation;
    private String ProfileImageLocation;
    private String SignatureImageLocation;


}


