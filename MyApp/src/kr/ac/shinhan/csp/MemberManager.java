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

	public static Member getMember(Long key) {
		PersistenceManager pm = JDOHelper.getPersistenceManagerFactory(
				"transactions-optional").getPersistenceManager();
		// long lkey = Long.parseLong(key);
		// Member m = pm.getObjectById(Member.class, lkey);
		Member m = pm.getObjectById(Member.class, key);
		return m;
	}

	public static void deleteMember(Long key) {
		PersistenceManager pm = JDOHelper.getPersistenceManagerFactory(
				"transactions-optional").getPersistenceManager();
		Member m = MemberManager.getMember(key);
		pm.deletePersistent(m);
	}

	public static List<Member> getMemberByName(String name) {
		PersistenceManager pm = JDOHelper.getPersistenceManagerFactory(
				"transactions-optional").getPersistenceManager();
		Query qry = pm.newQuery(Member.class);
		qry.setFilter("name == nameParam");
		qry.declareParameters("String nameParam");

		List<Member> memberList = (List<Member>) qry.execute(name);

		return memberList;
	}

	public static List<Member> getAllMembers() {
		PersistenceManager pm = JDOHelper.getPersistenceManagerFactory(
				"transactions-optional").getPersistenceManager();
		Query qry = pm.newQuery(Member.class);

		List<Member> memberList = (List<Member>) qry.execute();

		return memberList;
	}

	public static Member updateMember(Member newMember) {	//public static void updateMember(Member newMember)  
		PersistenceManager pm = JDOHelper.getPersistenceManagerFactory(
				"transactions-optional").getPersistenceManager();
		Member m = MemberManager.getMember(newMember.getId() );
		m.setName(newMember.getName());
		m.setHakid(newMember.getHakid());
		m.setPhoneNum(newMember.getPhoneNum());
		m.setMail(newMember.getMail());
		m.setLeader(newMember.getLeader());
		m.setKkoId(newMember.getKkoId());
		m.setGitId(newMember.getGitId());

		pm.close();
		
		return newMember;//return°ª¾øÀ½
	}

}
