package com.kikesf.androidadventures.todoApp;

import com.kikesf.androidadventures.todoApp.models.Todo;

public interface TodoActions {
    void addTodo(Todo todo);
    boolean updateTodo(int todoId);
    boolean removeTodo(int todoId);
}
