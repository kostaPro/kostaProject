package store.logic;

import java.util.ArrayList;
import java.util.List;

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
	public boolean createRepot(Report report) {

		SqlSession session = factory.openSession();

		try {
			ReportMapper mapper = session.getMapper(ReportMapper.class);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return false;
	}

	@Override
	public List<Report> retrieveReportsByReporterId(String reporterId) {

		SqlSession session = factory.openSession();

		try {
			ReportMapper mapper = session.getMapper(ReportMapper.class);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return null;
	}

	@Override
	public List<Report> retrieveReportsBySuspectId(String suspectId) {

		SqlSession session = factory.openSession();

		try {
			ReportMapper mapper = session.getMapper(ReportMapper.class);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return null;
	}

	@Override
	public List<Report> retrieveAllReports() {

		SqlSession session = factory.openSession();

		try {
			ReportMapper mapper = session.getMapper(ReportMapper.class);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return null;
	}

	@Override
	public List<Report> retrieveReportsByReportType(String reportType) {

		SqlSession session = factory.openSession();
		List<Report> reportList = new ArrayList<>();

		try {
			ReportMapper mapper = session.getMapper(ReportMapper.class);
			reportList = mapper.retrieveReportsByReportType(reportType);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return reportList;
	}

	@Override
	public List<String> retrieveBlackList() {

		SqlSession session = factory.openSession();

		try {
			ReportMapper mapper = session.getMapper(ReportMapper.class);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return null;
	}

	@Override
	public Report retrieveReport(String reporterId, int targetId) {

		SqlSession session = factory.openSession();

		try {
			ReportMapper mapper = session.getMapper(ReportMapper.class);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return null;
	}

	@Override
	public boolean updateReport(Report report) {

		SqlSession session = factory.openSession();

		try {
			ReportMapper mapper = session.getMapper(ReportMapper.class);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return false;
	}

	@Override
	public boolean deleteReport(int reportId) {

		SqlSession session = factory.openSession();

		try {
			ReportMapper mapper = session.getMapper(ReportMapper.class);
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			session.close();
		}

		return false;
	}

}
