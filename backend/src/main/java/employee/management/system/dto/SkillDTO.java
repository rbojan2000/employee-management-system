package employee.management.system.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class SkillDTO {
    private Long userId;
    private String name;
    private int grade;

}
