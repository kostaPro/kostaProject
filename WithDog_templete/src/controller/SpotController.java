package controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
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
	public String registSpot(Spot spot,HttpSession session,MultipartHttpServletRequest file) throws IOException {
		
		spot.setRegisterId("mei");
		
		
		String realFolder = "c:\\" + File.separator + "tempFiles";
		File dir = new File(realFolder);
		if (!dir.isDirectory()) {
			dir.mkdirs();
		}

		//썸네일 저장
		MultipartFile thumbnail = file.getFile("spotThumbnail");
		if(thumbnail == null && thumbnail.getOriginalFilename().equals("")) {
		
		}else {
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
	
	@RequestMapping(value="/spotList.do", method = RequestMethod.GET)
	public ModelAndView showSpotList() {
		List<Spot> spotList = spotService.findAllSpots();
		ModelAndView modelAndView = new ModelAndView("spotList.jsp");
		modelAndView.addObject("spotList", spotList);
		return modelAndView;
	}
	
	@RequestMapping(value="/spotList.do", method = RequestMethod.POST)
	public ModelAndView searchSpotList(String location, String spotType, String spotName) {
		List<Spot> spotList = spotService.findSpotsBySpotName(spotName);
		ModelAndView modelAndView = new ModelAndView("spotList.jsp");
		modelAndView.addObject("spotList", spotList);
		return modelAndView;
	}


//	+showMySpot(session : HttpSession) : ModelAndView
//	+showModifySpot(spotId : String) : ModelAndView
//	+modifySpot(spot : Spot, file : MultipartHttpServletRequest) : String
//	+removeSpot(spotId : String) : String

	
	
}
