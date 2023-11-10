package kr.co.aiai.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.co.aiai.ibatis.MySqlMapper;
import kr.co.aiai.model.Emp;

public class EmpDao {
	private static SqlMapClient sqlMapper;

	public EmpDao() {
		sqlMapper = MySqlMapper.getSqlMapper();
	}

	public List<Emp> selectList() throws SQLException {
		return sqlMapper.queryForList("selectList");
	}
	
	public Emp select(String e_id) throws SQLException {
		return (Emp) sqlMapper.queryForObject("select", e_id);
	}
	
	public int insert(Emp vo) throws SQLException {
		return sqlMapper.update("insert", vo);
	}
	
	public int update(Emp vo) throws SQLException {
		return sqlMapper.update("update", vo);
	}
	public int delete(String e_id) throws SQLException {
		return sqlMapper.update("delete", e_id);
	}

	public static void main(String[] args) throws SQLException {
		EmpDao dao = new EmpDao();
		List<Emp> list = dao.selectList();
		System.out.println(list.size());
	}
}



























