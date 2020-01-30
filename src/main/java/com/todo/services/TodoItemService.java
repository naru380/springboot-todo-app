package com.todo.services;

import com.todo.entities.TodoItem;
import com.todo.repositories.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoItemService {

    @Autowired
    private TodoItemRepository todoItemRepository;

    public TodoItem getTodoItemById(Long id) {
        return todoItemRepository.findById(id).get();
    }

    public List<TodoItem> getTodoItemList() {
        return todoItemRepository.findAll();
    }

    public TodoItem save(TodoItem todoItem) {
        return todoItemRepository.save(todoItem);
    }

    public void delete(TodoItem todoItem) {
        todoItemRepository.delete(todoItem);
    }

    public List<TodoItem> getTitleAscYetTodoItemList() {
        return todoItemRepository.findByDoneOrderByTitleAsc(Boolean.FALSE);
    }

    public List<TodoItem> getTitleAscDoneTodoItemList() {
        return todoItemRepository.findByDoneOrderByTitleAsc(Boolean.TRUE);
    }

}
