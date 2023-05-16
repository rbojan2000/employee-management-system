package employee.management.system.service.interfaces;

public interface UserService {

    boolean checkIfEmailExists(String email);

    String getSaltByUserEmail(String email);
}
