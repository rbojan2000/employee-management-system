package employee.management.system.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EngineerProjectAssignmentDTO {

    @NotEmpty
    private Long Id;

    @Pattern(regexp = "^[a-zA-Z]+$")
    private String projectName;

    @Pattern(regexp = "^[a-zA-Z]+$")
    private String projectDuration;

    @NotEmpty
    private Long userID;

    @Pattern(regexp = "^[a-zA-Z]+$")
    private String description;
}
