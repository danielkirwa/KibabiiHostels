package com.example.kibabiihostels;

public class Student {
    String email;
    String firstname;
    String middlename;
    String lastname;
    String retistrationnumber;
    String password;
    String idnumber;
    String phone;


    //firebase requires an empty constructor, otherwise the app will not work well
    public Student() {
    }


    public Student(String email, String firstname, String middlename, String lastname, String retistrationnumber, String password, String idnumber, String phone) {
        this.email = email;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.retistrationnumber = retistrationnumber;
        this.password = password;
        this.idnumber = idnumber;
        this.phone = phone;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getRetistrationnumber() {
        return retistrationnumber;
    }

    public void setRetistrationnumber(String retistrationnumber) {
        this.retistrationnumber = retistrationnumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdnumber() {
        return idnumber;
    }

    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}