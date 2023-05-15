package employee.management.system.service.implementations;

import employee.management.system.model.ProjectManager;
import employee.management.system.model.dto.UserDTO;
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
    @Override
    public ProjectManager registerProjectManager(UserDTO userDTO) {
        ProjectManager manager = new ProjectManager();
        manager = (ProjectManager) userService.registerUser(manager, userDTO);
        projectManagerRepository.save(manager);
        return manager;
    }
}
