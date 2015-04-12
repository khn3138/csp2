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
		resp.getWriter().println("<td>이름</td> <td>학번</td><td>전화번호</td>");
		resp.getWriter().println("<td>메일</td> <td>카톡</td><td>팀장여부</td>");
		resp.getWriter().println("<td>Github ID</td> <td>삭제?</td>");
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