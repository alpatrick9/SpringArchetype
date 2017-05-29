package mg.developer.todoList.services;

import java.util.List;

import mg.developer.todoList.dao.TodoDao;
import mg.developer.todoList.models.Todo;

public class TodoServices {

	private TodoDao todoDao;

	public TodoServices(TodoDao todoDao) {
		this.todoDao = todoDao;
	}

	public List<Todo> getAllTodos() {
		return todoDao.findAll();
	}

	public void createTodo(Todo todo) {
		todoDao.create(todo);
	}

	public void updateTodo(Todo todo) {
		todoDao.update(todo);
	}

	public void deleteTodo(int id) {
		todoDao.delete(id);
	}

	public Todo findTodo(int id) {
		return todoDao.find(id);
	}

}
