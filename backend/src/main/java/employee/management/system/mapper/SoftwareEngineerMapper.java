package employee.management.system.mapper;

import employee.management.system.dto.UserDTO;
import employee.management.system.model.Address;
import employee.management.system.model.SoftwareEngineer;
import org.springframework.stereotype.Component;

@Component
public class SoftwareEngineerMapper {

    public SoftwareEngineer toModel(UserDTO userDTO) {
        Address address = new Address();
        address.setCity(userDTO.getAddress().getCity());
        address.setStreet(userDTO.getAddress().getStreet());
        address.setState(userDTO.getAddress().getState());

        SoftwareEngineer se = new SoftwareEngineer();
        se.setName(userDTO.getName());
        se.setSurname(userDTO.getSurname());
        se.setEmail(userDTO.getEmail());
        se.setAddress(address);
        return se;
    }

}
