package employee.management.system.controller;


import employee.management.system.model.User;
import employee.management.system.model.dto.UserDTO;
import employee.management.system.service.interfaces.AdministratorService;
import employee.management.system.service.interfaces.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.UnsupportedEncodingException;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private AdministratorService administratorService;

    @GetMapping("getAll")
    public List<User> getUsers() {
        return userService.getAll();
    }


}
