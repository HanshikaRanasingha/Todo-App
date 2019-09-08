package com.assignment.todolist.todolist.todo;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@Autowired
	private TodoService todoService;
	
	@RequestMapping("/todos")
	public List<Todo> getAllTodos() {
		return todoService.getAllTodos();
	}
	
	@RequestMapping("/todos/{id}")
	public Todo getTodo(@PathVariable String id) {
		return todoService.getTodo(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/todos")
	public void addTodo(@RequestBody Todo todo) {
		todoService.addTodo(todo);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/todos/{id}")
	public void updateTodo(@RequestBody Todo todo, @PathVariable String id) {
		todoService.updateTodo(id, todo);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/todos/{id}")
	public void deleteTodo(@PathVariable String id) {
		todoService.deleteTodo(id);
	}
}
