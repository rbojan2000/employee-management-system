package employee.management.system.service.interfaces;

import employee.management.system.exception.PermissionException;
import employee.management.system.model.EngineerProjectAssignment;

import java.util.List;

public interface ProjectService {

    List<EngineerProjectAssignment> getProjectForUser(Long userID) throws PermissionException;

    void updateUserDescription(String projectName, String description) throws PermissionException;
}
