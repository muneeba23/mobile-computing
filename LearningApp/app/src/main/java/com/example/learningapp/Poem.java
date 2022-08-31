package com.example.learningapp;

public class Poem {
    String name;
    String description;

    public String getName() {
        return name;
    }

    public Poem(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
