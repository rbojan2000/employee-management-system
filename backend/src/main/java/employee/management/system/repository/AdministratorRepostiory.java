package employee.management.system.repository;

import employee.management.system.model.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorRepostiory extends JpaRepository<Administrator, Long> {
}
