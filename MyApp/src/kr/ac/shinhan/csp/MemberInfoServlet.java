package kr.ac.shinhan.csp;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class MemberInfoServlet extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		
		
		 List<Member> memberList = MemberManager.getAllMembers();
		
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/plain"); 
		
		resp.getWriter().println("<html>");
		resp.getWriter().println("<body><table>");
		
		resp.getWriter().println("<tr>");
		resp.getWriter().println("<td>�̸�</td> <td>�й�</td><td>��ȭ��ȣ</td>");
		resp.getWriter().println("<td>����</td> <td>ī��</td><td>���忩��</td>");
		resp.getWriter().println("<td>Github ID</td> <td>����?</td>");
		resp.getWriter().println("</tr>");
		/*
		 List<Member> memberList = MemberManager.getAllMembers();
		
		resp.getWriter().println("<HTML>");
		resp.getWriter().println("<body>");
		resp.getWriter().println("<table border = 1>");
		for(Member m :memberList)
		{
			resp.getWriter().println("<tr>");
			resp.getWriter().println("<td>"+"<a href = '/ReadMemberServlet?name="+m.getName()+"'>"+m.getName()+"</a>"+"</td><td>"+m.getSocialNumber()+"</td>");
			resp.getWriter().println("</tr>");
		}
		resp.getWriter().println("</table border = 1>");
		resp.getWriter().println("</body>");
		resp.getWriter().println("</HTML>");
		 
		 
		 */
		for(Member m :memberList){
		resp.getWriter().println("<tr>");
		resp.getWriter().println("<td>"+m.getName() +"</td>");
		resp.getWriter().println("<td> "+m.getHakid() +"</td>");
		resp.getWriter().println("<td> "+m.getPhoneNum() +"</td>");
		resp.getWriter().println("<td> "+m.getMail() +"</td>");
		resp.getWriter().println("<td> "+m.getKkoId() +"</td>");
		resp.getWriter().println("<td> "+m.getLeader() +"</td>");
		resp.getWriter().println("<td> "+m.getGitId() +"</td>");
		resp.getWriter().println("<td>"+m.getHakid() +"</td>");
		resp.getWriter().println("</tr>");		
		
		}
		
		resp.getWriter().println("</table>");
		resp.getWriter().println("</body>");
		resp.getWriter().println("</html>");
		
	}
}