package controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import domain.Review;
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

	@RequestMapping(value = "/registReview.do", method = RequestMethod.GET)
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
	public ModelAndView registReview(Review review, @RequestParam("spotId") String spotId, HttpServletRequest req,
			MultipartHttpServletRequest mhsq) throws IllegalStateException, IOException {

		review.setSpotId(Integer.parseInt(spotId));
		reviewService.registReview(review);

		String realFolder = "c:\\" + File.separator + "tempFiles";
		File dir = new File(realFolder);
		if (!dir.isDirectory()) {
			dir.mkdirs();
		}

		// 넘어온 파일을 리스트로 저장
		List<MultipartFile> mf = mhsq.getFiles("file");
		if (mf.size() == 1 && mf.get(0).getOriginalFilename().equals("")) {

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

				reviewService.registReviewImage(saveFileName, review.getReviewId());
			}
		}
		return new ModelAndView("redirect:result.jsp");
	}

	@RequestMapping("/reviewDetail.do")
	public ModelAndView content(String reviewId, HttpSession session) {

		Review uploadFileList = reviewService.findReviewByReviewId(Integer.parseInt(reviewId));

		List<String> list = uploadFileList.getReviewImageList();

		ModelAndView mav = new ModelAndView("reviewDetail.jsp");
		mav.addObject("uploadFileList", list);
		return mav;
	}

}
