package medicalshifts.medicalshifts.dtos;

import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class PersonBasicDto
{
    private String name;
    private String last_name;
    private int dni;
    private String email;
    private Number phone;

    public PersonBasicDto(String name, String last_name, int dni, String email, Number phone)
    {
        this.name = name;
        this.last_name = last_name;
        this.dni = dni;
        this.email = email;
        this.phone = phone;
    }

    public String toString()
    {
        return  "name: " + name
                + ", last_name: " + last_name
                + ", dni: " + dni
                + ", email: " + email
                + ", phone: " + phone;
    }
}
