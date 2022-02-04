package denisspec.spring.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Userm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long userId;

    private String username ;

    private String password ;

    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="d_created")
    private Date d_created;
    @Column(name="is_active")
    private boolean isActive;

    @OneToMany(mappedBy = "userm")
    private List<Role> roles;

    @OneToOne(mappedBy = "userm")
    private Comment comment;

    @OneToMany(mappedBy = "usermp")
    private List<Post> posts;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public Date getD_created() {
        return d_created;
    }

    public void setD_created(Date d_created) {
        this.d_created = d_created;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
