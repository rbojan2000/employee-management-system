package employee.management.system.controller;

import employee.management.system.dto.ChangePermissionForRoleDTO;
import employee.management.system.model.Permission;
import employee.management.system.service.interfaces.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permission")
public class PermisionController {

    @Autowired
    private PermissionService permisionService;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<Permission>> updatePermission() {
        return ResponseEntity.ok(permisionService.getAll());
    }

    @PutMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Boolean> chagePermisionForRole(@RequestBody ChangePermissionForRoleDTO dto) {
        permisionService.chagePermisionForRole(dto.getPermisionId(), dto.getRoleName());
        return ResponseEntity.ok(true);
    }
}
