package medicalshifts.medicalshifts.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.net.Authenticator;

@Component
public class ConditionEvaluator {
    public boolean canPreAuth(String param, Authentication authentication){
        var auth = SecurityContextHolder.getContext().getAuthentication();
        return param.equals(
                authentication.getName())
                && authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ADMIN")
        );
    }
}
