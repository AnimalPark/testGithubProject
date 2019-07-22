package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.catalina.tribes.membership.MemberImpl;

import dao.MemberDAOImpl;
import model.Member;

import javax.servlet.annotation.*;

@WebServlet(name = "MemberController", urlPatterns = { "/login_input", "/login", "/logout" })

public class MemberController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(req, resp);
	}

	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();
		System.out.println(uri);
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex + 1);
		System.out.println(action);
		MemberDAOImpl impl = null;
		String message = null;
		boolean chk = false;

		req.setCharacterEncoding("utf-8");

		if (action.equals("login")) {
			impl = new MemberDAOImpl();
			if (req.getParameter("id") != "") {
				if (req.getParameter("pwd") != "") {
					String id = req.getParameter("id");
					String pwd = req.getParameter("pwd");

					Member m = impl.selectById(id);
					System.out.println(m.toString());

					if (m.getId().equals(id) && m.getPwd().equals(pwd))
						chk = true;

					if (chk) {
						HttpSession session = req.getSession();
						session.setAttribute("memberInfo", m);
						req.setAttribute("msg", message);
						RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
						rd.forward(req, resp);
					} else {
						message = "로그인에 실패했습니다.";
						req.setAttribute("msg", message);
						RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
						rd.forward(req, resp);
					}
				}
				else {
					message = "비밀번호를 입력해주세요";
					req.setAttribute("msg", message);
					RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
					rd.forward(req, resp);
				}
			} else {
				message = "아이디를 입력해주세요";
				req.setAttribute("msg", message);
				RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
				rd.forward(req, resp);
			}
		}
		else if (action.equals("login_input")) {
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			rd.forward(req, resp);
		}

		else if (action.equals("logout")) {
			HttpSession session = req.getSession();
			session.removeAttribute("memberInfo");

			System.out.println("===" + session.getAttribute("memberInfo") + "===");
			message = "로그아웃 하셨습니다.";
			req.setAttribute("msg", message);

			RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
			rd.forward(req, resp);
		}
	}
}
