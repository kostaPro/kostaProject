package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import domain.Review;
import domain.Spot;
import service.ReportService;
import service.SpotService;

@Controller
public class SpotController {

	@Autowired
	private SpotService spotService;
	
	@Autowired
	private ReportService reportService;
	
	@RequestMapping("/spotDetail.do")
	public ModelAndView showSpotDetail(String spotId) {
		Spot spot = spotService.findSpotBySpotId(Integer.parseInt(spotId));
		ModelAndView modelAndView = new ModelAndView("spotDetail.jsp");
		modelAndView.addObject("spotDetail", spot);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/registSpot.do", method = RequestMethod.GET)
	public String showRegistSpot() {
		return "registSpot.jsp";
	}
	
	@RequestMapping(value = "/registSpot.do", method = RequestMethod.POST)
	public String registSpot(Spot spot,HttpSession session,MultipartHttpServletRequest file) {
		return "redirect:spotDetail.do?spotId=";
	}
	

//	+showSpotList() : ModelAndView
//	+searchSpotList(location : String, spotType : String, spotName : String) : ModelAndView

//	+showMySpot(session : HttpSession) : ModelAndView
//	+showModifySpot(spotId : String) : ModelAndView
//	+modifySpot(spot : Spot, file : MultipartHttpServletRequest) : String
//	+removeSpot(spotId : String) : String

	
	
}
