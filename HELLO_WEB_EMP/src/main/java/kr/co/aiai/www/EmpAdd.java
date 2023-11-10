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

@WebServlet("/emp_add")
public class EmpAdd extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		String e_id = request.getParameter("e_id");
		
		EmpDao ed = new EmpDao();
//		Emp vo = null;
//		try {
//			vo = ed.select(e_id);
//		} catch (SQLException e) {
//			System.out.println("e:"+e);
//		}
		
//		request.setAttribute("vo", vo);
		
		RequestDispatcher rd = request.getRequestDispatcher("emp_add.jsp");
		rd.forward(request, response);
		
//		request.getRequestDispatcher("emp_mod.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
