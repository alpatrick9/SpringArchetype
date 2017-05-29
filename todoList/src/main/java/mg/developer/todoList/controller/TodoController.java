package mg.developer.todoList.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mg.developer.todoList.models.Todo;
import mg.developer.todoList.services.TodoServices;

@Controller
@RequestMapping("/secure")
public class TodoController {

	private ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
	private TodoServices todoServices = (TodoServices) context.getBean("todoServices");
	
	@RequestMapping("/")
	public ModelAndView home(@RequestParam(value = "id", required = false) String id) {

		ModelAndView mv = new ModelAndView("index");
		mv.addObject("todos", todoServices.getAllTodos());

		Todo todoForm = new Todo();
		if (id != null && !id.isEmpty()) {
			todoForm = todoServices.findTodo(Integer.parseInt(id));
		}
		mv.addObject("todoForm", todoForm);
		mv.addObject("todoAddUrl", "/secure/add_todo");
		mv.addObject("todoDeleteUrl", "/secure/delete_todo");
		mv.addObject("todoUpdateUrl", "");
		return mv;

	}

	@RequestMapping(value = "/add_todo", method = RequestMethod.POST)
	public ModelAndView addTodo(@ModelAttribute("todoForm") Todo todo) {
		if (todo.getId() == null) {
			todoServices.createTodo(todo);
		} else {
			todoServices.updateTodo(todo);
		}
		return new ModelAndView("redirect:/secure/");
	}

	@RequestMapping(value = "/delete_todo", method = RequestMethod.GET)
	public ModelAndView deleteTodo(@RequestParam("id") int id) {
		todoServices.deleteTodo(id);
		return new ModelAndView("redirect:/secure/");
	}
}
