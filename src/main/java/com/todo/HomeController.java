package com.todo;

import com.todo.entities.TodoItem;
import com.todo.services.TodoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller public class HomeController {

    @Autowired
    private TodoItemService todoItemService;

    @RequestMapping("/")
    public String index(Model model) {
        List<TodoItem> yetTodoItemList = todoItemService.getTitleAscYetTodoItemList();
        List<TodoItem> doneTodoItemList = todoItemService.getTitleAscDoneTodoItemList();
        model.addAttribute("yetTodoItemList", yetTodoItemList);
        model.addAttribute("doneTodoItemList", doneTodoItemList);
        return "index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addTodo(@RequestParam("title") String title) {
        TodoItem todoItem = new TodoItem();
        todoItem.setTitle(title);
        todoItem.setDone(Boolean.FALSE);
        todoItemService.save(todoItem);
        return "redirect:/";
    }

    @RequestMapping(value = "/done", method = RequestMethod.POST)
    public String doneTodo(@RequestParam("id") String id) {
        TodoItem todoItem = todoItemService.getTodoItemById(Long.parseLong(id));
        todoItem.setDone(Boolean.TRUE);
        todoItemService.save(todoItem);
        return "redirect:/";
    }

    @RequestMapping(value = "/yet", method = RequestMethod.POST)
    public String yetTodo(@RequestParam("id") String id) {
        TodoItem todoItem = todoItemService.getTodoItemById(Long.parseLong(id));
        todoItem.setDone(Boolean.FALSE);
        todoItemService.save(todoItem);
        return "redirect:/";
    }
}
