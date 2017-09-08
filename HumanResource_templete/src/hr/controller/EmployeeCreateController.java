package hr.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hr.domain.Employee;
import hr.service.HumanResourceService;
import hr.service.logic.HumanResourceServiceLogic;

@WebServlet("/employeeCreate.do")
public class EmployeeCreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String deptNo = request.getParameter("deptNo");
		
		request.setAttribute("deptNo",deptNo);
		request.getRequestDispatcher("employeeCreate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Employee employee = new Employee();
		employee.setNo(request.getParameter("empNo"));
		employee.setName(request.getParameter("empName"));
		employee.setDeptNo(request.getParameter("deptNo"));
		
		HumanResourceService service = new HumanResourceServiceLogic();
		service.registEmployee(employee);
		
		response.sendRedirect("employeeList.do");
	}

}
