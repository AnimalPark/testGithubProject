package dao;

import model.Member;

public interface MemberDAO {
	public Member selectById(String id);
}
