package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import domain.User;
import service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/")
	public String main() {
		return "redirect:login.jsp";
	}

	
	@RequestMapping(value = "/registUser.do", method = RequestMethod.GET)
	public String showRegistUser() {
		
		return "registUser.jsp";
	}
	
//	@RequestMapping(value = "registUser.do", method = RequestMethod.POST)
//	public String registUser(User user)  {
//		
//		boolean registered = userService.registUser(user);
//		
//		
//		if(!registered) {
//			ModelAndView modelAndView = new ModelAndView("registUser.jsp");
//			return "redirect:registerUser.do";
//		}else {
//			return "redirect:login.do";
//		}
//	}
	
	@RequestMapping("/login.do")
	public String showLogin() {
		return "login.jsp";
	}
	
}
