package mg.developer.todoList.dao;

import java.util.List;

import mg.developer.todoList.models.Todo;

public interface TodoDao {
	
	public List<Todo> findAll();
	
	public void create(Todo todo);
	
	public void update(Todo todo);
	
	public void delete(int id);
	
	public Todo find(int id);
	
}
