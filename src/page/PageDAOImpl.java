package page;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.BaseDAO;

public class PageDAOImpl extends BaseDAO implements PageDAO {
	 
	@Override
	public int getCount(String sql) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		int i = 0;
		try {
			connection = getConnection();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				i = resultSet.getInt("CNT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeDBObjects(resultSet, preparedStatement, connection);
		}
		return i;
	}

}

