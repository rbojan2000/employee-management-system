package employee.management.system.service.interfaces;

import employee.management.system.exception.PermissionException;
import employee.management.system.model.Skill;

import java.util.List;

public interface SkillService {

    List<Skill> getSkillsForUser(Long userID) throws PermissionException;


    void addNewSkill(Skill skill, Long userId) throws PermissionException;
}
