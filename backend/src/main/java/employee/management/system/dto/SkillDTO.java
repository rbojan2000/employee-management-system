package employee.management.system.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class SkillDTO {
    @NotEmpty
    private Long userId;
    @Pattern(regexp = "^[a-zA-Z]+$")
    private String name;
    @Pattern(regexp = "^[a-zA-Z]+$")
    private int grade;

}
