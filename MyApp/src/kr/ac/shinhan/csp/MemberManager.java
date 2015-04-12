package kr.ac.shinhan.csp;

import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class MemberManager {
	
	public static Member addMember(String name, String hakid, String phoneNum, String mail, String kkoId, String leader, String gitId)
	{
		PersistenceManager pm = JDOHelper.getPersistenceManagerFactory("transactions-optional").getPersistenceManager();
		Member m = new Member(name,hakid, phoneNum, mail, kkoId, leader, gitId);
		pm.makePersistent(m);
		
		return m;
	}
	
	public static Member getMember(String key)
	{
		PersistenceManager pm = JDOHelper.getPersistenceManagerFactory("transactions-optional").getPersistenceManager();
		Member m = pm.getObjectById(Member.class,key);
		
		return m;
	}
	
	public static void deleteMember(String key)
	{
		PersistenceManager pm = JDOHelper.getPersistenceManagerFactory("transactions-optional").getPersistenceManager();
		Member m = MemberManager.getMember(key);
		pm.deletePersistent(m);
	}
	
	public static List<Member> getMemberByName(String name)
	{
		PersistenceManager pm = JDOHelper.getPersistenceManagerFactory("transactions-optional").getPersistenceManager();
		Query qry = pm.newQuery(Member.class);
		qry.setFilter("name == nameParam");
		qry.declareParameters("String nameParam");
		
		@SuppressWarnings("unchecked")//오류시삭제
		List<Member> memberList = (List<Member>) qry.execute(name);
		
		return memberList;
	}
	
	public static List<Member> getAllMembers()
	{
		PersistenceManager pm = JDOHelper.getPersistenceManagerFactory("transactions-optional").getPersistenceManager();
		Query qry = pm.newQuery(Member.class);
		@SuppressWarnings("unchecked")//오류시 삭제 
		List<Member> memberList = (List<Member>) qry.execute();

		return memberList;
	}
}
