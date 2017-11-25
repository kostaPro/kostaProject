package controller;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import domain.Review;
import domain.Spot;
import domain.User;
import service.CommentService;
import service.ReviewService;
import service.SpotService;

@Controller
public class ReviewController {

	@Autowired
	private ReviewService reviewService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private SpotService spotService;

	@RequestMapping("/registReview.do")
	public ModelAndView showRegistReview(String spotId, HttpServletRequest req) {
		User user = new User();
		user.setUserId("jakook");

		HttpSession session = req.getSession();
		session.setAttribute("user", user);
		
		long now = System.currentTimeMillis();
		Date date = new Date(now);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String getTime = sdf.format(date);

		ModelAndView modelAndView = new ModelAndView("registReview.jsp");
		modelAndView.addObject("spot", spotService.findSpotBySpotId(Integer.parseInt(spotId)));
		modelAndView.addObject("date", getTime);

		return modelAndView;
	}

	@RequestMapping(value = "/registReview.do", method = RequestMethod.POST)
	public String registReview(Review review, String spotId, HttpServletRequest req) {
		
		review.setSpotId(Integer.parseInt(req.getParameter("spotId")));
		reviewService.registReview(review);
		
		return "reviewDetail.jsp";
	}
}
