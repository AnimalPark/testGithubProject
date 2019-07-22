package dao;

import java.util.List;

import model.Ybbs;

public interface YbbsDAO {
	public boolean insertNewPost(Ybbs y);
	public List<Ybbs> selectAll();
	public Ybbs selectByNo(int no);
	public void insertReply(Ybbs ybbs);
	
	void update(Ybbs ybbs);
	void delete(int no);
	
	public List<Ybbs> selectAll(int rowStartNumber, int rowEndNumber);
	
}
