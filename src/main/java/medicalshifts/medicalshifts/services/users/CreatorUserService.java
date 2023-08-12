package medicalshifts.medicalshifts.services.users;

import medicalshifts.medicalshifts.dtos.AuthUserDto;
import medicalshifts.medicalshifts.entities.User;
import medicalshifts.medicalshifts.enums.RolName;
import medicalshifts.medicalshifts.repositories.users.RolRepository;
import medicalshifts.medicalshifts.repositories.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class CreatorUserService
{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RolRepository rolRepository;

    public AuthUserDto create(AuthUserDto userDto)
    {
        var read = rolRepository.findByName(RolName.READ).get();
        var password = new BCryptPasswordEncoder().encode(userDto.getPassword());

        User user = new User(userDto.getUsername(), password, List.of(read));

        if (userRepository.findByUsername(userDto.getUsername()).isPresent()){
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Este usuario ya existe !!!");
        }
        userRepository.save(user);
        userDto.setPassword("******");

        return userDto;
    }
}
