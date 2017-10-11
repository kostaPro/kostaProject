package store;

import java.util.List;

import domain.BaseballTeam;

public interface BaseballTeamStore {

	public BaseballTeam retrieve(String teamId);
	public List<BaseballTeam> retrieveAll();
}
