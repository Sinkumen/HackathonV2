package com.example.cnkua.rdihackathon;



public class Refugee {
    private int Id;
    private String FirstName;
    private String LastName;
    private int age;
    private String Gender;
    private String Email;
    private  int phoneNumber;
    private  String origin;

    public Refugee(String firstName, String lastName, int age, String gender, String email, int phoneNumber, String origin) {
        FirstName = firstName;
        LastName = lastName;
        this.age = age;
        Gender = gender;
        Email = email;
        this.phoneNumber = phoneNumber;
        this.origin = origin;
    }

    public int getId() {
        return Id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
