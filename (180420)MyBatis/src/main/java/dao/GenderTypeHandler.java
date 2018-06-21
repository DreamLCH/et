package dao;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

public class GenderTypeHandler extends BaseTypeHandler<String> {

	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType)
			throws SQLException {
		ps.setInt(i, parameter.equals("男")?1:2);
		
	}

	@Override
	public String getNullableResult(ResultSet rs, String columnName) throws SQLException {
		int result = rs.getInt(columnName);
		return result == 1?"男":"女";
	}

	@Override
	public String getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		int result = rs.getInt(columnIndex);
		return result == 1?"男":"女";
	}

	@Override
	public String getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
