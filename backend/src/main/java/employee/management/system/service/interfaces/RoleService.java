package employee.management.system.service.interfaces;

import employee.management.system.model.Role;

import java.util.List;

public interface RoleService {
    Role findById(Long id);
    List<Role> findByName(String name);
}
