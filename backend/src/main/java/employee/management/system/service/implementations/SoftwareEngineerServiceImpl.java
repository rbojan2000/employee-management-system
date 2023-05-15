package employee.management.system.service.implementations;

import employee.management.system.model.SoftwareEngineer;
import employee.management.system.model.dto.UserDTO;
import employee.management.system.repository.SoftwareEngineerRepository;
import employee.management.system.service.interfaces.SoftwareEngineerService;
import employee.management.system.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SoftwareEngineerServiceImpl implements SoftwareEngineerService {
    @Autowired
    UserService userService;
    @Autowired
    SoftwareEngineerRepository softwareEngineerRepository;
    @Override
    public SoftwareEngineer registerEngineer(UserDTO userDTO) {
        SoftwareEngineer engineer = new SoftwareEngineer();
        engineer = (SoftwareEngineer) userService.registerUser(engineer, userDTO);
        softwareEngineerRepository.save(engineer);
        return engineer;
    }
}
