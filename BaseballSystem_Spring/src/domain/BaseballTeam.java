package domain;

import java.io.Serializable;
import java.util.List;

public class BaseballTeam implements Serializable {

	/** UID */
	private static final long serialVersionUID = -4089549294141550288L;
	
	private String teamId;
	private String name;
	private String region;
	private String manager;
	private String stadium;
	private String logo;
	
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	private List<Player> players;
	
	public int getNumberOfPlayers() {
		if(players == null) {
			return 0;
		}
		
		return players.size();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getStadium() {
		return stadium;
	}
	public void setStadium(String stadium) {
		this.stadium = stadium;
	}
	public List<Player> getPlayers() {
		return players;
	}
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	public String getTeamId() {
		return teamId;
	}
	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}
	
	
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((teamId == null) ? 0 : teamId.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BaseballTeam other = (BaseballTeam) obj;
        if (teamId == null) {
            if (other.teamId != null)
                return false;
        } else if (!teamId.equals(other.teamId))
            return false;
        
        return true;
    }
}
