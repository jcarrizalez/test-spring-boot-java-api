package medicalshifts.medicalshifts.entities;

import jakarta.persistence.*;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "people")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//@Where(clause="deleted=1")
public class Person extends Base
{
    @NotEmpty(message = "El nombre de la persona requerido")
    @Size(min = 2, max = 100, message = "La longitud del nombre completo debe tener entre 2 y 100 caracteres")
    private String name;
    @NotEmpty(message = "El apellido de la persona requerido")
    @Size(min = 2, max = 100, message = "La longitud del apellido completo debe tener entre 2 y 100 caracteres")
    @Column(name ="last_name")
    private String last_name;
    private int dni;
    @Email(message = "El email es invalido.", flags = { Pattern.Flag.CASE_INSENSITIVE })
    private String email;
    private Number phone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", unique = true, nullable = false)
    private User user;

    private boolean deleted = Boolean.FALSE;

    @OneToMany(cascade = CascadeType.REFRESH, orphanRemoval = true)
    @JoinTable(
            name = "person_doctors",
            joinColumns = @JoinColumn(name = "persona_id"),
            inverseJoinColumns = @JoinColumn(name = "specialty_id")
    )
    private List<Specialty> specialties = new ArrayList<Specialty>();


    public String toString()
    {
        return  "Person [name: " + name  + ", last_name: " + last_name + ", dni: " + dni + ", email: " + email + ", phone: " + phone + "]";
    }
}
