package semiproject.review.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import semiproject.member.model.vo.Member;
import semiproject.review.model.service.ReviewService;
import semiproject.review.model.vo.Review;

/**
 * Servlet implementation class ReviewController
 */
@WebServlet("/review/*")
public class ReviewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ReviewService reviewService = new ReviewService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] uriArr = request.getRequestURI().split("/");
		
		switch(uriArr[uriArr.length - 1]) {
		case "listMypageReview" : listMypageReview (request,response);
			break;
		case "upload" : uploadReview (request, response);
			break;
		case "reviewList" : reviewList (request, response);
			break;
		default : response.setStatus(404);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	
	private void listMypageReview(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/view/review/listMypageReview.jsp")
		.forward(request, response);
	}
	
	private void uploadReview(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reviewUser = request.getParameter("reviewUser");
		String wrReview = request.getParameter("wrReview");
		String starRating = request.getParameter("starRating");
		
		
		Review review = new Review();
		review.setRvUserId(reviewUser);
		review.setReview(wrReview);
		review.setRating(starRating);
		
		reviewService.insertReview(review);
		
		request.getSession().setAttribute("alertMsg", "리뷰가 등록되었습니다.");
		
		request.getRequestDispatcher("/WEB-INF/view/user-mypage/mypage.jsp")
		.forward(request, response);
	}
	
	
	private void reviewList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ReviewService reviewService = new ReviewService();
		
		Member member = (Member) session.getAttribute("user");
		
		String rvListId = member.getUserId();
		
		ArrayList<Review> reviewArr = reviewService.selectReviewList(rvListId);
		
		request.setAttribute("reviewArr", reviewArr);
		
		request.getRequestDispatcher("/WEB-INF/view/review/listMypageReview.jsp")
		.forward(request, response);
		
	}

}


