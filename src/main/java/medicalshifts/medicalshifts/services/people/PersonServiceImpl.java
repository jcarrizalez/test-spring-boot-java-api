package medicalshifts.medicalshifts.services.people;

import jakarta.transaction.Transactional;
import medicalshifts.medicalshifts.entities.Person;
import medicalshifts.medicalshifts.entities.User;
import medicalshifts.medicalshifts.repositories.PersonRepository;
import medicalshifts.medicalshifts.repositories.base.BaseRepository;
import medicalshifts.medicalshifts.repositories.users.UserRepository;
import medicalshifts.medicalshifts.security.Session;
import medicalshifts.medicalshifts.services.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class PersonServiceImpl extends BaseServiceImpl<Person, Long> implements PersonService
{
    @Autowired
    private Session session;
    @Autowired
    private UserRepository userRepository;
    private final CreatorPerson creatorPerson;
    private final UpdaterPerson updaterPerson;
    private final DeletePerson deletePerson;

    public PersonServiceImpl(
            BaseRepository<Person, Long> baseRepository
            , CreatorPerson creatorPerson
            , UpdaterPerson updaterPerson
            , DeletePerson deletePerson
    )
    {
        super(baseRepository);
        this.creatorPerson = creatorPerson;
        this.updaterPerson = updaterPerson;
        this.deletePerson = deletePerson;
    }

    private User getUserSession()
    {
        Optional<User> userOpt = userRepository.findByUsername(session.auth().getName());
        return userOpt.get();
    }

    @Override
    @Transactional
    public Person save(Person person) throws Exception
    {
        return creatorPerson.bySession(person, this.getUserSession());
    }

    @Override
    @Transactional
    public Person update(Long id, Person person) throws Exception
    {
        return updaterPerson.bySession(id, person, this.getUserSession());
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception
    {
        return deletePerson.byAdmin(id, this.getUserSession());
    }
}

