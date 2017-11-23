package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import service.ReportService;

@Controller
public class ReportController {

	@Autowired
	private ReportService reportService;
}
