package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Member;

public class MemberDAOImpl extends BaseDAO implements MemberDAO {
	private static final String MEMBER_SELECT_BY_ID_SQL = "SELECT * FROM MEMBER WHERE ID = ?";

	@Override
	public Member selectById(String id) {
		Member member = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(MEMBER_SELECT_BY_ID_SQL);
			preparedStatement.setString(1, id);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				member = new Member();
				member.setMemno(resultSet.getInt("MEMNO"));
				member.setId(resultSet.getString("ID"));
				member.setPwd(resultSet.getString("PWD"));
				member.setName(resultSet.getString("NAME"));
				member.setGender(resultSet.getString("GENDER"));
				member.setBirth(resultSet.getString("BIRTH"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeDBObjects(null, preparedStatement, connection);
		}
		return member;
	}
	
	
}
