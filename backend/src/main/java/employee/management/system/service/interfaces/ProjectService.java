package employee.management.system.service.interfaces;

import employee.management.system.model.EngineerProjectAssignment;

import java.util.List;

public interface ProjectService {

    List<EngineerProjectAssignment> getProjectForUser(Long userID) throws Exception;

    void updateUserDescription(String projectName, String description) throws Exception;
}
