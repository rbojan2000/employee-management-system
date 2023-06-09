package employee.management.system.service.implementations;

import employee.management.system.model.Role;
import employee.management.system.repository.RoleRepository;
import employee.management.system.service.interfaces.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findById(Long id) {
        Role auth = this.roleRepository.getOne(id);
        return auth;
    }

    @Override
    public Role findByName(String name) {
        List<Role> roles = this.roleRepository.findByName(name);
        return roles.get(0);
    }
}
