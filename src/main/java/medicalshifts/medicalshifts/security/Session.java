package medicalshifts.medicalshifts.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.net.Authenticator;

@Component
public class Session
{
    public Authentication auth()
    {
        return SecurityContextHolder.getContext().getAuthentication();
    }
}
