package employee.management.system.service.interfaces;

import employee.management.system.model.SoftwareEngineer;
import employee.management.system.model.dto.UserDTO;

public interface SoftwareEngineerService {
    SoftwareEngineer registerEngineer(UserDTO userDTO);
}