package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import domain.User;
import service.UserService;

@Controller
public class MobileUserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/mobileLogin.do", produces = "application/xml")
	public @ResponseBody String login(User user) {

		User loginUser = userService.findUserByUserId(user.getUserId());
		if (loginUser != null) {
				return "true";
			}else {
				return "false";
		}
	}

}
