package employee.management.system.repository;

import employee.management.system.model.SoftwareEngineer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SoftwareEngineerRepository extends JpaRepository<SoftwareEngineer, Long> {
    Optional<SoftwareEngineer> findById(Long id);

}
