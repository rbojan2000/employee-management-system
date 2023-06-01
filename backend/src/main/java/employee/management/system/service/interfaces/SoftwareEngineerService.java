package employee.management.system.service.interfaces;

import employee.management.system.model.SoftwareEngineer;
import employee.management.system.dto.UserDTO;

public interface SoftwareEngineerService {
    SoftwareEngineer registerEngineer(UserDTO userDTO);

    SoftwareEngineer getByID(Long id) throws Exception;

    void updateEngineer(SoftwareEngineer softwareEngineer, Long id) throws Exception;
}
