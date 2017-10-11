package store.logic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import domain.Player;
import store.PlayerStore;
import store.factory.ConnectionFactory;
import store.utils.JdbcUtils;

@Repository
public class PlayerStoreLogic implements PlayerStore{

	private ConnectionFactory factory;
	
	public PlayerStoreLogic() {
		factory = ConnectionFactory.getInstance();
	}
	
	@Override
	public void update(Player player) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = factory.createConnection();
			String sql = "update player_tb set teamId = ? where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(player.getTeamId()));
			pstmt.setInt(2, Integer.parseInt(player.getPlayerId()));
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeResource(conn,pstmt);
		}
		
	}

	@Override
	public Player retrieve(String playerId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Player player = new Player();
		
		try {
			conn = factory.createConnection();
			String sql = "select id,teamId,name,backnumber,position "
					+ "from player_tb where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(playerId));
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				player.setPlayerId(rs.getString("id"));
				player.setName(rs.getString("name"));
				player.setBackNumber(rs.getInt("backnumber"));
				player.setPosition(rs.getString("position"));
				player.setTeamId(rs.getString("teamId"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeResource(conn,pstmt,rs);
		}
		return player;
	}

	@Override
	public List<Player> retrieveByTeam(String teamId) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Player> players = new ArrayList<Player>();
		
		try {
			conn = factory.createConnection();
			String sql = "select id,name,backnumber,position "
					+ "from player_tb where teamid = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(teamId));
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				Player player = new Player();
				player.setPlayerId(rs.getString("id"));
				player.setName(rs.getString("name"));
				player.setBackNumber(rs.getInt("backnumber"));
				player.setPosition(rs.getString("position"));
				player.setTeamId(teamId);
				
				players.add(player);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeResource(conn,pstmt,rs);
		}
		return players;
	}

}
