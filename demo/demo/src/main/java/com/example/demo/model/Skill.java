package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String skillName;
    private String skillType;  // OFFER or WANT

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Getters and Setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getSkillName() { return skillName; }

    public void setSkillName(String skillName) { this.skillName = skillName; }

    public String getSkillType() { return skillType; }

    public void setSkillType(String skillType) { this.skillType = skillType; }

    public User getUser() { return user; }

    public void setUser(User user) { this.user = user; }
}

