package com.kikesf.androidadventures.todoApp.models;

import com.kikesf.androidadventures.todoApp.TodoCategory;

public class Todo {
    private int todoId;
    private String title;
    private boolean isCompleted;
    private TodoCategory category;

    public Todo(String title, boolean isCompleted, TodoCategory category) {
        this.title = title;
        this.isCompleted = isCompleted;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public TodoCategory getCategory() {
        return category;
    }

    public void setCategory(TodoCategory category) {
        this.category = category;
    }
}
