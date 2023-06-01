package employee.management.system.service.interfaces;

import employee.management.system.model.Permission;

import java.util.List;

public interface PermissionService {
    List<Permission> getAll();

    boolean chagePermisionForRole(String permisionId, String roleName);

    boolean checkIfUserHasPermission(String permissionName) throws Exception;
}

