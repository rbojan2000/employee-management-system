package employee.management.system.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EngineerProjectAssignment {

    @EmbeddedId
    private EngineerProjectAssignmentId id;

    @ManyToOne
    @MapsId("softwareEngineerId")
    private SoftwareEngineer softwareEngineer;

    @ManyToOne
    @MapsId("projectId")
    private Project project;

    @Column
    private String description;

}
