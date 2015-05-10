package kr.ac.shinhan.csp;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class DeleteMemberServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/plain");
		 
		
		MemberManager.deleteMember(req.getParameter("key"));
		//MemberManager.addMember(name, hakId, phoneNum, mail, kkoId, leader,gitId );

		resp.getWriter().println("<html><body>");
		resp.getWriter().println("<h4>Delete Success</h4>");
		resp.getWriter().println("<h4> <a href='/memberinfo'>MemberList</a> </h4>");
		resp.getWriter().println("</body></html>");

	}

}
