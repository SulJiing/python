package kr.co.aiai.ibatis;

import java.io.IOException;
import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class MySqlMapper {
	private static SqlMapClient sqlMapper;

	static {
		try {
			Reader reader = Resources
					.getResourceAsReader("kr/co/aiai/ibatis/SqlMapConfig.xml");
			sqlMapper = SqlMapClientBuilder.buildSqlMapClient(reader);
			reader.close();
		} catch (IOException e) {
			throw new RuntimeException("iBatis instance Error:" + e, e);
		}
	}

	public static SqlMapClient getSqlMapper() {
		return sqlMapper;
	}
}
