package page;

public class PageGroupResult {
	private int groupStartNumber;  //����Ʈ ���� ������ �� 
	private int groupEndNumber;	//����Ʈ ������ ������ ��
	
	boolean beforePage;
	boolean afterPage;
	
	public int getGroupStartNumber() {
		return groupStartNumber;
	}
	public void setGroupStartNumber(int groupStartNumber) {
		this.groupStartNumber = groupStartNumber;
	}
	public int getGroupEndNumber() {
		return groupEndNumber;
	}
	public void setGroupEndNumber(int groupEndNumber) {
		this.groupEndNumber = groupEndNumber;
	}
	public boolean isBeforePage() {
		return beforePage;
	}
	public void setBeforePage(boolean beforePage) {
		this.beforePage = beforePage;
	}
	public boolean isAfterPage() {
		return afterPage;
	}
	public void setAfterPage(boolean afterPage) {
		this.afterPage = afterPage;
	}

}
