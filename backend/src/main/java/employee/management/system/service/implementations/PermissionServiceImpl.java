package employee.management.system.service.implementations;

import employee.management.system.exception.PermissionException;
import employee.management.system.model.Permission;
import employee.management.system.model.Role;
import employee.management.system.repository.PermissionRepository;
import employee.management.system.service.interfaces.PermissionService;
import employee.management.system.service.interfaces.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    PermissionRepository permissionRepository;

    @Autowired
    RoleService roleService;


    @Override
    public List<Permission> getAll() {
        return permissionRepository.findAll();
    }

    @Override
    public boolean chagePermisionForRole(String permissionId, String roleName) {
        Permission permission = getPermissionById(permissionId);
        Role role = getRoleByName(roleName);
        List<Role> roles = permission.getRoles();

        updateRolesList(permission, role, roles);
        savePermission(permission);

        return true;
    }

    @Override
    public boolean checkIfUserHasPermission(String permissionName) throws PermissionException {
        Permission permission = permissionRepository.findByDescription(permissionName);

        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        boolean hasPermission = checkUserPermission(userDetails, permission);

        if (hasPermission) {
            return true;
        } else {
            PermissionException permissionException = new PermissionException("Logged user does not have permissions for " + permissionName);
            permissionException.setPermissionName(permissionName);
            permissionException.setUser(userDetails.getUsername());
            throw permissionException;
        }
    }

    private boolean checkUserPermission(UserDetails userDetails, Permission permission) {
        Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();

        for (GrantedAuthority authority : authorities) {
            String role = authority.getAuthority();

            if (isRoleInPermission(permission, role)) {
                return true;
            }
        }

        return false;
    }

    private boolean isRoleInPermission(Permission permission, String role) {
        return permission.getRoles().stream().anyMatch(r -> r.getName().equals(role));
    }

    private Permission getPermissionById(String permissionId) {
        Long id = Long.valueOf(permissionId);
        return permissionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Permission not found"));
    }

    private Role getRoleByName(String roleName) {
        Role role = roleService.findByName(roleName);
        if (role == null) {
            throw new IllegalArgumentException("Role not found");
        }
        return role;
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