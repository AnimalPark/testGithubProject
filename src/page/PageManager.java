package page;

public class PageManager {
	private int requestPage;

	
	public int getRequestPage() {
		return requestPage;
	}

	public void setRequestPage(int requestPage) {
		this.requestPage = requestPage;
	}

	public PageManager() {
	}
	
	public PageManager(int requestPage) {
		this.requestPage = requestPage;
	}
	
	public PageRowResult getPageRowResult() {
		PageRowResult pageRowResult = new PageRowResult();
		pageRowResult.setRowStartNumber(PageInfo.ROW_COUNT_PRE_PAGE * (requestPage - 1) + 1);
		pageRowResult.setRowEndNumber(PageInfo.ROW_COUNT_PRE_PAGE * (requestPage));
		
		return pageRowResult;
	}
	public PageGroupResult getPageGroupResult() {
		PageGroupResult pageGroupResult = new PageGroupResult();
		int requestPageGroupNumber = ((requestPage-1)/PageInfo.SHOW_PAGE_COUNT) + 1;

		pageGroupResult.setGroupStartNumber((requestPageGroupNumber-1)*(PageInfo.SHOW_PAGE_COUNT)+1);
		pageGroupResult.setGroupEndNumber(requestPageGroupNumber*(PageInfo.SHOW_PAGE_COUNT));
		
		return pageGroupResult;
	}
	public static void main(String[] args) {
		PageManager p = new PageManager();
		for(int i = 1; i < 10 ; i++) {
			p.setRequestPage(i);
			System.out.print(p.getPageRowResult().getRowStartNumber()+" ");
			System.out.println(p.getPageRowResult().getRowEndNumber());
			System.out.println("===");
		}
	}
}
