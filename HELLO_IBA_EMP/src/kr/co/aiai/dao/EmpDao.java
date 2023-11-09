package kr.co.aiai.dao;

import java.sql.SQLException;
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
	
	public Emp select(int e_id) throws SQLException {
		return (Emp) sqlMapper.queryForObject("select",e_id);
	}
	
	public int insert (Emp vo) throws SQLException {
		return sqlMapper.update("insert",vo);
	}
	
	public int update (Emp e_id) throws SQLException {
		return sqlMapper.update("update",e_id);
	}

	public int delete (String vo) throws SQLException {
		return sqlMapper.update("delete",vo);
	}
	
	public static void main(String[] args) throws SQLException {
		EmpDao dao = new EmpDao();
		/*List<Emp> list = dao.selectList();
		for (int i = 0; i < list.size(); i++) {
			Emp vo = list.get(i);
			System.out.print(vo.getE_id() + "	");
			System.out.print(vo.getE_name() + "	");
			System.out.print(vo.getGen() + "	");
			System.out.println(vo.getAddr() + "	");
		}*/
		
		/*Emp vo = dao.select(1); 
		System.out.println(vo.getE_id());
		System.out.println(vo.getE_name());
		System.out.println(vo.getGen());
		System.out.println(vo.getAddr());*/
		
		/*Emp vo = new Emp();
		vo.setE_id("6");
		vo.setE_name("6");
		vo.setGen("6");
		vo.setAddr("6");
		int cnt = dao.insert(vo);
		System.out.println(cnt);*/
		
		/*Emp vo = new Emp();
		vo.setE_id("6");
		vo.setE_name("9");
		vo.setGen("9");
		vo.setAddr("9");
		int cnt = dao.update(vo);
		System.out.println(cnt);*/
		
		/*int cnt = dao.delete("6");
		System.out.println(cnt);*/
	}
}
