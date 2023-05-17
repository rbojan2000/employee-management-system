package employee.management.system.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class SoftwareEngineer extends User {

    @OneToMany(mappedBy = "softwareEngineer")
    private List<EngineerProjectAssignment> assignments;

}
