package employee.management.system.service.implementations;

import employee.management.system.model.ProjectManager;
import employee.management.system.dto.UserDTO;
import employee.management.system.repository.ProjectManagerRepository;
import employee.management.system.service.interfaces.ProjectManagerService;
import employee.management.system.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectManagerServiceImpl implements ProjectManagerService {
    @Autowired
    UserService userService;
    @Autowired
    ProjectManagerRepository projectManagerRepository;
}
