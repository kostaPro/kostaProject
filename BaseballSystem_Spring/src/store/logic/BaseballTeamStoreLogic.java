package store.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import domain.BaseballTeam;
import domain.Player;
import store.BaseballTeamStore;
import store.factory.ConnectionFactory;
import store.utils.JdbcUtils;

@Repository
public class BaseballTeamStoreLogic implements BaseballTeamStore{

	private ConnectionFactory factory;
	
	public BaseballTeamStoreLogic() {
		factory = ConnectionFactory.getInstance();
	}
	@Override
	public BaseballTeam retrieve(String teamId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BaseballTeam team = new BaseballTeam();
		
		try {
			conn = factory.createConnection();
			String teamInfoSql = "select id,name,region,manager,stadium,logo "
					+ "from team_tb where id = ?";
			pstmt = conn.prepareStatement(teamInfoSql);
			pstmt.setInt(1, Integer.parseInt(teamId));
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				team.setTeamId(rs.getString("id"));
				team.setName(rs.getString("name"));
				team.setRegion(rs.getString("region"));
				team.setManager(rs.getString("manager"));
				team.setStadium(rs.getString("stadium"));
				team.setLogo(rs.getString("logo"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeResource(conn,pstmt,rs);
		}
		return team;
	}

	@Override
	public List<BaseballTeam> retrieveAll() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<BaseballTeam> list = new ArrayList<BaseballTeam>();
		
		try {
			conn = factory.createConnection();
			String teamInfoSql = "select id,name,region,manager,stadium,logo from team_tb";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(teamInfoSql);
			
			while(rs.next()) {
				BaseballTeam team = new BaseballTeam();
				team.setTeamId(rs.getString("id"));
				team.setName(rs.getString("name"));
				team.setRegion(rs.getString("region"));
				team.setManager(rs.getString("manager"));
				team.setStadium(rs.getString("stadium"));
				team.setLogo(rs.getString("logo"));
				list.add(team);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeResource(conn,stmt,rs);
		}
		return list;
	}

}
