package employee.management.system.controller;

import employee.management.system.dto.EngineerProjectAssignmentDTO;
import employee.management.system.mapper.ProjectMapper;
import employee.management.system.model.EngineerProjectAssignment;
import employee.management.system.model.EngineerProjectAssignmentId;
import employee.management.system.repository.EngineerProjectAssignmentRepository;
import employee.management.system.service.interfaces.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private  ProjectMapper projectMapper;

    @Autowired
    private EngineerProjectAssignmentRepository engineerProjectAssignmentRepository;

    @GetMapping("/user/{id}")
    @PreAuthorize("hasRole('SOFTWARE_ENGINEER')")
    public ResponseEntity<List<EngineerProjectAssignmentDTO>> getProjectForUser(@PathVariable("id") Long id) {

        List<EngineerProjectAssignment> assignmentList = projectService.getProjectForUser(id);
        List<EngineerProjectAssignmentDTO> dtos = projectMapper.listToDTO(assignmentList);

        return ResponseEntity.ok(dtos);
    }

    @PutMapping
    @PreAuthorize("hasRole('SOFTWARE_ENGINEER')")
    public ResponseEntity<?> updateProjectDescriptionForUser(@RequestBody EngineerProjectAssignmentDTO engineerProjectAssignmentDTO) {

        projectService.UpdateUserDescription(engineerProjectAssignmentDTO.getProjectName(), engineerProjectAssignmentDTO.getDescription());
        engineerProjectAssignmentRepository.findById(new EngineerProjectAssignmentId());
        return ResponseEntity.ok("");
    }

}
