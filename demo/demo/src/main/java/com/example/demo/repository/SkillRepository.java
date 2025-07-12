package com.example.demo.repository;

import com.example.demo.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {
    // Custom method to find skills by name and type
    List<Skill> findBySkillNameAndSkillType(String skillName, String skillType);
}

