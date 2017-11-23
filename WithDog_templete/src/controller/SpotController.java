package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import service.SpotService;

@Controller
public class SpotController {

	@Autowired
	private SpotService spotService;
}
