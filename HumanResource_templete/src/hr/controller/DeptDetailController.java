package hr.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hr.domain.Department;
import hr.service.HumanResourceService;
import hr.service.logic.HumanResourceServiceLogic;

@WebServlet("/deptDetail.do")
public class DeptDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String deptNo = request.getParameter("deptNo");
		
		HumanResourceService service = new HumanResourceServiceLogic();
		Department dept = service.findDepartment(deptNo);
		
		request.setAttribute("deptNo", dept.getNo());
		request.setAttribute("deptName", dept.getName());
		request.setAttribute("empList", dept.getEmployees());
		request.getRequestDispatcher("deptDetail.jsp").forward(request, response);
	}

}
