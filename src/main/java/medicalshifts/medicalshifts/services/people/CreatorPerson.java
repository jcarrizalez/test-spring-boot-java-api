package medicalshifts.medicalshifts.services.people;

import medicalshifts.medicalshifts.entities.Person;
import medicalshifts.medicalshifts.entities.User;
import medicalshifts.medicalshifts.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CreatorPerson
{
    @Autowired
    private PersonRepository personRepository;

    public Person bySession(Person person, User user) throws Exception
    {
        try{
            Optional<Person> personOpt = personRepository.findByUserId(user.getId());

            if(personOpt.isPresent()){
                throw new Exception("Ya existe una persona con este usuario");
            }

            person.setUser(user);
            person = personRepository.save(person);
            //user.setPassword("******");
            return person;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
