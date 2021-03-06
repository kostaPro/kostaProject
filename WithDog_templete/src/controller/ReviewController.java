package controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import domain.Comment;
import domain.Report;
import domain.Review;
import domain.Spot;
import domain.User;
import service.CommentService;
import service.ReportService;
import service.ReviewService;
import service.SpotService;
import service.UserService;

@Controller
public class ReviewController {

	@Autowired
	private ReviewService reviewService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private SpotService spotService;
	@Autowired
	private UserService userService;
	@Autowired
	private ReportService reportService;

	@RequestMapping(value = "/registReview.do", method = RequestMethod.GET)
	public ModelAndView showRegistReview(String spotId) {
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
	public String registReview(Review review, String spotId, MultipartHttpServletRequest file)
			throws IllegalStateException, IOException {

		review.setSpotId(Integer.parseInt(spotId));
		reviewService.registReview(review);

		String realFolder = "c:\\" + File.separator + "tempFiles";
		File dir = new File(realFolder);
		if (!dir.isDirectory()) {
			dir.mkdirs();
		}

		// 넘어온 파일을 리스트로 저장
		List<MultipartFile> mf = file.getFiles("file");
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

		return "redirect:reviewDetail.do?reviewId=" + review.getReviewId() + "&spotId=" + spotId;
	}

	@RequestMapping("/reviewDetail.do")
	public ModelAndView showReviewDetail(String reviewId, String spotId, HttpSession session) {

		Review review = reviewService.findReviewByReviewId(Integer.parseInt(reviewId));
		List<String> list = review.getReviewImageList();
		List<Comment> comment = review.getCommentList();

		ModelAndView modelAndView = new ModelAndView("reviewDetail.jsp");
		modelAndView.addObject("review", review);
		modelAndView.addObject("spot", spotService.findSpotBySpotId(Integer.parseInt(spotId)));
		modelAndView.addObject("comment", comment);
		modelAndView.addObject("uploadFileList", list);
		return modelAndView;
	}

	@RequestMapping("/deleteReview.do")
	public String deleteReview(String reviewId, String url) {

		reviewService.removeReview(Integer.parseInt(reviewId));

		return "redirect:"+url;
	}

	@RequestMapping("/modifyReview.do")
	public ModelAndView showModifyReview(String reviewId, String spotId) {

		Review review = reviewService.findReviewByReviewId(Integer.parseInt(reviewId));

		ModelAndView modelAndView = new ModelAndView("modifyReview.jsp");
		modelAndView.addObject("review", review);
		modelAndView.addObject("spot", spotService.findSpotBySpotId(Integer.parseInt(spotId)));
		return modelAndView;
	}

	@RequestMapping(value = "/modifyReview.do", method = RequestMethod.POST)
	public ModelAndView modifyReview(Review review, String spotId) {

		reviewService.modifyReview(review);

		ModelAndView modelAndView = new ModelAndView("reviewDetail.do");
		return modelAndView;
	}
	
	@RequestMapping(value = "/myModifyReview.do", method = RequestMethod.POST)
	public ModelAndView myModifyReview(Review review, String spotId) {

		reviewService.modifyReview(review);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("jsonView");
		return modelAndView;
	}

	@RequestMapping("/userPage_review.do")
	public ModelAndView showMyReview(String writerId, String spotId, HttpSession session) {

		User user = (User) session.getAttribute("loginUser"); 
		ModelAndView modelAndView = new ModelAndView("userPage_review.jsp");
		modelAndView.addObject("myReview", reviewService.findReviewsByWriterId(user.getUserId()));
		return modelAndView;
	}

	@RequestMapping(value = "/registReviewComment.do", method = RequestMethod.POST)
	public ModelAndView registReviewComment(Comment comment, String reviewId, String spotId, HttpSession session) {
		User user = (User) session.getAttribute("loginUser");

		comment.setWriterId(user.getUserId());
		comment.setTargetId(Integer.parseInt(reviewId));
		commentService.registReviewComment(comment);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("jsonView");
		return modelAndView;
	}

	@RequestMapping(value = "/modifyReviewComment.do", method = RequestMethod.POST)
	public ModelAndView modifyReviewComment(Comment comment, String commentId, String reviewId, String spotId) {

		comment.setCommentId(Integer.parseInt(commentId));
		commentService.modifyReviewComment(comment);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("jsonView");
		return modelAndView;
	}

	@RequestMapping("/removeReviewComment.do")
	public ModelAndView removeReviewComment(String commentId, String parentId, String reviewId, String spotId,
			HttpSession session) {

		ModelAndView modelAndView = new ModelAndView();

		User user = (User) session.getAttribute("loginUser");
		if (user.getUserId().equals("admin")) {

			Report report = new Report();

			report.setReportTargetId(Integer.parseInt(commentId));
			report.setReportType("reviewComment");
			report.setStatus("O");
			report.setReportContent("관리자 신고");
			report.setReporterId("admin");

			reportService.registReport(report);

			commentService.removeReviewComment(Integer.parseInt(commentId));

			modelAndView.setViewName("jsonView");
			return modelAndView;

		} else {

			commentService.removeReviewComment(Integer.parseInt(commentId));

			modelAndView = new ModelAndView();
			modelAndView.setViewName("jsonView");
			return modelAndView;
		}
	}

}
