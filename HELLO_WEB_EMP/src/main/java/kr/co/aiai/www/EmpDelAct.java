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

@WebServlet("/emp_del_act")
public class EmpDelAct extends HttpServlet {
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String e_id = request.getParameter("e_id");
		
		EmpDao ed = new EmpDao();
		int cnt = -1;
		try {
			cnt = ed.delete(e_id); // 정상동작되면 1이됨
		} catch (SQLException e) {
			System.out.println("cnt:"+cnt);
		}
		request.setAttribute("cnt", cnt);
		
		RequestDispatcher rd = request.getRequestDispatcher("emp_del_act.jsp");
		rd.forward(request, response);
	}
}
