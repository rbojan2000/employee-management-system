package employee.management.system.service.implementations;

import employee.management.system.model.Skill;
import employee.management.system.model.SoftwareEngineer;
import employee.management.system.repository.SkillRepository;
import employee.management.system.repository.SoftwareEngineerRepository;
import employee.management.system.service.interfaces.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillServiceImpl implements SkillService {

    @Autowired
    SoftwareEngineerRepository softwareEngineerRepository;

    @Autowired
    SkillRepository skillRepository;

    @Override
    public List<Skill> getProjectForUser(Long userID) {

        SoftwareEngineer softwareEngineer = softwareEngineerRepository.findById(userID).get();
        return softwareEngineer.getSkills();
    }

    @Override
    public void addNewSkill(Skill skill, Long userId) {
        SoftwareEngineer softwareEngineer = softwareEngineerRepository.findById(userId).get();
        List<Skill> newSkills = softwareEngineer.getSkills();
        skillRepository.save(skill);
        newSkills.add(skill);
        softwareEngineer.setSkills(newSkills);
        softwareEngineerRepository.save(softwareEngineer);
    }
}
