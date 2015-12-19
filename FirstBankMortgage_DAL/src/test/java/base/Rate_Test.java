package base;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import domain.RateDomainModel;



public class Rate_Test {

	@Test
	public void testRows() {
		ArrayList<RateDomainModel> tst = RateDAL.getRates();
		assertTrue(tst.size() > 0);
	}
	
	
	@Test
	public void testIR() {
		assertEquals(RateDAL.getRate(601), 5, 0);
		assertEquals(RateDAL.getRate(651), 4.5, 0);
		assertEquals(RateDAL.getRate(701), 4, 0);
		assertEquals(RateDAL.getRate(751), 3.75, 0);
		assertEquals(RateDAL.getRate(801), 3.5, 0);
	}


}
