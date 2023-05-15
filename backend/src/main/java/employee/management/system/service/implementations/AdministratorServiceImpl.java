package employee.management.system.service.implementations;

import employee.management.system.model.Administrator;
import employee.management.system.model.dto.UserDTO;
import employee.management.system.repository.AdministratorRepostiory;
import employee.management.system.service.interfaces.AdministratorService;
import employee.management.system.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministratorServiceImpl implements AdministratorService {
    @Autowired
    UserService userService;
    @Autowired
    AdministratorRepostiory administratorRepostiory;
    @Override
    public Administrator registerAdministrator(UserDTO userDTO) {
        Administrator administrator = new Administrator();
        administrator = (Administrator) userService.registerUser(administrator, userDTO);
        administrator.setEnabled(true);
        administrator.setApproved(true);
        administratorRepostiory.save(administrator);
        return administrator;
    }
}
