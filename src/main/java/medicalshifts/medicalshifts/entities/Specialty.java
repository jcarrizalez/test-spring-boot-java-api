package medicalshifts.medicalshifts.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "specialties"
 //       , uniqueConstraints = { @UniqueConstraint(columnNames = { "person_id", "specialty" }) }
)
public class Specialty extends Base
{
    @Column(name = "name", unique = true)
    private String name;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Date created_at;

    public Specialty(String name)
    {
        this.name = name;
    }
}
