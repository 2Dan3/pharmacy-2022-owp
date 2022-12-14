package rs.ac.uns.ftn.dan.pharmacy.model;

import rs.ac.uns.ftn.dan.pharmacy.model.enums.Role;

import java.util.Date;

public class CreateUserDTO {
//    private Long id;
    private String username;
    private String password;
    private String email;
    private String name;
    private String surname;
    private String birth;
    private String address;
    private String phoneNum;

    public CreateUserDTO(){}

//    public CreateUserDTO(Long id, String username, String password, String email, String name, String surname, Date birth, String address, String phoneNum){
//        this.id = id;
//        this.username = username;
//        this.password = password;
//        this.email = email;
//        this.name = name;
//        this.surname = surname;
//        this.birth = birth;
//        this.address = address;
//        this.phoneNum = phoneNum;
//    }

    public CreateUserDTO(String username, String password, String email, String name, String surname, String birth, String address, String phoneNum){
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.birth = birth;
        this.address = address;
        this.phoneNum = phoneNum;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
