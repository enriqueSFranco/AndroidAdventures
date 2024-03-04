package com.kikesf.androidadventures.todoApp;

import com.kikesf.androidadventures.todoApp.models.Todo;

public class TodoHandler implements TodoActions {

    @Override
    public void addTodo(Todo todo) {}

    @Override
    public boolean updateTodo(int todoId) {
        return true;
    }

    @Override
    public boolean removeTodo(int todoId) {
        return true;
    }
}
