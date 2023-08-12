package medicalshifts.medicalshifts.repositories;

import medicalshifts.medicalshifts.entities.Person;
import medicalshifts.medicalshifts.repositories.base.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends BaseRepository<Person, Long>
{
    Optional<Person> findByUserId(Long id);
}
