package com.todo.repositories;

import com.sun.tools.javac.comp.Todo;
import com.todo.entities.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {
    public List<TodoItem> findByDoneOrderByTitleAsc(boolean done);
}
