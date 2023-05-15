package employee.management.system.service.interfaces;

import employee.management.system.model.User;
import employee.management.system.model.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User findByEmail(String email);
    User registerUser(User user, UserDTO userDTO);

}
