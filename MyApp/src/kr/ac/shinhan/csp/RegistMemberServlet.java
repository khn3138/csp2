package kr.ac.shinhan.csp;

import java.io.IOException;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class RegistMemberServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {

		String name = req.getParameter("name");
		String hakId = req.getParameter("hakId");
		String phoneNum = req.getParameter("phoneNum");
		String mail = req.getParameter("mail");
		String kkoId = req.getParameter("kkoId");
		String gitId = req.getParameter("gitId");
		String leader;
		
		if(req.getParameter("leader") == null)
			leader = "∆¿ø¯";
		else
			leader = "∆¿¿Â";
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/plain");
		
		Member m = MemberManager.addMember(name, hakId, phoneNum, mail, kkoId, leader, gitId );
		
		resp.getWriter().println("<html>");
		resp.getWriter().println("<body>");
		resp.getWriter().println("¿Ã∏ß : "+m.getName() +"<br>");
		resp.getWriter().println("¡÷πŒπ¯»£ : "+m.getHakid() +"<br>");
		resp.getWriter().println("∞¥√º ≈∞ : "+m.getId() +"<br>");
		
		resp.getWriter().println("</body>");
		resp.getWriter().println("</html>");
	}
}
