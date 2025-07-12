package com.example.demo.service;

import com.example.demo.model.Skill;
import com.example.demo.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {

    @Autowired
    private SkillRepository skillRepository;

    // Save a skill
    public Skill saveSkill(Skill skill) {
        return skillRepository.save(skill);
    }

    // Get all skills
    public List<Skill> getAllSkills() {
        return skillRepository.findAll();
    }

    // Get skills by name and type (custom query)
    public List<Skill> getSkillsByNameAndType(String skillName, String skillType) {
        return skillRepository.findBySkillNameAndSkillType(skillName, skillType);
    }
}

