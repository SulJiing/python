package kr.co.aiai.util;

import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import kr.co.aiai.vo.EmpVO;
// Json으로 바꿔주는 util
public class AjaxUtil {
	
	public static void responseXml(HttpServletResponse response, String resultStr) throws Exception {
		response.setContentType("application/xml");
		PrintWriter out = response.getWriter();
		out.print(resultStr);
		out.flush();
		out.close();
	}

	public static void responseJson(HttpServletResponse response, List list) throws Exception {
		String result = new ObjectMapper().writeValueAsString(list);
		response.setContentType("text/javascript;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(result);
		out.flush();
		out.close();
	}

	public static void responseJson(HttpServletResponse response, String resultStr) throws Exception {
		String result = new ObjectMapper().writeValueAsString(resultStr);
		response.setContentType("text/javascript;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(result);
		out.flush();
		out.close();
	}

	public static void responseStr(HttpServletResponse response, String resultStr) throws Exception {
		String result = resultStr;
		response.setContentType("text/javascript;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(result);
		out.flush();
		out.close();
	}

	public static void responseJson(HttpServletResponse response, Map map) throws Exception {
		String result = new ObjectMapper().writeValueAsString(map);
		response.setContentType("text/javascript;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(result);
		out.flush();
		out.close();
	}
	
	public static Map<String, Object> vo2map(EmpVO abc) throws Exception {
		Map<String, Object> map = new HashMap();

		Field[] fields = abc.getClass().getDeclaredFields();

		for (Field field : fields) {
			String filedName = field.getName();
			String methodName = filedName.replaceFirst(filedName.substring(0, 1), filedName.substring(0, 1).toUpperCase());
			
			map.put(filedName, abc.getClass().getDeclaredMethod("get" + methodName).invoke(abc));
		}
		return map;
	}
}