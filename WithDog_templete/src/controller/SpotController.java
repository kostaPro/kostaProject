package controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import domain.Review;
import domain.Spot;
import domain.Spots;
import domain.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
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

		String location = spot.getSpotLocation();
		String locArray[] = location.split(" ");
		String keyArray[] = { "locationDo", "locationGu", "locationDong", "locationBunji" };

		ModelAndView modelAndView = new ModelAndView("spotDetail.jsp");
		modelAndView.addObject("spotDetail", spot);

		// 주소지 시군구별로 셋팅
		for (int i = 0; i < keyArray.length; i++) {
			if (locArray[i] != null) {
				modelAndView.addObject(keyArray[i], locArray[i]);
			} else {
				modelAndView.addObject(keyArray[i], " ");
			}
		}
		return modelAndView;
	}

	@RequestMapping(value = "/registSpot.do", method = RequestMethod.GET)
	public String showRegistSpot() {
		return "registSpot.jsp";
	}

	@RequestMapping(value = "/registSpot.do", method = RequestMethod.POST)
	public String registSpot(Spot spot, HttpSession session, MultipartHttpServletRequest file) throws IOException {

		User user = (User)session.getAttribute("loginUser");
		spot.setRegisterId(user.getUserId());

		String realFolder = "c:\\" + File.separator + "tempFiles";
		File dir = new File(realFolder);
		if (!dir.isDirectory()) {
			dir.mkdirs();
		}

		// 썸네일 저장
		MultipartFile thumbnail = file.getFile("spotThumbnail");
		if (thumbnail == null && thumbnail.getOriginalFilename().equals("")) {

		} else {
			// 파일 중복명 처리
			String genId = UUID.randomUUID().toString();
			// 본래 파일명
			String originalfileName = thumbnail.getOriginalFilename();
			// 저장되는 파일 이름
			String saveFileName = genId + "." + originalfileName;

			File saveFile = new File(dir.getAbsolutePath() + File.separator + saveFileName);

			byte[] bytes = thumbnail.getBytes();

			BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(saveFile));
			out.write(bytes);
			out.close();

			spot.setThumbnail(saveFileName);
		}

		String baseAddr = spot.getSpotLocation();
		spot.setSpotLocation(baseAddr + " " + spot.getSpotName());

		spotService.registSpot(spot);

		// 넘어온 파일을 리스트로 저장
		List<MultipartFile> mf = file.getFiles("spotImage");
		if (mf.size() == 0 && mf.get(0).getOriginalFilename().equals("")) {

		} else {
			for (int i = 0; i < mf.size(); i++) {
				// 파일 중복명 처리
				String genId = UUID.randomUUID().toString();
				// 본래 파일명
				String originalfileName = mf.get(i).getOriginalFilename();
				// 저장되는 파일 이름
				String saveFileName = genId + "." + originalfileName;

				File saveFile = new File(dir.getAbsolutePath() + File.separator + saveFileName);

				byte[] bytes = mf.get(i).getBytes();

				BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(saveFile));
				out.write(bytes);
				out.close();

				spotService.registSpotImage(spot.getSpotId(), saveFileName);
			}
		}

		return "redirect:spotDetail.do?spotId=" + spot.getSpotId();
	}

	@RequestMapping(value = "/addSpot.do", method = RequestMethod.POST, produces = "text/json; charset=UTF-8")
	public @ResponseBody ModelAndView addSpot(Spot spot, HttpSession session) {

		User user = (User) session.getAttribute("loginUser");
		spot.setRegisterId(user.getUserId());
		spot.setSpotLocation(spot.getSpotLocation() + " " + spot.getSpotName());

		spotService.registSpot(spot);

		ModelAndView modelAndView = new ModelAndView("jsonView");
		return modelAndView;
	}

	@RequestMapping(value = "/spotList.do", method = RequestMethod.GET)
	public ModelAndView showSpotList() {
		List<Spot> spotList = spotService.findAllSpots();

		ModelAndView modelAndView = new ModelAndView("spotList.jsp");
		modelAndView.addObject("spotList", spotList);
		return modelAndView;
	}

	@RequestMapping(value = "/spotList.do", method = RequestMethod.POST)
	public ModelAndView searchSpotList(String spotLocation, String spotType, String spotName) {
		List<Spot> spotList = spotService.findSpotsByCondition(spotLocation, spotType, spotName);
		ModelAndView modelAndView = new ModelAndView("spotList.jsp");
		modelAndView.addObject("spotList", spotList);
		return modelAndView;
	}

	@RequestMapping(value = "/searchSpot.do", produces = "application/xml")
	public @ResponseBody Spots searchSpot(String spotLocation) {
		Spots spotList = new Spots();
		List<Spot> spots = spotService.findSpotsByCondition(spotLocation, "", "");

		spotList.setSpotList(spots);
		return spotList;
	}

	@RequestMapping(value = "/userPage_spot.do")
	public ModelAndView showMySpot(HttpSession session) {

		User user = (User) session.getAttribute("loginUser");
		String registerId = user.getUserId();

		List<Spot> spotList = spotService.findSpotsByRegisterId(registerId);

		ModelAndView modelAndView = new ModelAndView("userPage_spot.jsp");
		modelAndView.addObject("spotList", spotList);

		return modelAndView;
	}

	@RequestMapping(value = "/adminPage_spot.do")
	public ModelAndView showAdminSpot() {

		List<Spot> spotList = spotService.findAllSpots();

		ModelAndView modelAndView = new ModelAndView("adminPage_spot.jsp");
		modelAndView.addObject("spotList", spotList);

		return modelAndView;
	}

	// +showModifySpot(spotId : String) : ModelAndView
	// +modifySpot(spot : Spot, file : MultipartHttpServletRequest) : String
	// +removeSpot(spotId : String) : String

}
