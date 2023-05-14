package rs.ac.uns.ftn.dan.pharmacy.model.entity;

import rs.ac.uns.ftn.dan.pharmacy.model.dto.CreateUserDTO;
import rs.ac.uns.ftn.dan.pharmacy.model.enums.Role;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class User {
    private Long id;
    private String jmbg;
    private String password;
    private String email;
    private String name;
    private String surname;
    private Date dateOfBirth;
    private String address;
    private String phoneNum;
    private Timestamp registrationTimestamp;
    private Role role;

    private static final SimpleDateFormat dateFormatDefault = new SimpleDateFormat("MM-dd-yyyy HH:mm");

    public User(){}

    public User(CreateUserDTO userDTO){
        this.jmbg = userDTO.getJmbg();
        this.password = userDTO.getPassword();
        this.email = userDTO.getEmail();
        this.name = userDTO.getName();
        this.surname = userDTO.getSurname();
        this.dateOfBirth = userDTO.getBirth();
        this.address = userDTO.getAddress();
        this.phoneNum = userDTO.getPhoneNum();
        this.role = Role.PATIENT;
    }
    public User(Long id, String jmbg, String password, String email, String name, String surname, Date dateOfBirth, String address, String phoneNum, Timestamp registrationTimestamp, Role role){
        this.id = id;
        this.jmbg = jmbg;
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
    public User(String jmbg, String password, String email, String name, String surname, Date dateOfBirth, String address, String phoneNum){
        this.jmbg = jmbg;
        this.password = password;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.phoneNum = phoneNum;
        this.registrationTimestamp = new Timestamp(System.currentTimeMillis());
        this.role = Role.PATIENT;
    }

//    TODO * check Date Formatting *
//    public User(CreateUserDTO u) throws ParseException {
//            this.name = u.getName();
//            this.surname = u.getSurname();
//        System.out.println("\n\n"+u.getBirth()+"\n"+ new Date() +"\n\n");
//            this.dateOfBirth = new SimpleDateFormat("yyyy-MM-dd").parse(u.getBirth());
//            this.address = u.getAddress();
//            this.phoneNum = u.getPhoneNum();
//
//            this.registrationTimestamp = new Date();
//            this.role = Role.PATIENT;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJmbg() { return jmbg;
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

    public Timestamp getRegistrationTimestamp() {
        return registrationTimestamp;
    }

    public void setRegistrationTimestamp(Timestamp registrationTimestamp) {
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
                ", jmbg='" + jmbg + '\'' +
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
