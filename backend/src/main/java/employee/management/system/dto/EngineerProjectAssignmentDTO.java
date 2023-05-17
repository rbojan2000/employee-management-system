package employee.management.system.dto;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EngineerProjectAssignmentDTO {

    private Long Id;
    private String projectName;
    private String projectDuration;
    private Long userID;
    private String description;
}
