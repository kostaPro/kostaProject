package store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import domain.Spot;
import store.SpotStore;
import store.factory.SqlSessionFactoryProvider;

@Repository
public class SpotStoreLogic implements SpotStore{
	
	private SqlSessionFactory factory;
	
	public SpotStoreLogic() {
		factory = SqlSessionFactoryProvider.getSqlSessionFactory();
	}

	@Override
	public boolean createSpot(Spot spot) {
		
		SqlSession session = factory.openSession();

		try {
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
		
		return false;
	}

	@Override
	public boolean createEventSpot(Spot spot) {

		SqlSession session = factory.openSession();

		try {
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
		
		return false;
	}

	@Override
	public List<Spot> retrieveAllSpots() {
		
		SqlSession session = factory.openSession();

		try {
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
		
		return null;
	}

	@Override
	public Spot retrieveEventSpot(int eventId) {

		SqlSession session = factory.openSession();

		try {
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
		
		return null;
	}

	@Override
	public List<Spot> retrieveSpotsByLocation(String location) {
		
		SqlSession session = factory.openSession();

		try {
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
		
		return null;
	}

	@Override
	public List<Spot> retrieveSpotsBySpotType(String spotType) {
		
		SqlSession session = factory.openSession();

		try {
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
		
		return null;
	}

	@Override
	public List<Spot> retrieveSpotsByLocationSpotType(String location, String spotType) {
		
		SqlSession session = factory.openSession();

		try {
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
		
		return null;
	}

	@Override
	public Spot retrieveSpotBySpotId(int spotId) {
		
		SqlSession session = factory.openSession();

		try {
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
		
		return null;
	}

	@Override
	public List<Spot> retrieveSpotsBySpotName(String spotName) {
		
		SqlSession session = factory.openSession();

		try {
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
		
		return null;
	}

	@Override
	public List<String> retrieveImageListBySpotId(int spotId) {
		
		SqlSession session = factory.openSession();

		try {
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
		
		return null;
	}

	@Override
	public List<Spot> retrieveSpotsByRegisterId(String registerId) {
		
		SqlSession session = factory.openSession();

		try {
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
		
		return null;
	}

	@Override
	public boolean updateSpot(Spot spot) {
		
		SqlSession session = factory.openSession();

		try {
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
		
		return false;
	}

	@Override
	public boolean updateEventSpot(Spot spot) {
		
		SqlSession session = factory.openSession();

		try {
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
		
		return false;
	}

	@Override
	public boolean deleteSpot(int spotId) {
		
		SqlSession session = factory.openSession();

		try {
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
		
		return false;
	}

	@Override
	public boolean deleteEventSpot(int eventId) {
		
		SqlSession session = factory.openSession();

		try {
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
		
		return false;
	}

}
