package employee.management.system.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class EngineerProjectAssignmentId implements Serializable {

    @Column(name = "software_engineer_id")
    private Long softwareEngineerId;

    @Column(name = "project_id")
    private Long projectId;

}