package store.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import domain.Spot;
import store.SpotStore;
import store.factory.SqlSessionFactoryProvider;
import store.mapper.SpotMapper;

@Repository
public class SpotStoreLogic implements SpotStore{
	
	private SqlSessionFactory factory;
	
	public SpotStoreLogic() {
		factory = SqlSessionFactoryProvider.getSqlSessionFactory();
	}

	@Override
	public boolean createSpot(Spot spot) {
		
		SqlSession session = factory.openSession();
		
		boolean result = false;

		try {
			SpotMapper mapper = session.getMapper(SpotMapper.class);
			result = mapper.createSpot(spot);
			if(result) {
				session.commit();
			} else {
				session.rollback();
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
		
		return result;
	}

	@Override
	public List<Spot> retrieveAllSpots() {
		
		SqlSession session = factory.openSession();
		List<Spot> spotList = new ArrayList<>();

		try {
			SpotMapper mapper = session.getMapper(SpotMapper.class);
			
			spotList = mapper.retrieveAllSpots();
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
		
		return spotList;
	}

	@Override
	public Spot retrieveSpotBySpotId(int spotId) {
		
		SqlSession session = factory.openSession();
		Spot spot = null;

		try {
			SpotMapper mapper = session.getMapper(SpotMapper.class);
			spot = mapper.retrieveSpotBySpotId(spotId);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
		
		return spot;
	}

	@Override
	public List<String> retrieveImageListBySpotId(int spotId) {
		
		SqlSession session = factory.openSession();
		List<String> imageList = new ArrayList<>();

		try {
			SpotMapper mapper = session.getMapper(SpotMapper.class);
			imageList = mapper.retrieveImageListBySpotId(spotId);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
		
		return imageList;
	}

	@Override
	public List<Spot> retrieveSpotsByRegisterId(String registerId) {
		
		SqlSession session = factory.openSession();
		List<Spot> spotList = new ArrayList<>();

		try {
			SpotMapper mapper = session.getMapper(SpotMapper.class);
			spotList = mapper.retrieveSpotsByRegisterId(registerId);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
		
		return spotList;
	}

	@Override
	public boolean updateSpot(Spot spot) {
		
		SqlSession session = factory.openSession();
		boolean result = false;

		try {
			SpotMapper mapper = session.getMapper(SpotMapper.class);
			result = mapper.updateSpot(spot);
			
			if(result) {
				session.commit();
			}else {
				session.rollback();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
		
		return result;
	}

	@Override
	public boolean deleteSpot(int spotId) {
		
		SqlSession session = factory.openSession();
		boolean result = false;

		try {
			SpotMapper mapper = session.getMapper(SpotMapper.class);
			result = mapper.deleteSpot(spotId);
			
			if(result) {
				session.commit();
			}else {
				session.rollback();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
		
		return result;
	}

	@Override
	public boolean createSpotImage(int spotId, String imageUrl) {
		SqlSession session = factory.openSession();
		Map<String, Object> map = new HashMap<>();
		boolean result = false;

		try {
			SpotMapper mapper = session.getMapper(SpotMapper.class);
			map.put("spotId", spotId);
			map.put("imageUrl", imageUrl);
			result = mapper.createSpotImage(map);
			
			if(result) {
				session.commit();
			}else {
				session.rollback();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
		
		return result;
	}

	@Override
	public List<Spot> retriveSpotsByCondition(String spotLocation, String spotType, String spotName) {
		
		SqlSession session = factory.openSession();
		Map<String, String> map = new HashMap<>();
		List<Spot> spotList = new ArrayList<>();
		
		if(!spotName.equals("")) {
			spotName = "%" + spotName.toLowerCase() + "%" ;  
		}
		
		if(!spotLocation.equals("")) {
			spotLocation = "%" + spotLocation + "%";
		}
		
		try {
			SpotMapper mapper = session.getMapper(SpotMapper.class);
			
			map.put("spotLocation", spotLocation);
			map.put("spotType", spotType);
			map.put("spotName", spotName);
			
			spotList = mapper.retrieveSpotsByCondition(map);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}
		
		return spotList;
	}

}
