package mg.developer.todoList.dao;

import org.hibernate.Session;

import mg.developer.todoList.models.UserRole;

public class UserRoleDaoImpl extends EntityDaoAbs<UserRole, Integer> implements UserRoleDao {

	public UserRoleDaoImpl() {
		this.type = UserRole.class;
	}
	@Override
	public void delete(Integer key) {
		Session session = this.factory.openSession();
		UserRole userRole = find(key);
		session.beginTransaction();
		session.delete("UserRole", userRole);
		session.getTransaction().commit();
		session.clear();
		
	}

}
