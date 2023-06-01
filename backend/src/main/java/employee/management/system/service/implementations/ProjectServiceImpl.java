package employee.management.system.service.implementations;

import employee.management.system.model.EngineerProjectAssignment;
import employee.management.system.repository.EngineerProjectAssignmentRepository;
import employee.management.system.repository.SoftwareEngineerRepository;
import employee.management.system.service.interfaces.PermissionService;
import employee.management.system.service.interfaces.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    PermissionService permissionService;

    @Autowired
    SoftwareEngineerRepository softwareEngineerRepository;

    @Autowired
    EngineerProjectAssignmentRepository engineerProjectAssignmentRepository;

    @Override
    public List<EngineerProjectAssignment> getProjectForUser(Long userID) throws Exception {
        permissionService.checkIfUserHasPermission("findProjectsByUser");
        return softwareEngineerRepository.findById(userID).get().getAssignments();
    }

    @Override
    public void updateUserDescription(String projectName, String description) throws Exception {
        permissionService.checkIfUserHasPermission("updateEngineerProjectAssignmentDescription");

        EngineerProjectAssignment engineerProjectAssignment = engineerProjectAssignmentRepository.findByProject_Name(projectName);
        engineerProjectAssignment.setDescription(description);
        engineerProjectAssignmentRepository.save(engineerProjectAssignment);
    }
}
