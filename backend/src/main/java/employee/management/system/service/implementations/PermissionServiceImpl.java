package employee.management.system.service.implementations;

import employee.management.system.model.Permission;
import employee.management.system.model.Role;
import employee.management.system.repository.PermissionRepository;
import employee.management.system.service.interfaces.PermisionService;
import employee.management.system.service.interfaces.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermisionService {

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private RoleService roleService;

    @Override
    public List<Permission> getAll() {
        return permissionRepository.findAll();
    }

    @Override
    public boolean chagePermisionForRole(String permisionId, String roleName) {
        Permission permission = getPermissionById(permisionId);
        Role role = getRoleByName(roleName);
        List<Role> roles = permission.getRoles();

        updateRolesList(permission, role, roles);
        savePermission(permission);

        return true;
    }

    private Permission getPermissionById(String permissionId) {
        Long id = Long.valueOf(permissionId);
        return permissionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Permission not found"));
    }

    private Role getRoleByName(String roleName) {
        List<Role> roles = roleService.findByName(roleName);
        if (roles.isEmpty()) {
            throw new IllegalArgumentException("Role not found");
        }
        return roles.get(0);
    }

    private void updateRolesList(Permission permission, Role role, List<Role> roles) {
        if (roles.contains(role)) {
            roles.remove(role);
        } else {
            roles.add(role);
        }
        permission.setRoles(roles);
    }

    private void savePermission(Permission permission) {
        permissionRepository.save(permission);
    }
}
