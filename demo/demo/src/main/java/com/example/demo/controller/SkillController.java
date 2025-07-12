package com.example.demo.controller;

import com.example.demo.model.Skill;
import com.example.demo.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
public class SkillController {

    @Autowired
    private SkillService skillService;

    // ➕ Add a skill
    @PostMapping
    public Skill createSkill(@RequestBody Skill skill) {
        return skillService.saveSkill(skill);
    }

    // 📋 Get all skills
    @GetMapping
    public List<Skill> getAllSkills() {
        return skillService.getAllSkills();
    }

    // 🔍 Find by skill name and type
    @GetMapping("/search")
    public List<Skill> getSkillsByNameAndType(
            @RequestParam String skillName,
            @RequestParam String skillType) {
        return skillService.getSkillsByNameAndType(skillName, skillType);
    }
}
