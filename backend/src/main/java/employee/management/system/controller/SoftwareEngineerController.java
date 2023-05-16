package employee.management.system.controller;

import employee.management.system.dto.UserDTO;
import employee.management.system.mapper.SoftwareEngineerMapper;
import employee.management.system.model.SoftwareEngineer;
import employee.management.system.service.interfaces.SoftwareEngineerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/software-engineer")
@CrossOrigin(origins = "http://localhost:4200")
public class SoftwareEngineerController {

    @Autowired
    SoftwareEngineerService softwareEngineerService;

    @Autowired
    SoftwareEngineerMapper softwareEngineerMapper;

    @Autowired
    private AuthenticationManager authenticationManager;


    @GetMapping("/{id}")
    @PreAuthorize("hasRole('SOFTWARE_ENGINEER')")
    public ResponseEntity<UserDTO> getByID(@PathVariable("id") Long id) {

        SoftwareEngineer softwareEngineer = softwareEngineerService.getByID(id);

        return ResponseEntity.ok(softwareEngineerMapper.toDTO(softwareEngineer));
    }

    @PutMapping
    @PreAuthorize("hasRole('SOFTWARE_ENGINEER')")
    public ResponseEntity<?> update(@RequestBody UserDTO userDTO) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                softwareEngineerService.getByID(userDTO.getId()).getUsername(), userDTO.getPassword()));

        SoftwareEngineer softwareEngineer = softwareEngineerMapper.toModel(userDTO);
        softwareEngineerService.updateEngineer(softwareEngineer, userDTO.getId());
        return ResponseEntity.ok().build();
    }
}
