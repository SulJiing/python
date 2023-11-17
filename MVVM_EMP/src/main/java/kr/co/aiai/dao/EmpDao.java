package kr.co.aiai.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.co.aiai.ibatis.MySqlMapper;
import kr.co.aiai.vo.EmpVO;

public class EmpDao {
	private static SqlMapClient sqlMapper;

	public EmpDao() {
		sqlMapper = MySqlMapper.getSqlMapper();
	}

	public List<EmpVO> selectList() throws SQLException {
		return sqlMapper.queryForList("selectList");
	}
	
	public EmpVO select(String e_id) throws SQLException {
		return (EmpVO) sqlMapper.queryForObject("select",e_id);
	}
	
	public int insert (EmpVO vo) throws SQLException {
		return sqlMapper.update("insert",vo);
	}
	
	public int update (EmpVO e_id) throws SQLException {
		return sqlMapper.update("update",e_id);
	}

	public int delete (String vo) throws SQLException {
		return sqlMapper.update("delete",vo);
	}
	
	public static void main(String[] args) throws SQLException {
		EmpDao dao = new EmpDao();
		ArrayList<EmpVO> list = (ArrayList<EmpVO>) dao.selectList();
		System.out.println(list.size());
	}
}
