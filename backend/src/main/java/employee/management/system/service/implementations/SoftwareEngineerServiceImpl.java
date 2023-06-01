package employee.management.system.service.implementations;

import employee.management.system.mapper.SoftwareEngineerMapper;
import employee.management.system.model.Role;
import employee.management.system.model.SoftwareEngineer;
import employee.management.system.dto.UserDTO;
import employee.management.system.repository.SoftwareEngineerRepository;
import employee.management.system.service.interfaces.PermissionService;
import employee.management.system.service.interfaces.RoleService;
import employee.management.system.service.interfaces.SoftwareEngineerService;
import employee.management.system.service.interfaces.UserService;
import employee.management.system.util.SaltGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SoftwareEngineerServiceImpl implements SoftwareEngineerService {

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;
    @Autowired
    SoftwareEngineerRepository softwareEngineerRepository;

    @Autowired
    SoftwareEngineerMapper softwareEngineerMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    PermissionService permissionService;

    @Override
    public SoftwareEngineer registerEngineer(UserDTO userDTO) {

        if(userService.checkIfEmailExists(userDTO.getEmail()))
            return null;

        String salt = SaltGenerator.generateSalt(8);

        SoftwareEngineer engineer = softwareEngineerMapper.toModel(userDTO);
        engineer.setPassword(passwordEncoder.encode(userDTO.getPassword().concat(salt)));

        engineer.setSalt(salt);
        engineer.setEnabled(true);
        engineer.setApproved(true);

        List<Role> roles = new ArrayList<>();
        roles.add(roleService.findByName("ROLE_SOFTWARE_ENGINEER"));
        engineer.setRoles(roles);
        softwareEngineerRepository.save(engineer);
        return engineer;
    }

    @Override
    public SoftwareEngineer getByID(Long id) throws Exception {
        permissionService.checkIfUserHasPermission("getProfileDetails");
        return softwareEngineerRepository.findById(id).get();
    }

    @Override
    public void updateEngineer(SoftwareEngineer softwareEngineer, Long id) throws Exception {
        permissionService.checkIfUserHasPermission("updateProfileDetails");

        SoftwareEngineer engineer = softwareEngineerRepository.findById(id).get();

        engineer.setAddress(softwareEngineer.getAddress());
        engineer.setName(softwareEngineer.getName());
        engineer.setSurname(softwareEngineer.getSurname());

        softwareEngineerRepository.save(engineer);
    }
}
