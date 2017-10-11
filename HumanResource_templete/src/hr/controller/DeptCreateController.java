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

@WebServlet("/deptCreate.do")
public class DeptCreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("deptCreate.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HumanResourceService service = new HumanResourceServiceLogic();
		String no = request.getParameter("deptNo");
		String name = request.getParameter("deptName");
		Department department = new Department(no, name);
		service.registeDepartment(department);
		response.sendRedirect("deptList.do");
		
	}

}
