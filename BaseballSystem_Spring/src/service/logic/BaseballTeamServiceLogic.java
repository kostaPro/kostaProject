package service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import domain.BaseballTeam;
import domain.Player;
import service.BaseballTeamService;
import store.BaseballTeamStore;
import store.PlayerStore;
import store.logic.BaseballTeamStoreLogic;
import store.logic.PlayerStoreLogic;

@Service
public class BaseballTeamServiceLogic implements BaseballTeamService{

	@Autowired
	private BaseballTeamStore teamStore;
	
	@Autowired
	private PlayerStore playerStore;
	
	@Override
	public BaseballTeam findTeam(String teamId) {
		BaseballTeam team = teamStore.retrieve(teamId);
		team.setPlayers(playerStore.retrieveByTeam(teamId));
		return team;
	}

	@Override
	public List<BaseballTeam> findAllTeams() {
		return teamStore.retrieveAll();
	}

	@Override
	public List<BaseballTeam> findAllTeamsWithPlayers() {
		List<BaseballTeam> teamList = teamStore.retrieveAll();
		int count = 0;
		
		for(BaseballTeam team : teamList) {
			team.setPlayers(playerStore.retrieveByTeam(team.getTeamId()));
			
			teamList.set(count,team);
			count++;
		}
		return teamList;
	}

	@Override
	public List<BaseballTeam> findTradeTargetPalyers(String teamId) {
		List<BaseballTeam> tradeList = findAllTeamsWithPlayers();
		BaseballTeam team = teamStore.retrieve(teamId);
		tradeList.remove(team);
		return tradeList;
	}

	@Override
	public Player findPlayer(String playerId) {
		return playerStore.retrieve(playerId);
	}

	@Override
	public void tradePlayer(String sourcePlayerId, String targetPlayerId) {
		Player sourcePlayer = playerStore.retrieve(sourcePlayerId);
		Player targetPlayer = playerStore.retrieve(targetPlayerId);
		
		String sourcePlayerTeam = sourcePlayer.getTeamId();
		sourcePlayer.setTeamId(targetPlayer.getTeamId());
		targetPlayer.setTeamId(sourcePlayerTeam);
		playerStore.update(sourcePlayer);
		playerStore.update(targetPlayer);
	}

}
