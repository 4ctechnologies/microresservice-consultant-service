package be.foreseegroup.micro.resourceservice.consultant.model;

import org.springframework.data.annotation.Id;

/**
 * Created by Kaj on 24/09/15.
 */
public class Consultant {
    @Id
    private String id;

    private String firstname;

    private String lastname;

    private String address;

    public Consultant() {

    }
    public Consultant(String id, String firstname, String lastname, String address) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
