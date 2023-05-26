package employee.management.system.repository;

import employee.management.system.model.EngineerProjectAssignment;
import employee.management.system.model.EngineerProjectAssignmentId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EngineerProjectAssignmentRepository extends JpaRepository<EngineerProjectAssignment, EngineerProjectAssignmentId> {

    EngineerProjectAssignment findByProject_Name(String projectName);
}
