package mg.developer.todoList.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import mg.developer.todoList.tools.HibernateUtil;

public abstract class EntityDaoAbs<E, PK extends Serializable> implements EntityDao<E, PK>{

	protected final SessionFactory factory = HibernateUtil.getSessionFactory();;
	
	protected Class<E> type;
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<E> findAll() {
		Session session = this.factory.openSession();
		List<E> results = new ArrayList<>();
		results = session.createCriteria(type).list();
		session.clear();
		return results;
	}

	@Override
	public void create(E entity) {
		Session session = this.factory.openSession();
		session.beginTransaction();
		session.save(entity);
		session.getTransaction().commit();
		session.clear();
	}

	@Override
	public void update(E entity) {
		Session session = this.factory.openSession();
		session.beginTransaction();
		session.update(entity);
		session.getTransaction().commit();
		session.clear();
		
	}

	@Override
	public E find(PK key) {
		Session session = this.factory.openSession();
		E entity = session.get(type, key);
		session.clear();
		return entity;
	}

}
