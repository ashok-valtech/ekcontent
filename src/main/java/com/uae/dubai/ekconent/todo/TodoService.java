package com.uae.dubai.ekconent.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();
    private static int todosCount = 0;
    static {
        todos.add(new Todo(++todosCount, "in28Minits","LearnAWS",LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todosCount, "in28Minits","Learnjava",LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todosCount, "in28Minits","LearnDevops",LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todosCount, "in28React","LearnAWS",LocalDate.now().plusYears(1), false));
    }

    public List<Todo> findmyUserName(String username) {
        return todos;
    }
    
    public List<Todo> addTodo(String userName,String description, LocalDate targetDate, boolean done) {
    	 todos.add(new Todo(++todosCount, userName,description,targetDate, done));
        return todos;
    }
    
    public void deleteTodo(int id) {
    	Predicate<? super Todo> predicate = x -> x.getId() == id;
    	todos.removeIf(predicate);
   }
    
    public void updateTodo(int id) {
    	Predicate<? super Todo> predicate = x -> x.getId() == id;
//    	todos.removeIf(predicate);
   }

	public Todo findBYid(int id) {
		// TODO Auto-generated method stub
		Predicate<? super Todo> predicate = x -> x.getId() == id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void UpdateTodo(@Valid Todo todo) {
		// TODO Auto-generated method stub
		deleteTodo(todo.getId());
		todos.add(todo);
	}
}
