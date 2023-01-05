package com.BuildWebApp.demo.MyFirstWeb.Todo;

//generally we need to connect with database but as of now continue with a static list
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {

	private static int todocount = 0;
	
	private static List<Todo> todos = new ArrayList<>();
	static {
		todos.add(new Todo(++todocount, "NaveenS", "java", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todocount, "Dhanu", "CyberSecurity", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++todocount, "Prasanth", "Police", LocalDate.now().plusYears(1), false));
	}
	
	public List<Todo> showlist(String username){
		Predicate<? super Todo> predicate = todo -> todo.getUsername().equalsIgnoreCase(username);  //filtering todos by username
		return  todos.stream().filter(predicate).toList();
		
	}
	
	public void updatedList( String username,String course, LocalDate period,boolean status){
		Todo todo = new Todo(++todocount, username, course, period, status);
		todos.add(todo);
		
	}

	public void deleteChey(int id) {
		
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}

	public Todo findById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		Todo todo = todos.stream().filter(predicate).findFirst().get();
		return todo;
	}

	public void updatetodo(@Valid Todo todo) {
		deleteChey(todo.getId());
		todos.add(todo);
	}


}
