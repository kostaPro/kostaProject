package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import domain.Review;
import domain.Spot;
import service.SpotService;

@Controller
public class SpotController {

	@Autowired
	private SpotService spotService;
	
	@RequestMapping("/spotDetail.do")
	public ModelAndView showSpotDetail(String spotId) {
		Spot spot = spotService.findSpotBySpotId(Integer.parseInt(spotId));
		List<Review> review = spot.getReviewList();
		ModelAndView modelAndView = new ModelAndView("spotDetail.jsp");
		modelAndView.addObject("spotDetail", spot);
		modelAndView.addObject("review", review);
		
		return modelAndView;
	}
}
