package medicalshifts.medicalshifts.repositories.users;

import medicalshifts.medicalshifts.entities.Rol;
import medicalshifts.medicalshifts.enums.RolName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RolRepository extends JpaRepository<Rol, Long>
{
        Optional<Rol> findByName(RolName name);
}
