package com.example.demo.service;

import com.example.demo.model.Skill;
import com.example.demo.model.User;
import com.example.demo.repository.SkillRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MatchService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SkillRepository skillRepository;

    // Match users based on skill swap logic
    public List<User> findMatchingUsers(Long userId) {
        User currentUser = userRepository.findById(userId).orElse(null);
        if (currentUser == null) return Collections.emptyList();

        List<Skill> wantedSkills = currentUser.getSkills().stream()
                .filter(skill -> skill.getSkillType().equalsIgnoreCase("WANT"))
                .toList();

        Set<String> neededSkillNames = new HashSet<>();
        for (Skill s : wantedSkills) {
            neededSkillNames.add(s.getSkillName());
        }

        // Find users who OFFER the skills the current user WANTS
        List<User> matchedUsers = new ArrayList<>();
        for (String skill : neededSkillNames) {
            List<Skill> offeringSkills = skillRepository.findBySkillNameAndSkillType(skill, "OFFER");
            for (Skill offeringSkill : offeringSkills) {
                User offeringUser = offeringSkill.getUser();

                // Exclude current user from matches
                if (!offeringUser.getId().equals(currentUser.getId())) {
                    matchedUsers.add(offeringUser);
                }
            }
        }

        return matchedUsers;
    }
}

