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
			leader = "팀원";
		else
			leader = "팀장";

		Member m = MemberManager.addMember(name, hakId, phoneNum, mail, kkoId,
				leader, gitId);
		// MemberManager.addMember(name, hakId, phoneNum, mail, kkoId, leader,gitId );

		resp.getWriter().println("<html>");
		resp.getWriter().println("<body><table>");
		resp.getWriter().println("<tr><td>이름  </td><td>: " + m.getName() + "</td></tr>");
		resp.getWriter().println("<tr><td>학번  </td><td>: " + m.getHakid() + "</td></tr>");
		resp.getWriter().println("<tr><td>전화번호  </td><td>: " + m.getPhoneNum() + "</td></tr>");
		resp.getWriter().println("<tr><td>메일주소  </td><td>: " + m.getMail() + "</td></tr>");
		resp.getWriter().println("<tr><td>카카오 아이디  </td><td>: " + m.getKkoId() + "</td></tr>");
		resp.getWriter().println("<tr><td>팀장여부  </td><td>: " + m.getLeader() + "</td></tr>");
		resp.getWriter().println("<tr><td>GitHub 아이디  </td><td>: " + m.getGitId() + "</td></tr>");
		resp.getWriter().println("</table></body>");
		resp.getWriter().println("</html>");

	}
}
