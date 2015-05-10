package kr.ac.shinhan.csp;

import java.io.IOException;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class UpdateMemberServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		
		String key  = req.getParameter("key");
		Long lkey = Long.parseLong(key);
		
		String name = req.getParameter("name");
		String hakId = req.getParameter("hakId");
		String phoneNum = req.getParameter("phoneNum");
		String mail = req.getParameter("mail");
		String kkoId = req.getParameter("kkoId");
		String gitId = req.getParameter("gitId");
		String leader ;

		if (req.getParameter("leader") == null)
			leader = "ÆÀ¿ø";
		else
			leader = "ÆÀÀå";
	
		MemberManager.updateMember(key, name, hakId, phoneNum, mail, kkoId, gitId, leader);

		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/plain");
		
		resp.getWriter().println("<html>");
		resp.getWriter().println("<body> <h5> ¼öÁ¤¿Ï·á!</h5> <table>");
		
		resp.getWriter().println("<tr><td>Name</td><td>: " + name + "</td></tr>");
		resp.getWriter().println("<tr><td>Number</td><td>: " + hakId + "</td></tr>");
		resp.getWriter().println("<tr><td>Phone Number</td><td>: " + phoneNum + "</td></tr>");
		resp.getWriter().println("<tr><td>E-Mail</td><td>: " + mail + "</td></tr>");
		resp.getWriter().println("<tr><td>Kakao ID</td><td>: " + kkoId + "</td></tr>");
		resp.getWriter().println("<tr><td>Leader Check</td><td>: " + leader + "</td></tr>");
		resp.getWriter().println("<tr><td>GitHub ID</td><td>: " + gitId + "</td></tr>");
		resp.getWriter().println("</table>");
		resp.getWriter().println("<h4> <a href='/memberinfo'>MemberList</a> </h4>");
		resp.getWriter().println("</body></html>");
		
	}

}
