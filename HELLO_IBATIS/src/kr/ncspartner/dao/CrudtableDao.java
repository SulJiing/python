package kr.ncspartner.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Update;

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
		
		// selectList
		/*ArrayList<Crudtable> list = (ArrayList<Crudtable>) dao.selectList();
		for(int i =0;i<list.size();i++) {
			Crudtable temp = list.get(i);
			System.out.print(temp.getCrud_id()+"	");
			System.out.print(temp.getCrud_name()+"	");
			System.out.print(temp.getMobile()+"	");*/
		
		// select
		/*Crudtable ct = dao.select(1);
		System.out.println(ct.getCrud_id());
		System.out.println(ct.getCrud_name());
		System.out.println(ct.getMobile());*/
		
		// insert
		/*Crudtable vo = new Crudtable();
		vo.setCrud_name("1");
		vo.setMobile("1");
		int cnt = dao.insert(vo);
		System.out.println("cnt : "cnt);*/
		
		// update
		/*Crudtable vo = new Crudtable();
		vo.setCrud_name("5");
		vo.setMobile("5");
		vo.setCrud_id(1);
		int cnt = dao.update(vo);
		System.out.println(cnt);*/
		
		// delete
		/*int cnt = dao.delete("1");
		System.out.println(cnt);*/
		}
	}
