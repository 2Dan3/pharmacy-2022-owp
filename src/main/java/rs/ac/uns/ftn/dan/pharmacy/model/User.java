package rs.ac.uns.ftn.dan.pharmacy.model;

import org.springframework.format.datetime.DateFormatter;
import rs.ac.uns.ftn.dan.pharmacy.model.enums.Role;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User {
    private Long id;
    private String username;
    private String password;
    private String email;
    private String name;
    private String surname;
    private Date dateOfBirth;
    private String address;
    private String phoneNum;
    private Date registrationTimestamp;
    private Role role;

    public User(){}

    public User(Long id, String username, String password, String email, String name, String surname, Date dateOfBirth, String address, String phoneNum, Date registrationTimestamp, Role role){
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phoneNum = phoneNum;
        this.registrationTimestamp = registrationTimestamp;
        this.role = role;
    }

    public User(CreateUserDTO u) throws ParseException {
            this.username = u.getUsername();
            this.password = u.getPassword();
            this.email = u.getEmail();
            this.name = u.getName();
            this.surname = u.getSurname();
        System.out.println("\n\n"+u.getBirth()+"\n"+ new Date() +"\n\n");
            this.dateOfBirth = new SimpleDateFormat("yyyy-MM-dd").parse(u.getBirth());
            this.address = u.getAddress();
            this.phoneNum = u.getPhoneNum();

            this.registrationTimestamp = new Date();
            this.role = Role.CUSTOMER;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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

    public Date getRegistrationTimestamp() {
        return registrationTimestamp;
    }

    public void setRegistrationTimestamp(Date registrationTimestamp) {
        this.registrationTimestamp = registrationTimestamp;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", address='" + address + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                ", registrationTimestamp=" + registrationTimestamp +
                ", role=" + role +
                '}';
    }
}
