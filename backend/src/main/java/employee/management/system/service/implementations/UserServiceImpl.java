package employee.management.system.service.implementations;

import employee.management.system.model.User;
import employee.management.system.dto.UserDTO;
import employee.management.system.repository.UserRepository;
import employee.management.system.service.interfaces.RoleService;
import employee.management.system.service.interfaces.UserService;
import org.apache.commons.codec.binary.Hex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public boolean checkIfEmailExists(String email) {
        if(userRepository.findByEmail(email) == null)
            return false;
        return true;
    }


    private String generateSalt() {
        // Generate a random salt using a secure random number generator
        SecureRandom random = new SecureRandom();
        byte[] saltBytes = new byte[16];
        random.nextBytes(saltBytes);

        // Convert the salt bytes to a hexadecimal string representation
        return Hex.encodeHexString(saltBytes);
    }
}
