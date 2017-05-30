package mg.developer.todoList.services;

import java.util.List;

import mg.developer.todoList.dao.UserRoleDao;
import mg.developer.todoList.models.UserRole;

public class UserRoleServices {

	private UserRoleDao userRoleDao;
	
	public UserRoleServices(UserRoleDao userRoleDao) {
		this.userRoleDao = userRoleDao;
	}
	
	public List<UserRole> getAllUserRoles() {
		return userRoleDao.findAll();
	}
	
	public void add(UserRole userRole) {
		userRoleDao.create(userRole);
	}
	
	public void delete(Integer id) {
		userRoleDao.delete(id);
	}
	
	public void update(UserRole userRole) {
		userRoleDao.update(userRole);
	}
	
	public UserRole findUserRole(Integer id) {
		return userRoleDao.find(id);
	}
}
