package employee.management.system.controller;

import employee.management.system.dto.UserDTO;
import employee.management.system.mapper.SoftwareEngineerMapper;
import employee.management.system.model.SoftwareEngineer;
import employee.management.system.service.interfaces.SoftwareEngineerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/software-engineer", produces = MediaType.APPLICATION_JSON_VALUE)
public class SoftwareEngineerController {

    @Autowired
    SoftwareEngineerService softwareEngineerService;

    @Autowired
    SoftwareEngineerMapper softwareEngineerMapper;

    @Autowired
    AuthenticationManager authenticationManager;


    @GetMapping("/{id}")
    @PreAuthorize("hasRole('SOFTWARE_ENGINEER')")
    public ResponseEntity<?> softwareEngineerProfileDetails(@PathVariable("id") Long id) {
        try {
            SoftwareEngineer softwareEngineer = softwareEngineerService.getByID(id);
            return ResponseEntity.ok(softwareEngineerMapper.toDTO(softwareEngineer));
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        }
    }

    @PutMapping
    @PreAuthorize("hasRole('SOFTWARE_ENGINEER')")
    public ResponseEntity<?> update(@RequestBody UserDTO userDTO) throws Exception {
        SoftwareEngineer softwareEngineer  = softwareEngineerService.getByID(userDTO.getId());
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                softwareEngineer.getUsername(), userDTO.getPassword().concat(softwareEngineer.getSalt())));
        try {
            softwareEngineer = softwareEngineerMapper.toModel(userDTO);
            softwareEngineerService.updateEngineer(softwareEngineer, userDTO.getId());
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        }
    }
}
