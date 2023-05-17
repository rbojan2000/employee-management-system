package employee.management.system.service.interfaces;

import employee.management.system.dto.SkillDTO;
import employee.management.system.model.Skill;

import java.util.List;

public interface SkillService {

    List<Skill> getProjectForUser(Long userID);


    void addNewSkill(Skill skill, Long userId);
}
