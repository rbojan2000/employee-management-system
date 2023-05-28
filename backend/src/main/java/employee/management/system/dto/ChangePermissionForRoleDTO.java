package employee.management.system.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChangePermissionForRoleDTO {

    @NotEmpty
    @NotNull
    private String roleName;

    @NotEmpty
    @NotNull
    private String permisionId;
}
