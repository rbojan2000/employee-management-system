package employee.management.system.service.interfaces;

import employee.management.system.model.ProjectManager;
import employee.management.system.model.dto.UserDTO;

public interface ProjectManagerService {
    ProjectManager registerProjectManager(UserDTO userDTO);
}
