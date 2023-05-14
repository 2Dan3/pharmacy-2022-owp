package rs.ac.uns.ftn.dan.pharmacy.model.dto;


import java.sql.Date;

public class CreateUserDTO {
//    private Long id;
    private String jmbg;
    private String password;
    private String email;
    private String name;
    private String surname;
    private Date birthDate;
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

    public CreateUserDTO(String jmbg, String password, String email, String name, String surname, Date birthDate, String address, String phoneNum){
        this.jmbg = jmbg;
        this.password = password;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.address = address;
        this.phoneNum = phoneNum;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
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

    public Date getBirth() {
        return birthDate;
    }

    public void setBirth(String birth) {
        this.birthDate = birthDate;
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
