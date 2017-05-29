package mg.developer.todoList.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@RequestMapping("/login")
	public ModelAndView loginForm(
			@RequestParam(value="error", required=false, defaultValue="false") boolean error,
			@RequestParam(value="logout", required=false, defaultValue="false") boolean logout) {
		ModelAndView loginForm = new ModelAndView("/login");
		loginForm.addObject("error", error);
		loginForm.addObject("logout", logout);
		return loginForm;
	}

	@RequestMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		session.invalidate();
		return new ModelAndView("redirect:login?logout=true");
	}
}
