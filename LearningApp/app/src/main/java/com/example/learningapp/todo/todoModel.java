package com.example.learningapp.todo;

import androidx.annotation.NonNull;

public class todoModel {
    String name;
    String description;

    public String getName() {
        return name;
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

    public todoModel(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}
