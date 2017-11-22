package store.logic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import domain.Report;
import store.ReportStore;
import store.factory.SqlSessionFactoryProvider;
import store.mapper.ReportMapper;

@Repository
public class ReportStoreLogic implements ReportStore{
	
	private SqlSessionFactory factory;

	public ReportStoreLogic() {
		factory = SqlSessionFactoryProvider.getSqlSessionFactory();
	}

	@Override
	public List<Report> retrieveReportsByReporterId(String reporterId) {

		SqlSession session = factory.openSession();
		List<Report> list = null;

		try {
			ReportMapper mapper = session.getMapper(ReportMapper.class);
			list = mapper.retrieveReportsByReporterId(reporterId);
		
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return list;
	}

	@Override
	public List<Report> retrieveReportsBySuspectId(String suspectId) {

		SqlSession session = factory.openSession();
		List<Report> list = null;

		try {
			ReportMapper mapper = session.getMapper(ReportMapper.class);
			list = mapper.retrieveReportsBySuspectId(suspectId);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return list;
	}

	@Override
	public List<Report> retrieveAllReports() {

		SqlSession session = factory.openSession();
		List<Report> list = null;

		try {
			ReportMapper mapper = session.getMapper(ReportMapper.class);
			list= mapper.retrieveAllReports();
		
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return list;
	}

	@Override
	public List<Report> retrieveReportsByReportType(String reportType) {

		SqlSession session = factory.openSession();
		List<Report> list = null;

		try {
			ReportMapper mapper = session.getMapper(ReportMapper.class);
			list = mapper.retrieveReportsByReportType(reportType);
		
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return list;
	}

	@Override
	public List<String> retrieveBlackList() { //

		SqlSession session = factory.openSession();
		List<String> list = null;

		try {
			ReportMapper mapper = session.getMapper(ReportMapper.class);
			list = mapper.retrieveBlackList();
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return list;
	}

	@Override
	public Report retrieveReport(String reporterId, int targetId) { 

		SqlSession session = factory.openSession();
		Report report = null;
		Map<String, Object> map = new HashMap<>();

		try {
			ReportMapper mapper = session.getMapper(ReportMapper.class);
		
			map.put("reporterId", reporterId);
			map.put("targetId", targetId);
			
			report = mapper.retrieveReport(reporterId, targetId);//
		
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return report;
	}



	@Override
	public boolean createEventCommentReport(Report report) {
		SqlSession session = factory.openSession();
		boolean result = false;

		try {
			ReportMapper mapper = session.getMapper(ReportMapper.class);
			result = mapper.createEventCommentReport(report);

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
	public boolean createMeetingCommentReport(Report report) {
		SqlSession session = factory.openSession();
		boolean result = false;

		try {
			ReportMapper mapper = session.getMapper(ReportMapper.class);
			result = mapper.createMeetingCommentReport(report);
			
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
	public boolean createMeeingReport(Report report) {
		SqlSession session = factory.openSession();
		boolean result = false;

		try {
			ReportMapper mapper = session.getMapper(ReportMapper.class);
			result = mapper.createMeeingReport(report);
			
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
	public boolean createReviewCommentReport(Report report) {
		SqlSession session = factory.openSession();
		boolean result = false;

		try {
			ReportMapper mapper = session.getMapper(ReportMapper.class);
			result = mapper.createReviewCommentReport(report);
			
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
	public boolean createReviewReport(Report report) {
		SqlSession session = factory.openSession();
		boolean result = false;

		try {
			ReportMapper mapper = session.getMapper(ReportMapper.class);
			result = mapper.createReviewReport(report);
			
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
	public boolean createSpotReport(Report report) {
		SqlSession session = factory.openSession();
		boolean result = false;

		try {
			ReportMapper mapper = session.getMapper(ReportMapper.class);
			result = mapper.createSpotReport(report);
			
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
	public boolean updateEventCommentReport(Report report) {
		SqlSession session = factory.openSession();
		boolean result = false;

		try {
			ReportMapper mapper = session.getMapper(ReportMapper.class);
			result = mapper.updateEventCommentReport(report);
			
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
	public boolean updateMeetingCommentReport(Report report) {
		SqlSession session = factory.openSession();
		boolean result = false;

		try {
			ReportMapper mapper = session.getMapper(ReportMapper.class);
			result = mapper.updateMeetingCommentReport(report);

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
	public boolean updateMeeingReport(Report report) {
		SqlSession session = factory.openSession();
		boolean result = false;

		try {
			ReportMapper mapper = session.getMapper(ReportMapper.class);
			result = mapper.updateMeeingReport(report);
			
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
	public boolean updateReviewCommentReport(Report report) {
		SqlSession session = factory.openSession();
		boolean result = false;

		try {
			ReportMapper mapper = session.getMapper(ReportMapper.class);
			result = mapper.updateReviewCommentReport(report);
			

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
	public boolean updateReviewReport(Report report) {
		SqlSession session = factory.openSession();
		boolean result = false;

		try {
			ReportMapper mapper = session.getMapper(ReportMapper.class);
			result = mapper.updateReviewReport(report);

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
	public boolean updateSpotReport(Report report) {
		SqlSession session = factory.openSession();
		boolean result = false;

		try {
			ReportMapper mapper = session.getMapper(ReportMapper.class);
			result = mapper.updateSpotReport(report);
		
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
	public boolean deleteEventCommentReport(int reportId) {
		SqlSession session = factory.openSession();
		boolean result = false;

		try {
			ReportMapper mapper = session.getMapper(ReportMapper.class);
			result = mapper.deleteEventCommentReport(reportId);

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
	public boolean deleteMeetingCommentReport(int reportId) {
		SqlSession session = factory.openSession();
		boolean result = false;

		try {
			ReportMapper mapper = session.getMapper(ReportMapper.class);
			result = mapper.deleteMeetingCommentReport(reportId);

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
	public boolean deleteMeeingReport(int reportId) {
		SqlSession session = factory.openSession();
		boolean result = false;

		try {
			ReportMapper mapper = session.getMapper(ReportMapper.class);
			result = mapper.deleteMeeingReport(reportId);

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
	public boolean deleteReviewCommentReport(int reportId) {
		SqlSession session = factory.openSession();
		boolean result = false;

		try {
			ReportMapper mapper = session.getMapper(ReportMapper.class);
			result = mapper.deleteReviewCommentReport(reportId);

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
	public boolean deleteReviewReport(int reportId) {
		SqlSession session = factory.openSession();
		boolean result = false;

		try {
			ReportMapper mapper = session.getMapper(ReportMapper.class);
			result = mapper.deleteReviewReport(reportId);

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
	public boolean deleteSpotReport(int reportId) {
		SqlSession session = factory.openSession();
		boolean result = false;

		try {
			ReportMapper mapper = session.getMapper(ReportMapper.class);
			result = mapper.deleteSpotReport(reportId);

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

}
