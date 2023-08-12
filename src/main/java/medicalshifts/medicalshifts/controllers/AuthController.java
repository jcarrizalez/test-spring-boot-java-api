package medicalshifts.medicalshifts.controllers;

import medicalshifts.medicalshifts.dtos.AuthUserDto;
import medicalshifts.medicalshifts.services.users.CreatorUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1")
public class AuthController
{
    @Autowired
    private CreatorUserService creatorUserService;

    @PostMapping("/register")
    //@PreAuthorize("permitAll()")
    public ResponseEntity<?> register(@RequestBody AuthUserDto userDto)
    {
        return ResponseEntity.status(HttpStatus.OK).body(creatorUserService.create(userDto));
    }
}
