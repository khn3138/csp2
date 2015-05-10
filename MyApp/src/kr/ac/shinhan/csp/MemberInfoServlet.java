package kr.ac.shinhan.csp;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class MemberInfoServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
	
		List<Member> memberList = MemberManager.getAllMembers();

		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/plain");

		resp.getWriter().println("<html>");
		//resp.getWriter().println("<body><table border = 1 align='center' bordercolor='gray' >");
		resp.getWriter().println("<body><table border = 1  bordercolor='gray' >");
		resp.getWriter().println("<tr bgcolor='gray'>");
		resp.getWriter().println("<td>Name</td> <td>Num</td><td>P.Num</td>");
		resp.getWriter().println("<td>E-mail</td> <td>Kakao ID</td><td>Leader Check</td>");
		resp.getWriter().println("<td>Github ID</td> <td>...</td>");
		resp.getWriter().println("</tr>");
		
		for (Member m : memberList) {
			resp.getWriter().println("<tr>");
			//resp.getWriter().println("<td>" + m.getName() + "</td>");
			resp.getWriter().println("<td><a href=/updateinput?key=" + m.getId() + ">" + m.getName() + "</a></td>");
			//resp.getWriter().println("<td><a href='updatemember.html?key=" + m.getId() + "'>" + m.getName() + "</a></td>");
			resp.getWriter().println("<td> " + m.getHakId() + "</td>");
			resp.getWriter().println("<td> " + m.getPhoneNum() + "</td>");
			resp.getWriter().println("<td> " + m.getMail() + "</td>");
			resp.getWriter().println("<td> " + m.getKkoId() + "</td>");
			resp.getWriter().println("<td> " + m.getLeader() + "</td>");
			resp.getWriter().println("<td> " + m.getGitId() + "</td>");
			
			resp.getWriter().println("<td><a href='/deletemember?key=" + m.getId() + "'>delete</a></td>");//<a href='/deletemember'>delete</a>
			
			resp.getWriter().println("</tr>");

		}
		
		resp.getWriter().println("</table>");
		
		resp.getWriter().println("<h3><a href='index.html'>Home</a></h3>");
		resp.getWriter().println("</body>");
		resp.getWriter().println("</html>");

	}
}

/*
 * List<Member> memberList = MemberManager.getAllMembers();
 * 
 * resp.getWriter().println("<HTML>"); resp.getWriter().println("<body>");
 * resp.getWriter().println("<table border = 1>"); for(Member m :memberList) {
 * resp.getWriter().println("<tr>");
 * resp.getWriter().println("<td>"+"<a href = '/ReadMemberServlet?name="
 * +m.getName
 * ()+"'>"+m.getName()+"</a>"+"</td><td>"+m.getSocialNumber()+"</td>");
 * resp.getWriter().println("</tr>"); }
 * resp.getWriter().println("</table border = 1>");
 * resp.getWriter().println("</body>"); resp.getWriter().println("</HTML>");
 */