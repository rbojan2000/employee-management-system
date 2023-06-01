package employee.management.system.controller;

import employee.management.system.dto.SkillDTO;
import employee.management.system.model.Skill;
import employee.management.system.service.interfaces.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skill")
public class SkillController {

    @Autowired
    SkillService skillService;

    @GetMapping("/user/{id}")
    @PreAuthorize("hasRole('SOFTWARE_ENGINEER')")
    public ResponseEntity<?> getProjectForUser(@PathVariable("id") Long id) throws Exception {
        try {
            List<Skill> skills = skillService.getSkillsForUser(id);
            return ResponseEntity.ok(skills);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        }
    }

    @PostMapping
    @PreAuthorize("hasRole('SOFTWARE_ENGINEER')")
    public ResponseEntity<?> create(@RequestBody SkillDTO skillDTO) throws Exception {
        try {
            Skill skill = new Skill();
            skill.setGrade(skillDTO.getGrade());
            skill.setName(skillDTO.getName());
            skillService.addNewSkill(skill, skillDTO.getUserId());
            return ResponseEntity.ok(true);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(e.getMessage());
        }
    }
}