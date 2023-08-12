package medicalshifts.medicalshifts.security;

import lombok.AllArgsConstructor;
import medicalshifts.medicalshifts.entities.Rol;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
public class SecurityAuthority implements GrantedAuthority
{
    private final Rol rol;
    @Override
    public String getAuthority() {
        return rol.getName().toString();
    }
}
