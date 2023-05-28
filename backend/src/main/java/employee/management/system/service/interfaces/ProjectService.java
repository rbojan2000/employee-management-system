package employee.management.system.service.interfaces;

import employee.management.system.model.EngineerProjectAssignment;

import java.util.List;

public interface ProjectService {

    List<EngineerProjectAssignment> getProjectForUser(Long userID);

    void UpdateUserDescription(String projectName, String description);
}
