package mg.developer.todoList.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mg.developer.todoList.models.UserRole;
import mg.developer.todoList.services.UserRoleServices;

@Controller
@RequestMapping("/secure")
public class UserController {
	
	private ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
	private UserRoleServices userRoleServices = (UserRoleServices)context.getBean("userRoleServices");
	
	@RequestMapping("/users")
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("user/index");
		mv.addObject("users", userRoleServices.getAllUserRoles());
		
		UserRole userRole = new UserRole();
		
		mv.addObject("userRoleForm", userRole);
		mv.addObject("addUser", "/secure/add_user");
		mv.addObject("deleteUser", "delete_user");
		return mv;
	}
	
	@RequestMapping("/add_user")
	public ModelAndView addUser(@ModelAttribute("userRoleForm") UserRole userRole) {
		userRoleServices.add(userRole);
		return new ModelAndView("redirect:/secure/users");
	}
	
	@RequestMapping("/delete_user")
	public ModelAndView deleteUser(@RequestParam(value="id") Integer id) {
		userRoleServices.delete(id);
		return new ModelAndView("redirect:/secure/users");
	}
}
