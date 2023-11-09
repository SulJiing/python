package kr.co.aiai.www;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.aiai.dao.EmpDao;
import kr.co.aiai.model.Emp;

@WebServlet("/emp_list")
public class EmpList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EmpList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("emp_list.jsp");
		String a = "홍길동";
		request.setAttribute("a",a);
		ArrayList<Emp> list = new ArrayList<Emp>();
		
		EmpDao dao = new EmpDao();
		try {
			List<Emp> list2 = dao.selectList();
			request.setAttribute("dao", list2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		list.add(new Emp("1","1","1","1"));
//		list.add(new Emp("2","2","2","2"));
//		request.setAttribute("list", list);
		
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}