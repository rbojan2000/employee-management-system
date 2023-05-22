package employee.management.system.controller;

import employee.management.system.dto.SkillDTO;
import employee.management.system.model.Skill;
import employee.management.system.service.interfaces.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skill")
public class SkillController {

    @Autowired
    private SkillService skillService;

    @GetMapping("/user/{id}")
    @PreAuthorize("hasRole('SOFTWARE_ENGINEER')")
    public ResponseEntity<List<Skill>> getByID(@PathVariable("id") Long id) {
        List<Skill> skills = skillService.getProjectForUser(id);

        return ResponseEntity.ok(skills);
    }

    @PostMapping
    @PreAuthorize("hasRole('SOFTWARE_ENGINEER')")
    public ResponseEntity<?> create(@RequestBody SkillDTO skillDTO) {

        Skill skill = new Skill();
        skill.setGrade(skillDTO.getGrade());
        skill.setName(skillDTO.getName());

        skillService.addNewSkill(skill, skillDTO.getUserId());


        return ResponseEntity.ok("skills");
    }

}
