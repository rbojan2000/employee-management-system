package employee.management.system.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import employee.management.system.model.AccountType;
import employee.management.system.model.Address;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDTO {
    @Pattern(regexp = "^[a-zA-Z]+$")
    private String name;
    @Pattern(regexp = "^[a-zA-Z]+$")
    private String surname;
    @Email(message = "Email should be valid")
    private String email;
    @Size(min = 8, max = 32, message = "Password must be minimum 8 characters")
    @Pattern.List({
            @Pattern(regexp = "^(?=.*\\d).*$", message = "Password must contain at least one digit"),
            @Pattern(regexp = "^(?=.*[a-z]).*$", message = "Password must contain at least one lowercase letter"),
            @Pattern(regexp = "^(?=.*[A-Z]).*$", message = "Password must contain at least one uppercase letter"),
            @Pattern(regexp = "^(?=.*[!@#$%^&*()_+=]).*$", message = "Password must contain at least one special character")
    })
    private String password;
    private String re_password;
    @JsonProperty
    private Address address;
    @Pattern(regexp = "^(\\+\\s?)?\\d+$")
    private String phone;
    @Pattern(regexp = "^[a-zA-Z]+$")
    private String title;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
}
