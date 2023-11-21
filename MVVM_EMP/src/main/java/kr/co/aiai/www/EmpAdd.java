package kr.co.aiai.www;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.aiai.dao.EmpDao;
import kr.co.aiai.util.AjaxUtil;
import kr.co.aiai.vo.EmpVO;

@WebServlet("/emp_add")
public class EmpAdd extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String e_id = request.getParameter("e_id");
		String e_name = request.getParameter("e_name");
		String gen = request.getParameter("gen");
		String addr = request.getParameter("addr");
		int cnt =0;
		EmpDao dao = new EmpDao();
		try {
			cnt = dao.insert(new EmpVO(e_id, e_name, gen, addr));
			System.out.println(cnt);
			AjaxUtil.responseJson(response, cnt+"");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}