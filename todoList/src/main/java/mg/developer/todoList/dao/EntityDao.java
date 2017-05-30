package mg.developer.todoList.dao;

import java.io.Serializable;
import java.util.List;

public interface EntityDao<E , PK extends Serializable> {
	
	public List<E> findAll();

	public void create(E entity);

	public void update(E entity);

	public void delete(PK key);

	public E find(PK key);

}
