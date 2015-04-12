package kr.ac.shinhan.csp;

import java.io.IOException;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class RegistMemberServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/plain");

		String name = req.getParameter("name");
		String hakId = req.getParameter("hakId");
		String phoneNum = req.getParameter("phoneNum");
		String mail = req.getParameter("mail");
		String kkoId = req.getParameter("kkoId");
		String gitId = req.getParameter("gitId");
		String leader;

		if (req.getParameter("leader") == null)
			leader = "ÆÀ¿ø";
		else
			leader = "ÆÀÀå";

		Member m = MemberManager.addMember(name, hakId, phoneNum, mail, kkoId,
				leader, gitId);
		// MemberManager.addMember(name, hakId, phoneNum, mail, kkoId, leader,gitId );

		resp.getWriter().println("<html>");
		resp.getWriter().println("<body><table>");
		resp.getWriter().println("<tr><td>Name</td><td>: " + m.getName() + "</td></tr>");
		resp.getWriter().println("<tr><td>Number</td><td>: " + m.getHakid() + "</td></tr>");
		resp.getWriter().println("<tr><td>Phone Number</td><td>: " + m.getPhoneNum() + "</td></tr>");
		resp.getWriter().println("<tr><td>E-Mail</td><td>: " + m.getMail() + "</td></tr>");
		resp.getWriter().println("<tr><td>Kakao ID</td><td>: " + m.getKkoId() + "</td></tr>");
		resp.getWriter().println("<tr><td>Leader Check</td><td>: " + m.getLeader() + "</td></tr>");
		resp.getWriter().println("<tr><td>GitHub ID</td><td>: " + m.getGitId() + "</td></tr>");
		
		
		resp.getWriter().println("</table>");
		resp.getWriter().println("<h4> <a href='/memberinfo'>MemberList</a> </h4>");
		resp.getWriter().println("</body></html>");

	}
}
