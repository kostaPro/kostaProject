package store.logic;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import domain.Report;
import domain.BlackList;
import store.ReportStore;
import store.factory.SqlSessionFactoryProvider;
import store.mapper.ReportMapper;

@Repository
public class ReportStoreLogic implements ReportStore {

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
			list = mapper.retrieveAllReports();

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
		Map<String, String> map = new HashMap<>();

		try {
			ReportMapper mapper = session.getMapper(ReportMapper.class);

			map.put("reportType", reportType);

			list = mapper.retrieveReportsByReportType(map);

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return list;

	}

	@Override
	public List<BlackList> retrieveBlackList() {

		SqlSession session = factory.openSession();
		List<BlackList> list = null;

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
	public Report retrieveReport(int reportTargetId) {

		SqlSession session = factory.openSession();
		Report report = null;

		try {
			ReportMapper mapper = session.getMapper(ReportMapper.class);

			report = mapper.retrieveReport(reportTargetId);

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

			if (result) {
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

			if (result) {
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
	public boolean createMeetingReport(Report report) {
		SqlSession session = factory.openSession();
		boolean result = false;

		try {
			ReportMapper mapper = session.getMapper(ReportMapper.class);
			result = mapper.createMeetingReport(report);

			if (result) {
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

			if (result) {
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

			if (result) {
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

			if (result) {
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

			if (result) {
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

			if (result) {
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
	public boolean updateMeetingReport(Report report) {
		SqlSession session = factory.openSession();
		boolean result = false;

		try {
			ReportMapper mapper = session.getMapper(ReportMapper.class);
			result = mapper.updateMeetingReport(report);

			if (result) {
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

			if (result) {
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

			if (result) {
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

			if (result) {
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
	public boolean deleteEventCommentReport(int reportTargetId) {
		SqlSession session = factory.openSession();
		boolean result = false;

		try {
			ReportMapper mapper = session.getMapper(ReportMapper.class);
			result = mapper.deleteEventCommentReport(reportTargetId);

			if (result) {
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
	public boolean deleteMeetingCommentReport(int reportTargetId) {
		SqlSession session = factory.openSession();
		boolean result = false;

		try {
			ReportMapper mapper = session.getMapper(ReportMapper.class);
			result = mapper.deleteMeetingCommentReport(reportTargetId);

			if (result) {
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
	public boolean deleteMeetingReport(int reportTargetId) {
		SqlSession session = factory.openSession();
		boolean result = false;

		try {
			ReportMapper mapper = session.getMapper(ReportMapper.class);
			result = mapper.deleteMeetingReport(reportTargetId);

			if (result) {
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
	public boolean deleteReviewCommentReport(int reportTargetId) {
		SqlSession session = factory.openSession();
		boolean result = false;

		try {
			ReportMapper mapper = session.getMapper(ReportMapper.class);
			result = mapper.deleteReviewCommentReport(reportTargetId);

			if (result) {
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
	public boolean deleteReviewReport(int reportTargetId) {
		SqlSession session = factory.openSession();
		boolean result = false;

		try {
			ReportMapper mapper = session.getMapper(ReportMapper.class);
			result = mapper.deleteReviewReport(reportTargetId);

			if (result) {
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
	public boolean deleteSpotReport(int reportTargetId) {
		SqlSession session = factory.openSession();
		boolean result = false;

		try {
			ReportMapper mapper = session.getMapper(ReportMapper.class);
			result = mapper.deleteSpotReport(reportTargetId);

			if (result) {
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
