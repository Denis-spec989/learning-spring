package denisspec.spring.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="role_id")
    private Long roleId;

    private String name;
    @ManyToMany(mappedBy = "roles")
    private List<Userm> userm;
    public List<Userm> getUserm() {
        return userm;
    }

    public void setUserm(List<Userm> userm) {
        this.userm = userm;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
