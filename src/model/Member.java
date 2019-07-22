package model;


public class Member {
	private int memno;
    private String id;
    private String pwd;
    private String name;
    private String gender;
    private String birth;
	public int getMemno() {
		return memno;
	}
	public void setMemno(int memno) {
		this.memno = memno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	@Override
	public String toString() {
		return "Member [memNo=" + memno + ", id=" + id + ", pwd=" + pwd + ", name=" + name + ", gender=" + gender
				+ ", birth=" + birth + "]";
	}
}
