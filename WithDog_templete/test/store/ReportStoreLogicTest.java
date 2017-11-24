package store;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import domain.Report;
import store.logic.ReportStoreLogic;

public class ReportStoreLogicTest {
	
	private ReportStore store;
	
	@Before
	public void setUp() {
		store = new ReportStoreLogic();
	}

	@Test
	public void testCreateRepot() {
		fail("Not yet implemented");
	}

	@Test
	public void testRetrieveReportsByReporterId() {
		fail("Not yet implemented");
	}

	@Test
	public void testRetrieveReportsBySuspectId() {
		fail("Not yet implemented");
	}

	@Test
	public void testRetrieveAllReports() {
		fail("Not yet implemented");
	}

	@Test
	public void testRetrieveReportsByReportType() {
		List<Report> list = store.retrieveReportsByReportType("meeting");
		
		assertEquals(2, list.size());
				
	}

	@Test
	public void testRetrieveBlackList() {
		fail("Not yet implemented");
	}

	@Test
	public void testRetrieveReport() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateReport() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteReport() {
		fail("Not yet implemented");
	}

}
