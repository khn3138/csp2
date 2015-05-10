package kr.ac.shinhan.csp;

import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;

public class MemberManager {

	public static Member addMember(String name, String hakId, String phoneNum,
			String mail, String kkoId, String leader, String gitId) {
		PersistenceManager pm = JDOHelper.getPersistenceManagerFactory(
				"transactions-optional").getPersistenceManager();
		Member m = new Member(name, hakId, phoneNum, mail, kkoId, leader, gitId);
		pm.makePersistent(m);

		return m;
	}

	public static Member getMember(String key) {
		PersistenceManager pm = JDOHelper.getPersistenceManagerFactory(
				"transactions-optional").getPersistenceManager();
		Long lkey = Long.parseLong(key);
		Member m = pm.getObjectById(Member.class, lkey);
		//Member m = pm.getObjectById(Member.class, key);
		pm.close();
		return m;
	}

	public static void deleteMember(String key) {
		PersistenceManager pm = JDOHelper.getPersistenceManagerFactory(
				"transactions-optional").getPersistenceManager();
		Long lkey = Long.parseLong(key);
		Member m = pm.getObjectById(Member.class, lkey);
		pm.deletePersistent(m);
		pm.close();
	}

	@SuppressWarnings("unchecked")
	public static List<Member> getMemberByName(String name) {
		PersistenceManager pm = JDOHelper.getPersistenceManagerFactory(
				"transactions-optional").getPersistenceManager();
		Query qry = pm.newQuery(Member.class);
		qry.setFilter("name == nameParam");
		qry.declareParameters("String nameParam");

		List<Member> memberList = (List<Member>) qry.execute(name);

		return memberList;
	}

	@SuppressWarnings("unchecked")
	public static List<Member> getAllMembers() {
		PersistenceManager pm = JDOHelper.getPersistenceManagerFactory(
				"transactions-optional").getPersistenceManager();
		Query qry = pm.newQuery(Member.class);

		List<Member> memberList = (List<Member>) qry.execute();

		return memberList;
	}

	
	
	public static void updateMember(String key, String name, String hakId, String phoneNum, String mail, String leader, String kkoId, String gitId) {	//public static void updateMember(Member newMember)  

		//Member m = pm.getObjectById(Member.class, newMember);
		Long lkey = Long.parseLong(key);
		
		PersistenceManager pm = JDOHelper.getPersistenceManagerFactory(
				"transactions-optional").getPersistenceManager();
		Member m = pm.getObjectById(Member.class, lkey);
		


		m.setName(name);
		m.setHakId(hakId);
		m.setPhoneNum(phoneNum);
		m.setMail(mail);
		m.setLeader(leader);
		m.setKkoId(kkoId);
		m.setGitId(gitId);

		pm.close();
		
		//return°ª¾øÀ½
	}

}
