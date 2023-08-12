package medicalshifts.medicalshifts.repositories;

import medicalshifts.medicalshifts.entities.Specialty;
import medicalshifts.medicalshifts.repositories.base.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpecialtyRepository extends BaseRepository<Specialty, Long>
{
    Optional<Specialty> findByName(String name);
}
