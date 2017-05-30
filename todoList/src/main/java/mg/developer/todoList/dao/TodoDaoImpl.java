package mg.developer.todoList.dao;

import org.hibernate.*;
import org.springframework.stereotype.Service;

import mg.developer.todoList.models.Todo;

@Service
public class TodoDaoImpl extends EntityDaoAbs<Todo, Integer> implements TodoDao {

	public TodoDaoImpl() {
		this.type = Todo.class;
	}

	@Override
	public void delete(Integer key) {
		Session session = this.factory.openSession();
		Todo todo = find(key);
		session.beginTransaction();
		session.delete("Todo", todo);
		session.getTransaction().commit();
		session.clear();
		
	}
}
