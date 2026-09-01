package com.example.creatingApi.model;
import java.util.List;

public record Profile(
        String name,
        String oneLiner,
        String bio,
        List<String> skills,
        List<DailyTask> routine
) { }
