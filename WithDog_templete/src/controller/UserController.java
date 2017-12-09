package controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
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
	
	@RequestMapping(value = "/registUser.do", method = RequestMethod.POST)
	public String registUser(User user, MultipartHttpServletRequest file) throws IOException {

		String realFolder = "c:\\" + File.separator + "tempFiles";
		File dir = new File(realFolder);
		if (!dir.isDirectory()) {
			dir.mkdirs();
		}
		
		MultipartFile petImage = file.getFile("pImage");
		System.out.println(petImage.getOriginalFilename());
		if (petImage == null && petImage.getOriginalFilename().equals("")) {
			
		} else {
			// 파일 중복명 처리
			String genId = UUID.randomUUID().toString();
			// 본래 파일명
			String originalfileName = petImage.getOriginalFilename();
			// 저장되는 파일 이름
			String saveFileName = genId + "." + originalfileName;

			File saveFile = new File(dir.getAbsolutePath() + File.separator + saveFileName);

			byte[] bytes = petImage.getBytes();

			BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(saveFile));
			out.write(bytes);
			out.close();

			user.setPetImage(saveFileName);
		}
		// System.out.println(user.getPetImage());

		// boolean registered =

		userService.registUser(user);

		return "redirect:login.jsp";
		// if(!registered) {
		// return "redirect:registUser.do";
		// }else {
		// return "redirect:login.do";
		// }
	}

	@RequestMapping("/login.do")
	public String showLogin() {
		return "login.jsp";
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(User user, HttpSession session) {

		User loginUser = userService.findUserByUserId(user.getUserId());
		if (loginUser != null) {
			if (user.getPassword().equals(loginUser.getPassword())) {
				session.setAttribute("loginUser", loginUser);
				return "redirect:main.do";
			}
		}
		return "redirect:login.jsp";
	}

	@RequestMapping("/removeUser.do")
	public String removeUser(String userId) {
		if(userId.equals("admin")) {
			return "redirect:adminPage_blackList.do";
		}else {
		userService.removeUser(userId);
		return "redirect:login.jsp";
		}
	}

	@RequestMapping("/logout.do")
	public String logout(HttpServletRequest req) {

		req.getSession().invalidate();
		return "redirect:login.do";
	}

	public ModelAndView showModifyUser(HttpServletRequest req) {

		HttpSession session = req.getSession();

		ModelAndView modelAndView = new ModelAndView("modifyUser.jsp");
		modelAndView.addObject("user", userService.findUserByUserId(session.getId()));

		return modelAndView;
	}

	@RequestMapping(value = "/myPage.do", method = RequestMethod.GET)
	public ModelAndView showModifyUser(HttpSession session){
		
		User user = (User)session.getAttribute("loginUser");
		
		ModelAndView modelAndView = new ModelAndView("myUser.jsp");
		modelAndView.addObject("user", user);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/myPage.do", method = RequestMethod.POST)
	public ModelAndView modifyUser(User user) {
		
		userService.modifyUser(user);
		
		ModelAndView modelAndView = new ModelAndView("myUser.jsp");
		modelAndView.addObject("user", user);
		
		return modelAndView;
	}
	
}