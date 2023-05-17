package employee.management.system.service.implementations;

import employee.management.system.model.EngineerProjectAssignment;
import employee.management.system.repository.EngineerProjectAssignmentRepository;
import employee.management.system.repository.SoftwareEngineerRepository;
import employee.management.system.service.interfaces.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private SoftwareEngineerRepository softwareEngineerRepository;

    @Autowired
    private EngineerProjectAssignmentRepository engineerProjectAssignmentRepository;

    @Override
    public List<EngineerProjectAssignment> getProjectForUser(Long userID) {
        return softwareEngineerRepository.findById(userID).get().getAssignments();
    }

    @Override
    public void UpdateUserDescription(String projectName, String description) {
        EngineerProjectAssignment engineerProjectAssignment = engineerProjectAssignmentRepository.findByProject_Name(projectName);
        engineerProjectAssignment.setDescription(description);
        engineerProjectAssignmentRepository.save(engineerProjectAssignment);
    }
}
