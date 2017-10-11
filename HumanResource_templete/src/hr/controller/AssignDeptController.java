package hr.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import hr.domain.Department;
import hr.domain.Employee;
import hr.service.HumanResourceService;
import hr.service.logic.HumanResourceServiceLogic;

@WebServlet("/assignDept.do")
public class AssignDeptController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String empNo = request.getParameter("empNo");
		HumanResourceService service = new HumanResourceServiceLogic();
		Employee employee = service.findEmployee(empNo);
		
		List<Department> deptList = service.findAllDepartment();
		
		request.setAttribute("employee", employee);
		request.setAttribute("deptList", deptList);
		request.getRequestDispatcher("assignDept.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		HumanResourceService service = new HumanResourceServiceLogic();
		
		String empNo = request.getParameter("empNo");
		Employee employee = service.findEmployee(empNo);
		employee.setDeptNo(request.getParameter("deptNo"));
		
		service.modify(employee);
		
		response.sendRedirect("employeeList.do");

	}

}
