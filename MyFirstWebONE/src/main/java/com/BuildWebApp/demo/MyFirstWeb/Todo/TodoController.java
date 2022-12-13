package com.BuildWebApp.demo.MyFirstWeb.Todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("MyName")
public class TodoController {

	@Autowired
	private TodoService todoservice;
	
	@RequestMapping("/todo-list")
	public String showList(Model model) {
		String username = getLoggedInUsername(model);
		 List<Todo> todos = todoservice.showlist(username);
		model.addAttribute("todos",todos);
		return "viewtodo";
	}

	
	
	/*@RequestMapping(value="add-todo", method=RequestMethod.GET)
	public String addingTodo() {
		 
		return "viewAddTodo";
	}*/
	
	/*@RequestMapping(value="add-todo", method=RequestMethod.POST)
	public String addingNewTodo(@RequestParam String course,Model model) {
		String username = (String) model.getAttribute("MyName");
		todoservice.updatedList(username, addtodo, LocalDate.now().plusYears(1), false);
		return "redirect:todo-list";
	}*/
	@RequestMapping(value="add-todo", method=RequestMethod.GET)
	public String addingTodo(Model model) {
		String username = getLoggedInUsername(model);
		Todo todo = new Todo(0, username, "", LocalDate.now().plusYears(1), false);
		model.addAttribute("todo", todo);
		return "viewAddTodo";
	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.POST)
	public String addingNewTodo(Model model,@Valid Todo todo,BindingResult result) {        //todo is the form backing object
		if(result.hasErrors()) {
			return "viewAddTodo";
		}
		String username = getLoggedInUsername(model);
		todoservice.updatedList(username, todo.getCourse(), todo.getPeriod(), false);
		return "redirect:todo-list";
	}
	
	@RequestMapping("/delete-todo")
	public String deleteMethod(@RequestParam int id, Model model) {
		todoservice.deleteChey(id);
		return "redirect:todo-list";
	}
	
	@RequestMapping(value="/update-todo", method=RequestMethod.GET)   //when we want to show update to do page we will use get method
	public String update(@RequestParam int id, Model model) {
		Todo todo = todoservice.findById(id);
		model.addAttribute("todo", todo);
		return "viewAddTodo";
	}
	
	@RequestMapping(value="/update-todo", method=RequestMethod.POST)     //post method is used to show updated details after clicking submit button
	public String updateTodo(Model model,@Valid Todo todo,BindingResult result) {        
		if(result.hasErrors()) {
			return "viewAddTodo";
		}
		todoservice.updatetodo(todo);
		return "redirect:todo-list";
	}
	
	private String getLoggedInUsername(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
}



















