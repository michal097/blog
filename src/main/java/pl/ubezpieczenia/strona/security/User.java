package pl.ubezpieczenia.strona.security;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "credentials")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotEmpty(message = "{pl.mikel.security.model.User.firstName.NotEmpty}")
    @Column(name = "firstName")
    private String firstName;

    @NotEmpty(message = "{pl.mikel.security.model.User.lastName.NotEmpty}")
    @Column(name = "lastName")
    private String lastName;

    @NotEmpty(message = "{pl.mikel.security.model.User.email.NotEmpty}")
    @Email(message = "{pl.mikel.security.model.User.email.Email }")
    @Column(name = "email", unique = true)
    private String email;

    @NotEmpty(message = "{pl.mikel.security.model.User.password.NotEmpty}")
    @Column(name = "password")
    private String password;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @Column(name = "roles")
    private Set<UserRole> roles = new HashSet<>();


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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Set<UserRole> getRoles() {
        return roles;
    }


    public void setRoles(Set<UserRole> roles) {
        this.roles = roles;
    }
    @Override
    public String toString() {
        return "User [id=" + id
                + ", firstName=" + firstName
                + ", lastName=" + lastName
                + ", email=" + email
                + ", password=" + password
                + ", roles=" + roles + "]";
    }
}