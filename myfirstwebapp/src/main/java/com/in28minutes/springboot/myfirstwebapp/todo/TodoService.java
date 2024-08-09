package com.in28minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList<Todo>();
	private static int todosCount = 0;
	
	static {
		todos.add(new Todo(++todosCount,"giri", "springboot", LocalDate.now().plusMonths(1), false));
		todos.add(new Todo(++todosCount,"giri", "shift", LocalDate.now().plusMonths(2), false));
		todos.add(new Todo(++todosCount, "ranga", "play an instrumnet", LocalDate.now().plusMonths(3), false));
	}
	
	public List<Todo> getTodosByUsername(String userName) {
		Predicate<? super Todo> predicate = todo -> todo.getUserName().equals(userName);
		
		return todos.stream().filter(predicate).toList();
	}

	 public void addTodo(String username, String description, LocalDate plusYears,boolean b) 
	 { 
		 todos.add(new Todo(++todosCount, username, description, plusYears, b)); 
	 }

	 public void deleteById(int id) {
			//todo.getId() == id
			// todo -> todo.getId() == id
			Predicate<? super Todo> predicate = todo -> todo.getId() == id;
			todos.removeIf(predicate);
		}
	 
	 public Todo findById(int id) {
			Predicate<? super Todo> predicate = todo -> todo.getId() == id;
			Todo todo = todos.stream().filter(predicate).findFirst().get();
			return todo;
		}

	public void updateTodo(@Valid Todo todo) {
		deleteById(todo.getId());
		todos.add(todo);
	}
}
