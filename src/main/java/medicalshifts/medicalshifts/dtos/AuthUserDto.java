package medicalshifts.medicalshifts.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Base64;

@Getter
@Setter
public class AuthUserDto {
    private String username;
    private String password;
    /*
    public AuthUserDto generateToken()
    {
        String encoding = Base64.getEncoder().encodeToString((this.username + ":" + this.password).getBytes());
        this.token = "Basic " + encoding;
        return this;
    }
     */
}
