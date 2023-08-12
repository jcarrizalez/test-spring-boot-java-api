package medicalshifts.medicalshifts.commands;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import medicalshifts.medicalshifts.entities.Rol;
import medicalshifts.medicalshifts.entities.User;
import medicalshifts.medicalshifts.enums.RolName;
import medicalshifts.medicalshifts.repositories.users.RolRepository;
import medicalshifts.medicalshifts.repositories.users.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Component
public class Runner implements CommandLineRunner
{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RolRepository rolRepository;

    @Override
    public void run(String... args) throws Exception
    {
        if(this.rolRepository.count() ==  0){
            this.rolRepository.saveAll(List.of(
                    new Rol(RolName.ADMIN),
                    new Rol(RolName.READ),
                    new Rol(RolName.WRITE)
            ));
            System.out.println("Roles Creados");
        }
        if(this.userRepository.count() ==  0){

            var admin = this.rolRepository.findByName(RolName.ADMIN).get();
            var read = this.rolRepository.findByName(RolName.READ).get();
            var write = this.rolRepository.findByName(RolName.WRITE).get();


            var password = new BCryptPasswordEncoder().encode("123");

            this.userRepository.saveAll(List.of(
                    new User("admin", password, List.of(admin)),
                    new User("user01", password, List.of(read)),
                    new User("user02", password, List.of(write))
            ));

            System.out.println("Usuarios Creados");
        }
    }

}
