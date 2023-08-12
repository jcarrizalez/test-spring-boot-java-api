package medicalshifts.medicalshifts.services.people;

import medicalshifts.medicalshifts.entities.Person;
import medicalshifts.medicalshifts.entities.Specialty;
import medicalshifts.medicalshifts.entities.User;
import medicalshifts.medicalshifts.repositories.PersonRepository;
import medicalshifts.medicalshifts.repositories.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UpdaterPerson
{
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private SpecialtyRepository specialtyRepository;

    public Person bySession(Long id, Person person, User user) throws Exception
    {
        try{
            Optional<Person> personOpt = personRepository.findById(id);

            Person entityUpdate = personOpt.get();

            User userEntity = entityUpdate.getUser();

            List<Specialty> specialties = new ArrayList<>();

            for (Specialty item : person.getSpecialties()){

                Optional<Specialty> specialtyOpt = specialtyRepository.findByName(item.getName());

                specialties.add(specialtyOpt.isPresent()
                        ? specialtyOpt.get()
                        : specialtyRepository.save( new Specialty(item.getName()))
                );
            }
            person.setSpecialties(specialties);

            if(!userEntity.getUsername().equals(user.getUsername())){
                throw new Exception("No tienes permiso de esta accion");
            }
            person.setId(id);
            person.setUser(userEntity);
            entityUpdate = personRepository.save(person);

            return entityUpdate;

        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
