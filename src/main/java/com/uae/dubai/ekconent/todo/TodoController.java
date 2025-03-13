package com.uae.dubai.ekconent.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoController {
    private TodoService todoService;

    public TodoController(TodoService todoService) {
        super();
        this.todoService = todoService;
    }
   @RequestMapping("list-todos")
   public String listAllTodos(ModelMap model) {
    List<Todo> todos = todoService.findmyUserName("ashok");
    model.addAttribute("todos",todos);   
    return "listTodos"; 
   }
   
   @RequestMapping(value = "add-todo", method = RequestMethod.GET)
   public String ShowNewTodoPage(ModelMap model) {
	   Todo todo = new Todo(0,(String)model.get("name"),"",LocalDate.now().plusYears(1),false);
	   model.put("todo",todo);
    return "todo"; 
   }
   
   @RequestMapping(value = "add-todo", method = RequestMethod.POST)
   public String addNewTodoPage(ModelMap model,@Valid Todo todo, BindingResult result) {
	   if(result.hasErrors()) {
		   return "todo"; 
	   }
	   System.out.println("in add todo--------------" +todo.toString());
	 todoService.addTodo((String)model.get("name"),todo.getDescription(),todo.getTargetDate(),true);
    return "redirect:list-todos"; 
   }
   
   @RequestMapping(value = "delete-todo")
   public String deleteTodo(@RequestParam int id) {
	   System.out.println("idd deleteeee--" +id);
	   todoService.deleteTodo(id);
    return "redirect:list-todos"; 
   }
   
   @RequestMapping(value = "update-todo", method = RequestMethod.GET)
   public String updateTodo(@RequestParam int id, ModelMap model) {
	   System.out.println("idd update--" +id);
	   Todo todo = todoService.findBYid(id);
	   model.addAttribute("todo",todo);
    return "todo"; 
   }
   
   @RequestMapping(value = "update-todo", method = RequestMethod.POST)
   public String addupdateTodoPage(ModelMap model,@Valid Todo todo, BindingResult result) {
	   if(result.hasErrors()) {
		   return "todo"; 
	   }
	   System.out.println("in update todo--------------" +todo.toString());
	   String username = (String)model.get("name");
	   todo.setUsername(username);
	 todoService.UpdateTodo(todo);
    return "redirect:list-todos"; 
   }
   
}
