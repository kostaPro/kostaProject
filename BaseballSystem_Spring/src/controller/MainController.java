package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import domain.BaseballTeam;
import domain.Player;
import service.BaseballTeamService;

@Controller
public class MainController {

	@Autowired
	BaseballTeamService service;
	
	@RequestMapping("/list.do")
	public ModelAndView showTeamList() {
		List<BaseballTeam> teamList = service.findAllTeams();
		
		ModelAndView modelAndView = new ModelAndView("teamList.jsp");
		modelAndView.addObject("teamList", teamList);
		
		return modelAndView;
	}
	
	@RequestMapping("/playerList.do")
	public ModelAndView showPlayerList(HttpServletRequest req) {
		String teamId = req.getParameter("teamId");
		
		ModelAndView modelAndView = new ModelAndView("playerList.jsp");
		
		if (teamId != null) {
			BaseballTeam team = service.findTeam(teamId);
			modelAndView.addObject("team", team);
		} else {
			List<BaseballTeam> teamList = service.findAllTeamsWithPlayers();
			modelAndView.addObject("teamList", teamList);
		}
		
		return modelAndView;
	}
	
	@RequestMapping("/teamDetail.do")
	public ModelAndView showTeamDetail(HttpServletRequest req) {
		String teamId = req.getParameter("teamId");
		BaseballTeam team = service.findTeam(teamId);
		
		ModelAndView modelAndView = new ModelAndView("teamDetail.jsp");

		modelAndView.addObject("team", team);
		modelAndView.addObject("playerNumber", team.getNumberOfPlayers());
		
		return modelAndView;
	}
	
	@RequestMapping("/trade.do")
	public ModelAndView showTradeTargetList(HttpServletRequest req) {
		String playerId = req.getParameter("playerId");
		Player tradePlayer = service.findPlayer(playerId);

		List<BaseballTeam> tradeList = 
				service.findTradeTargetPalyers(tradePlayer.getTeamId());
		
		ModelAndView modelAndView = new ModelAndView("tradeTargetList.jsp");
		
		modelAndView.addObject("tradePlayer", tradePlayer);
		modelAndView.addObject("teamList", tradeList);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/trade.do", method = RequestMethod.POST)
	public String tradePlayer(HttpServletRequest req) {
		String sourcePlayerId = req.getParameter("sourcePlayerId");
		String targetPlayerId = req.getParameter("targetPlayer");
		service.tradePlayer(sourcePlayerId, targetPlayerId);
		
		return "redirect:/playerList.do";
	}
}
