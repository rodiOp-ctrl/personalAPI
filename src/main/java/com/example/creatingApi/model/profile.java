package com.example.creatingApi.model;
import java.util.List;

public record profile(
        String name,
        String oneLiner,
        String bio,
        List<String> skills,
        List<dailyTask> routine
) { }
