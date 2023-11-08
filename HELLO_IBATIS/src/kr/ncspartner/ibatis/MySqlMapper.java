package kr.ncspartner.ibatis;

import java.io.IOException;
import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class MySqlMapper {
	private static SqlMapClient sqlMapper;

	static {
		try {
			// 설정파일이 있는 위치 잘~~~~~
			Reader reader = Resources
					.getResourceAsReader("kr/ncspartner/ibatis/SqlMapConfig.xml");
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
