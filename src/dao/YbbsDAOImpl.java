package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Ybbs;

public class YbbsDAOImpl extends BaseDAO implements YbbsDAO {
	private static final String YBBS_INSERT_SQL = "INSERT INTO YBBS VALUES (SEQ_YBBS.NEXTVAL , ?, ? "
			+ ",SYSDATE ,SEQ_YBBS.CURRVAL ,0 ,0 ,?)"; 
	private static final String YBBS_REPLY_INSERT_SQL = "INSERT INTO YBBS VALUES (SEQ_YBBS.NEXTVAL , ?, ? "
			+ ",SYSDATE ,? ,1 ,0 ,?)"; 
	private static final String YBBS_LIST_SQL = "SELECT NO, GROUPS, SUBJECT, CONTENT, LEVELS, NAME, WDATE, VISITED " + 
			"FROM YBBS NATURAL JOIN MEMBER " + 
			"ORDER BY GROUPS DESC, " + 
			"         LEVELS ASC, " + 
			"         WDATE DESC ";
	private static final String YBBS_BY_NO_SQL = "SELECT * FROM YBBS NATURAL JOIN MEMBER WHERE NO = ?"; 
	private static final String YBBS_UPDATE_SQL = "UPDATE YBBS SET SUBJECT = ?, CONTENT = ?, VISITED = ? WHERE NO = ?";
	private static final String YBBS_DELETE_BY_NO_SQL = "DELETE FROM YBBS WHERE NO = ?";
	private static final String YBBS_VISITED_UPDATE_SQL = "UPDATE YBBS SET VISITED = ? WHERE NO = ?";
	private static final String YBBS_PAGE_SELECT_SQL = 	"SELECT * FROM (SELECT ROWNUM RN, COMMENTS.* FROM "
													  + "(SELECT * FROM YBBS ORDER BY NO DESC) COMMENTS) " + 
														"WHERE RN BETWEEN ? AND ?";
	
	
	@Override
	public boolean insertNewPost(Ybbs y) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		boolean result = false;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(YBBS_INSERT_SQL);
			preparedStatement.setString(1, y.getSubject());
			preparedStatement.setString(2, y.getContent());
			preparedStatement.setString(3, y.getId());
			int chk = preparedStatement.executeUpdate();
			if (chk != 0)
				result = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeDBObjects(null, preparedStatement, connection);
		}
		return result;
	}
	@Override
	public List<Ybbs> selectAll() {
		List<Ybbs> list = new ArrayList<Ybbs>();
		Ybbs ybbs = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(YBBS_LIST_SQL);
			resultSet = preparedStatement.executeQuery();
			//NO, SUBJECT, CONTENT, NAME, WDATE, VISITED
			while (resultSet.next()) {
				ybbs = new Ybbs();
				ybbs.setNo(resultSet.getInt("NO"));
				ybbs.setGroups(resultSet.getInt("GROUPS"));
				ybbs.setSubject(resultSet.getString("SUBJECT"));
				ybbs.setContent(resultSet.getString("CONTENT"));
				ybbs.setLevels(Integer.parseInt(resultSet.getString("LEVELS")));
				ybbs.setName(resultSet.getString("NAME"));
				ybbs.setWdate(resultSet.getString("WDATE"));
				ybbs.setVisited(resultSet.getInt("VISITED"));
				list.add(ybbs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeDBObjects(null, preparedStatement, connection);
		}
		return list;
	}
	@Override
	public Ybbs selectByNo(int no) {
		Ybbs ybbs = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(YBBS_BY_NO_SQL);
			preparedStatement.setInt(1, no);
			resultSet = preparedStatement.executeQuery();
			//NO, SUBJECT, CONTENT, NAME, WDATE, VISITED
			while (resultSet.next()) {
				ybbs = new Ybbs();
				ybbs.setNo(resultSet.getInt("NO"));
				ybbs.setGroups(resultSet.getInt("GROUPS"));
				ybbs.setSubject(resultSet.getString("SUBJECT"));
				ybbs.setContent(resultSet.getString("CONTENT"));
				ybbs.setId(resultSet.getString("ID"));
				ybbs.setName(resultSet.getString("NAME"));
				ybbs.setWdate(resultSet.getString("WDATE"));
				ybbs.setVisited(resultSet.getInt("VISITED"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeDBObjects(null, preparedStatement, connection);
		}
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(YBBS_VISITED_UPDATE_SQL);
			preparedStatement.setInt(1, (ybbs.getVisited()+1));
			preparedStatement.setInt(2, no);
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeDBObjects(null, preparedStatement, connection);
		}
		return ybbs;
	}
	@Override
	public void insertReply(Ybbs ybbs) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(YBBS_REPLY_INSERT_SQL);
			preparedStatement.setString(1, ybbs.getSubject());
			preparedStatement.setString(2, ybbs.getContent());
			preparedStatement.setInt(3, ybbs.getGroups());
			preparedStatement.setString(4, ybbs.getId());
			preparedStatement.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeDBObjects(null, preparedStatement, connection);
		}
		return ;
	}
	@Override
	public void update(Ybbs ybbs) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(YBBS_UPDATE_SQL);
			preparedStatement.setString(1, ybbs.getSubject());
			preparedStatement.setString(2, ybbs.getContent());
			preparedStatement.setInt(3, ybbs.getVisited());
			preparedStatement.setInt(4, ybbs.getNo());
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeDBObjects(null, preparedStatement, connection);
		}
		return ;
	}
	@Override
	public void delete(int no) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(YBBS_DELETE_BY_NO_SQL);
			preparedStatement.setInt(1, no);
			preparedStatement.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeDBObjects(resultSet, preparedStatement, connection);
		}
		return ;
	}
	@Override
	public List<Ybbs> selectAll(int rowStartNumber, int rowEndNumber) {
		Ybbs ybbs = null;
		List<Ybbs> list = new ArrayList<Ybbs>();

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(YBBS_PAGE_SELECT_SQL);
			preparedStatement.setInt(1, rowStartNumber);
			preparedStatement.setInt(2, rowEndNumber);
			resultSet = preparedStatement.executeQuery();
			//NO, SUBJECT, CONTENT, NAME, WDATE, VISITED
			while (resultSet.next()) {
				ybbs = new Ybbs();
				ybbs.setNo(resultSet.getInt("NO"));
				ybbs.setGroups(resultSet.getInt("GROUPS"));
				ybbs.setSubject(resultSet.getString("SUBJECT"));
				ybbs.setContent(resultSet.getString("CONTENT"));
				ybbs.setId(resultSet.getString("ID"));
				ybbs.setLevels(resultSet.getInt("LEVELS"));
				ybbs.setWdate(resultSet.getString("WDATE"));
				ybbs.setVisited(resultSet.getInt("VISITED"));
				list.add(ybbs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeDBObjects(null, preparedStatement, connection);
		}
		
		return list;
	}
	
}
