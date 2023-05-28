package employee.management.system.service.interfaces;

import employee.management.system.model.Permission;

import java.util.List;

public interface PermisionService {
    List<Permission> getAll();

    boolean chagePermisionForRole(String permisionId, String roleName);
}

