package uz.akfa.firstjavafxapp.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;

public class Student {

    public Student(String firstName, String password) {
        this.firstName = firstName;
        this.password = password;
    }

//    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public Student(Long id,String fName, String lName, Role role, String password){
        this.id = id;
        firstName = fName;
        lastName = lName;
        this.role = role;
        this.password = password;
    }

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public Student(
                   @JsonProperty("firstName") String firstName,
                   @JsonProperty("lastName") String lastName,
                   @JsonProperty("password") String password,
                   @JsonProperty("id") Long id){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(String code) {
        this.role = Role.decode(code);
    }
    public void setRole(Role role){
        this.role = role;
    }

    public Long id;

    public String firstName;

    public String lastName;

    public Role role;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    private Status status = Status.ACTIVE;

    @Override
    public boolean equals(Object o){
        if(o instanceof Student that){
            return getFirstName().equals(that.getFirstName()) && getPassword().equals(that.getPassword());
        }
        return false;
    }

    @Override
    public int hashCode(){
        return Objects.hash(firstName, password);
    }

    @Override
    public String toString(){
        return firstName + " " + lastName + " " + id;
    }

    public String getFullDetails(){
        return id + " " + firstName + " " + lastName + " " + getRole();
    }
}
