package employee.management.system.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtAuthenticationRequest {

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;
}
