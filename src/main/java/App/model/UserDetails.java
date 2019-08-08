package App.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_details")
public class UserDetails implements Serializable {
    private static final long serialVersionUID = 666;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user_detail")
    private Long id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    private String address;

    @OneToOne(mappedBy = "userDetails")
    private User user;

    UserDetails() {}

    public UserDetails(String firstName, String lastName, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "UserDetails{" +
               "id=" + id +
               ", firstName='" + firstName + '\'' +
               ", lastName='" + lastName + '\'' +
               ", address='" + address + '\'' +
               '}';
    }
}
