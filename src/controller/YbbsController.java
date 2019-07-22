package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.YbbsDAOImpl;
import model.Member;
import model.Ybbs;
import page.PageInfo;
import page.PageManager;
import page.SQL;
import page.PageDAOImpl;

@WebServlet(name = "YbbsController", urlPatterns = { "/ybbs_insert", "/ybbs_content", "/ybbs_list.do", "/ybbs_read",
		"/ybbs_update", "/ybbs_delete", "/ybbs_reply", "/ybbs_reply_insert", "/page_print" })
public class YbbsController extends HttpServlet {
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
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex + 1);
		System.out.println(action);
		YbbsDAOImpl impl = null;
		PageDAOImpl pageimpl = null;
		Member m = null;
		Ybbs ybbs = null;
		List<Ybbs> list = null;

		req.setCharacterEncoding("utf-8");

		if (action.equals("ybbs_list.do")) {
			impl = new YbbsDAOImpl();
			list = impl.selectAll();
			req.setAttribute("list", list);
			RequestDispatcher rd = req.getRequestDispatcher("/list.jsp");
			rd.forward(req, resp);
		}
		// ±Û¾²±â
		else if (action.equals("ybbs_content")) {
			impl = new YbbsDAOImpl();

			ybbs = new Ybbs();
			ybbs.setId(req.getParameter("id"));
			ybbs.setSubject(req.getParameter("subject"));
			ybbs.setContent(req.getParameter("comment"));

			System.out.println(ybbs.toString());
			impl.insertNewPost(ybbs);
			resp.sendRedirect("/ybbs_list.do");
			
		} else if (action.equals("ybbs_insert")) {
			RequestDispatcher rd = req.getRequestDispatcher("/answer.jsp");
			rd.forward(req, resp);
		} else if (action.equals("ybbs_read")) {
			m = new Member();

			impl = new YbbsDAOImpl();
			int no = Integer.parseInt(req.getParameter("num"));
			ybbs = impl.selectByNo(no);
			String s = req.getParameter("sessionid");

			req.setAttribute("anwser", ybbs);
			if (s.equals(ybbs.getId())) {
				RequestDispatcher rd = req.getRequestDispatcher("/mycontent.jsp");
				rd.forward(req, resp);
			} else {
				RequestDispatcher rd = req.getRequestDispatcher("/content.jsp");
				rd.forward(req, resp);
			}
		} else if (action.equals("ybbs_update")) {
			impl = new YbbsDAOImpl();
			ybbs = new Ybbs();
			ybbs.setNo(Integer.parseInt(req.getParameter("updateno")));
			ybbs.setSubject(req.getParameter("subject"));
			ybbs.setContent(req.getParameter("content"));

			impl.update(ybbs);
			RequestDispatcher rd = req.getRequestDispatcher("/ybbs_list.do");
			rd.forward(req, resp);
		} else if (action.equals("ybbs_delete")) {
			impl = new YbbsDAOImpl();

			int no = Integer.parseInt(req.getParameter("deleteno"));
			impl.delete(no);

			RequestDispatcher rd = req.getRequestDispatcher("/ybbs_list.do");
			rd.forward(req, resp);

		} else if (action.equals("ybbs_reply")) {
			req.setAttribute("reno", req.getParameter("replyno"));
			req.setAttribute("g", req.getParameter("replygroup"));
			RequestDispatcher rd = req.getRequestDispatcher("/reply.jsp");
			rd.forward(req, resp);

		} else if (action.equals("ybbs_reply_insert")) {

			impl = new YbbsDAOImpl();
			ybbs = new Ybbs();

			ybbs.setSubject(req.getParameter("subject"));
			ybbs.setContent(req.getParameter("comment"));
			ybbs.setGroups(Integer.parseInt(req.getParameter("groups")));
			ybbs.setId(req.getParameter("id"));
			System.out.println(ybbs.toString());
			impl.insertReply(ybbs);

			resp.sendRedirect("/ybbs_list.do");
		} else if (action.equals("page_print")) {
			impl = new YbbsDAOImpl();
			pageimpl = new PageDAOImpl();
			
			int result = Integer.parseInt(req.getParameter("page"));
			PageManager p = new PageManager(result);
			
			list = impl.selectAll(p.getPageRowResult().getRowStartNumber(), p.getPageRowResult().getRowEndNumber());			
			int maxPage = (pageimpl.getCount(SQL.YBBS_CNT_SQL)-1)/PageInfo.ROW_COUNT_PRE_PAGE + 1;
			
			req.setAttribute("list", list);
			req.setAttribute("start", p.getPageGroupResult().getGroupStartNumber());
			req.setAttribute("end", p.getPageGroupResult().getGroupEndNumber());
			req.setAttribute("max", maxPage);
			req.setAttribute("current", result);
			
			RequestDispatcher rd = req.getRequestDispatcher("/page.jsp");
			rd.forward(req, resp);
			
		}
	}
}
