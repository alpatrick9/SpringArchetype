package mg.developer.todoList.dao;

import org.hibernate.Session;

import mg.developer.todoList.models.User;

public class UserDaoImpl extends EntityDaoAbs<User, String> implements UserDao {

	public UserDaoImpl() {
		this.type = User.class;
	}
	@Override
	public void delete(String key) {
		Session session = this.factory.openSession();
		User user = find(key);
		session.beginTransaction();
		session.delete("User", user);
		session.getTransaction().commit();
		session.clear();
		
	}

}
