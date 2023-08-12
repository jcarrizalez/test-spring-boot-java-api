package medicalshifts.medicalshifts.controllers;

import medicalshifts.medicalshifts.controllers.base.BaseControllerImpl;
import medicalshifts.medicalshifts.entities.Person;
import medicalshifts.medicalshifts.services.people.PersonServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/persons")
public class PersonController extends BaseControllerImpl<Person, PersonServiceImpl>
{
}
