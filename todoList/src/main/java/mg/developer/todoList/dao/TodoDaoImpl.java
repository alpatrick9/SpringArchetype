package mg.developer.todoList.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.*;
import org.springframework.stereotype.Service;

import mg.developer.todoList.models.Todo;
import mg.developer.todoList.tools.HibernateUtil;

@Service
public class TodoDaoImpl implements TodoDao {
	
	private SessionFactory factory;
	
	public TodoDaoImpl() {
		this.factory = HibernateUtil.getSessionFactory();
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Todo> findAll() {
		Session session = this.factory.openSession();
		List<Todo> todos = new ArrayList<>();
		todos = session.createCriteria(Todo.class).list();
		session.clear();
		return todos;
	}
	
	public void create(Todo todo) {
		Session session = this.factory.openSession();
		session.beginTransaction();
		session.save(todo);
		session.getTransaction().commit();
		session.clear();
	}
	
	public void update(Todo todo) {
		Session session = this.factory.openSession();
		session.beginTransaction();
		session.update(todo);
		session.getTransaction().commit();
		session.clear();
	}
	
	public void delete(int id) {
		Session session = this.factory.openSession();
		Todo todo = find(id);
		session.beginTransaction();
		session.delete("Todo", todo);
		session.getTransaction().commit();
		session.clear();
	}
	
	public Todo find(int id) {
		Session session = this.factory.openSession();
		Todo todo = session.get(Todo.class, id);
		session.clear();
		return todo;
	}
}
