package kr.co.aiai.www;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.aiai.dao.EmpDao;
import kr.co.aiai.model.Emp;

@WebServlet("/emp_mod_act")
public class EmpModAct extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String e_id = request.getParameter("e_id");
		String e_name = request.getParameter("e_name");
		String gen = request.getParameter("gen");
		String addr = request.getParameter("addr");
		
		Emp pvo = new Emp(e_id, e_name, gen, addr);
		
		EmpDao ed = new EmpDao();
		int cnt = -1;
		try {
			cnt = ed.update(pvo); // 정상동작되면 1이됨
		} catch (SQLException e) {
			System.out.println("cnt:"+cnt);
		}
		
		request.setAttribute("cnt", cnt);
		
		RequestDispatcher rd = request.getRequestDispatcher("emp_mod_act.jsp");
		rd.forward(request, response);
	}
}
