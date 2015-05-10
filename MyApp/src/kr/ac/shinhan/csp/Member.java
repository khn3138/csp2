package kr.ac.shinhan.csp;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Member {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long key;

	@Persistent
	private String name;
	@Persistent
	private String hakId;
	@Persistent
	private String phoneNum;
	@Persistent
	private String mail;
	@Persistent
	private String kkoId;
	@Persistent
	private String leader;
	@Persistent
	private String gitId;

	public Member(String name, String hakId, String phoneNum, String mail,
			String kkoId, String leader, String gitId) {
		super();
		this.name = name;
		this.hakId = hakId;
		this.phoneNum = phoneNum;
		this.mail = mail;
		this.kkoId = kkoId;
		this.leader = leader;
		this.gitId = gitId;
	}

	public String getLeader() {
		return leader;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHakId() {
		return hakId;
	}

	public void setHakId(String hakId) {
		this.hakId = hakId;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getKkoId() {
		return kkoId;
	}

	public void setKkoId(String kkoId) {
		this.kkoId = kkoId;
	}

	public String getGitId() {
		return gitId;
	}

	public void setGitId(String gitId) {
		this.gitId = gitId;
	}

	public Long getId() {
		return key;
	}

}
