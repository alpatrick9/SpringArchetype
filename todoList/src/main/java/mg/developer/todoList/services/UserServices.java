package mg.developer.todoList.services;

import java.util.List;

import mg.developer.todoList.dao.UserDao;
import mg.developer.todoList.models.User;

public class UserServices {

	private UserDao userDao;

	public UserServices(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public List<User> getAllUsers() {
		return userDao.findAll();
	}
	
}
