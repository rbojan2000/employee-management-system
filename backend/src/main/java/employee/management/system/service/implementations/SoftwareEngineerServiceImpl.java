package employee.management.system.service.implementations;

import employee.management.system.mapper.SoftwareEngineerMapper;
import employee.management.system.model.SoftwareEngineer;
import employee.management.system.dto.UserDTO;
import employee.management.system.repository.SoftwareEngineerRepository;
import employee.management.system.service.interfaces.RoleService;
import employee.management.system.service.interfaces.SoftwareEngineerService;
import employee.management.system.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
    private PasswordEncoder passwordEncoder;

    @Override
    public SoftwareEngineer registerEngineer(UserDTO userDTO) {

        if(userService.checkIfEmailExists(userDTO.getEmail()))
            return null;

        SoftwareEngineer engineer = softwareEngineerMapper.toModel(userDTO);
        engineer.setPassword(passwordEncoder.encode(userDTO.getPassword()));

        engineer.setEnabled(true);
        engineer.setApproved(true);

        engineer.setRoles(roleService.findByName("ROLE_SOFTWARE_ENGINEER"));
        softwareEngineerRepository.save(engineer);
        return engineer;

    }

    @Override
    public SoftwareEngineer getByID(Long id) {
        return softwareEngineerRepository.findById(id).get();
    }

    @Override
    public void updateEngineer(SoftwareEngineer softwareEngineer, Long id) {

        SoftwareEngineer engineer = softwareEngineerRepository.findById(id).get();

        engineer.setAddress(softwareEngineer.getAddress());
        engineer.setName(softwareEngineer.getName());
        engineer.setSurname(softwareEngineer.getSurname());

        softwareEngineerRepository.save(engineer);
    }
}
