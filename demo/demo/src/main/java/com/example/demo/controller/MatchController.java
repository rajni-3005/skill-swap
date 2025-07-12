package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/match")
public class MatchController {

    @Autowired
    private MatchService matchService;

    // GET /api/match/{userId}
    @GetMapping("/{userId}")
    public List<User> getMatchesForUser(@PathVariable Long userId) {
        return matchService.findMatchingUsers(userId);
    }
}

