package kr.ncspartner.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.ncspartner.ibatis.MySqlMapper;
import kr.ncspartner.model.Crudtable;

public class CrudtableDao {
	private static SqlMapClient sqlMapper;

	public CrudtableDao() {
		sqlMapper = MySqlMapper.getSqlMapper();
	}

	public List<Crudtable> selectList() throws SQLException {
		return sqlMapper.queryForList("selectList");
	}

	public Crudtable select(int crud_id) throws SQLException {
		return (Crudtable) sqlMapper.queryForObject("select", crud_id);
	}

	public int insert(Crudtable st) throws SQLException {
		return sqlMapper.update("insert", st);
	}

	public int update(Crudtable st) throws SQLException {
		return sqlMapper.update("update", st);
	}

	public int delete(String col1) throws SQLException {
		return sqlMapper.update("delete", col1);
	}

	public static void main(String[] args) throws SQLException {
		CrudtableDao dao = new CrudtableDao();
		
		ArrayList<Crudtable> list = (ArrayList<Crudtable>) dao.selectList();
		for(int i =0;i<list.size();i++) {
			Crudtable temp = list.get(i);
			System.out.print(temp.getCrud_id()+"	");
			System.out.print(temp.getCrud_name()+"	");
			System.out.print(temp.getMobile()+"	");
		}
	}
}