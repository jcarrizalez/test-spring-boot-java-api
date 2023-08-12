package medicalshifts.medicalshifts.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "users")
//@SQLDelete(sql = "UPDATE users SET deleted = true WHERE id=?")
public class User implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "El nombre de usuario requerido")
    @Size(min = 3, max = 20, message = "La longitud del nombre de usuario debe tener entre 3 y 20 caracteres")
    @Column(name = "username", unique = true)
    private String username;
    @NotEmpty(message = "La contraseña es requerida")
    @Size(min = 3, max = 100, message = "La longitud de la contraseña debe tener entre 3 y 50 caracteres")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
        joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private List<Rol> roles;

    private boolean deleted = Boolean.FALSE;

    public User(String username, String password, List<Rol> roles)
    {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public User()
    {
        super();
    }
}
