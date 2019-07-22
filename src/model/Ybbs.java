package model;

public class Ybbs {
	private String subject;
    private String content;
    private String wdate;
    private int groups;
    private int levels;
    private int visited;
    private String id;
	private int no;
	private String name;
    public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWdate() {
		return wdate;
	}
	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	public int getGroups() {
		return groups;
	}
	public void setGroups(int groups) {
		this.groups = groups;
	}
	public int getLevels() {
		return levels;
	}
	public void setLevels(int levels) {
		this.levels = levels;
	}
	
	public int getVisited() {
		return visited;
	}
	public void setVisited(int visited) {
		this.visited = visited;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Ybbs [subject=" + subject + ", content=" + content + ", wdate=" + wdate + ", groups=" + groups
				+ ", levels=" + levels + ", visited=" + visited + ", id=" + id + ", no=" + no + ", name=" + name + "]";
	}
	
	
	
}
