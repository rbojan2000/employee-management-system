package employee.management.system.service.interfaces;

import employee.management.system.model.Administrator;
import employee.management.system.model.dto.UserDTO;

public interface AdministratorService {
    Administrator registerAdministrator(UserDTO userDTO);
}
