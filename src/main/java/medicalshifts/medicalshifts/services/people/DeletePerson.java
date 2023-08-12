package medicalshifts.medicalshifts.services.people;

import jakarta.transaction.Transactional;
import medicalshifts.medicalshifts.entities.Rol;
import medicalshifts.medicalshifts.entities.Specialty;
import medicalshifts.medicalshifts.entities.User;
import medicalshifts.medicalshifts.enums.RolName;
import medicalshifts.medicalshifts.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeletePerson
{
    @Autowired
    private PersonRepository personRepository;

    public boolean byAdmin(Long id, User user) throws Exception
    {
        boolean isAdmin = false;
        for (Rol rol : user.getRoles()){
            if(rol.getName() == RolName.ADMIN){
                isAdmin = true;
            }
        }
        if(!isAdmin){
            throw new Exception("Usted no es administrador");
        }

        try{
            if (personRepository.existsById(id)) {
                personRepository.deleteById(id);
                return true;
            }
            throw new Exception("No existe este id");
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
