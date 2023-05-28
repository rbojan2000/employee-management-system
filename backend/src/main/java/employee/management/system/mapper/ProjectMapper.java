package employee.management.system.mapper;

import employee.management.system.dto.EngineerProjectAssignmentDTO;
import employee.management.system.model.EngineerProjectAssignment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProjectMapper {

    public EngineerProjectAssignment toModel() {
        return null;
    }

    public EngineerProjectAssignmentDTO toDTO(EngineerProjectAssignment engineerProjectAssignment) {
        EngineerProjectAssignmentDTO dto = new EngineerProjectAssignmentDTO();

        dto.setProjectName(engineerProjectAssignment.getProject().getName());
        dto.setProjectDuration(String.valueOf(engineerProjectAssignment.getProject().getDuration()));
        dto.setDescription(engineerProjectAssignment.getDescription());
        dto.setUserID(engineerProjectAssignment.getSoftwareEngineer().getId());
        return dto;
    }

    public List<EngineerProjectAssignmentDTO> listToDTO(List<EngineerProjectAssignment> engineerProjectAssignments) {
        List<EngineerProjectAssignmentDTO> engineerProjectAssignmentDTOS = new ArrayList<>();

        for(EngineerProjectAssignment engineerProjectAssignment: engineerProjectAssignments) {
            engineerProjectAssignmentDTOS.add(toDTO(engineerProjectAssignment));
        }

        return engineerProjectAssignmentDTOS;
    }

}
