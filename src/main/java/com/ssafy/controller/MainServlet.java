package com.ssafy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.house.dto.FavoriteDto;
import com.ssafy.house.dto.MemberDto;
import com.ssafy.house.dto.PageBean;
import com.ssafy.house.service.FavoriteService;
import com.ssafy.house.service.FavoriteServiceImpl;
import com.ssafy.house.service.HouseService;
import com.ssafy.house.service.HouseServiceImpl;
import com.ssafy.house.service.LoginService;
import com.ssafy.house.service.LoginServiceImpl;


@WebServlet("/main.do")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	LoginService loginService;
	FavoriteService favoriteService;
	HouseService houseService;

	public void init() throws ServletException {
		super.init();
		loginService = new LoginServiceImpl();
		houseService = new HouseServiceImpl();
		favoriteService = new FavoriteServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void process(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		request.setCharacterEncoding("UTF-8");
		
		String root = request.getContextPath();
		String action = request.getParameter("action");
		System.out.println("IP>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + request.getRemoteAddr());
		System.out.println("action>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + action);
		String url = "index.jsp";
		try {
			if (action != null) {
				if (action.equals("login")) {
					url = login(request, response);
				} else if (action.equals("join")) {
					url = join(request, response);
				} else if (action.equals("search")) {
					url = searchAll(response, request);
				} else if (action.equals("searchPost")) {
					url = searchPost(response, request);
				} else if (action.equals("logout")) {
					url = logout(request, response);
				} else if (action.equals("listmember")) {
					url = listMember(response, request);
				}else if (action.equals("deletemember")) {
					url = deleteMember(response, request);
				}else if (action.equals("updatemember")) {
					url = updateMember(response, request);
				}else if (action.equals("addfavorite")) {
					url = addFavorite(response, request);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", e.getMessage());
			url = "error/error.jsp";
		}

		System.out.println(">>>>>>>>>>>>>>>>>>>>>> " + url + "으로 이동");
		if (url.startsWith("redirect:")) {// 경로가 redirect: 로 시작하면 sendRedirect로 이동.
			// redirect:url 이므로 url에서 redirect:를 제거후 이동
			response.sendRedirect(url.substring(url.indexOf(":") + 1));
		} else {// 경로가 redirect: 로 시작하지 않으면 기본적으로 forward로 이동.
			request.getRequestDispatcher(url).forward(request, response);
		}

	}

	private String updateMember(HttpServletResponse response, HttpServletRequest request) {
		String userid = request.getParameter("puID");
		String userpwd = request.getParameter("puPassword");
		String userpwdck = request.getParameter("puPasswordCheck");
		String useremail = request.getParameter("puEmailCheck");
		String username = request.getParameter("puName");
		String url = "index.jsp";
		

		
		if (userpwd.equals(userpwdck)) {
			try {
				loginService.update(userid, userpwd, username, useremail);
			} catch (Exception e) {
				request.setAttribute("updatemsg", e.getMessage());
			}
		} else {
			request.setAttribute("updatemsg", "비밀번호가 일치하지 않습니다.");
		}
		return url;
		
	}

	private String deleteMember(HttpServletResponse response, HttpServletRequest request) {
		String userid = request.getParameter("pdID");
		String userpwd = request.getParameter("pdPassword");
		String userpwdck = request.getParameter("pdPasswordCheck");
		
		System.out.println(userpwd);
		String url = "index.jsp";
		if (userpwd.equals(userpwdck)) {
			System.out.println("delete");
			try {
				loginService.delete(userid);
			} catch (Exception e) {
				request.setAttribute("deletemsg", e.getMessage());
			}
		} else {
			request.setAttribute("deletemsg", "비밀번호가 일치하지 않습니다.");
		}
		return url;
	}

	private String searchPost(HttpServletResponse response, HttpServletRequest request) {
		String path = "index.jsp";
		request.setAttribute("postlist", houseService.searchPost());
		return path;
	}

	private String searchAll(HttpServletResponse response, HttpServletRequest request) {
		String path = "index.jsp";
		String key = request.getParameter("key");
		String word = request.getParameter("value");
		int pageNo = 1;
		PageBean bean = new PageBean(key, word, pageNo);
		request.setAttribute("houselist", houseService.searchAll(bean));
		return path;
	}

	private String listMember(HttpServletResponse response, HttpServletRequest request) {
		String path = "index.jsp";
		try {
			List<MemberDto> lst = loginService.listMember();
			List<FavoriteDto> lstFavor = favoriteService.listFavorite();
			if (lst != null) {
				request.setAttribute("members", lst);
				request.setAttribute("favorites", lstFavor);
				request.setAttribute("move", "member");
			} else {
				request.setAttribute("listmsg", "등록된 회원 정보가 없습니다.");
			}
		} catch (Exception e) {
			request.setAttribute("listmsg", e.getMessage());
		}
		return path;
	}



	private String join(HttpServletRequest request, HttpServletResponse response) {
		String userid = request.getParameter("usrID");
		String userpwd = request.getParameter("usrPassword");
		String userpwdck = request.getParameter("usrPasswordCheck");
		String useremail = request.getParameter("usrEmailCheck");
		String username = request.getParameter("usrName");
		String url = "index.jsp";

		if (userpwd.equals(userpwdck)) {
			try {
				loginService.join(userid, userpwd, username, useremail);
			} catch (Exception e) {
				request.setAttribute("joinmsg", e.getMessage());
			}
		} else {
			request.setAttribute("joinmsg", "비밀번호가 일치하지 않습니다.");
		}
		return url;
	}

	private String logout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "index.jsp";
	}

	private String login(HttpServletRequest request, HttpServletResponse response) {
		String userid = request.getParameter("loginID");
		String userpwd = request.getParameter("loginPassword");

		String url = "index.jsp";
		try {
			MemberDto userInfo = loginService.login(userid, userpwd);
			if (userInfo.getUserid().equals(userid)) {
				if (userInfo.getUserpwd().equals(userpwd)) {
					HttpSession session = request.getSession();
					session.setAttribute("userinfo", userInfo);
					System.out.println("로그인 성공");
				} else {
					throw new Exception("틀린 비밀번호입니다.");
				}
			} else {
				throw new Exception("등록되지 않은 아이디입니다.");
			}
		} catch (Exception e) {
			request.setAttribute("msg", e.getMessage());
		}
		return url;
	}
	
	private String addFavorite(HttpServletResponse response, HttpServletRequest request) {

		String dong = request.getParameter("favdong");
		HttpSession session = request.getSession();
		MemberDto now = (MemberDto) session.getAttribute("userinfo");
		String url = "index.jsp";
		try {
			favoriteService.addFavorite(dong, now.getUserid());
		} catch (Exception e) {
			request.setAttribute("addFavMsg", e.getMessage());
		}
		return url;

	}

}
