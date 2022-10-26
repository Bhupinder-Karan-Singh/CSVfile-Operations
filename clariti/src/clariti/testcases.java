package clariti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testcases {

    //test case to find total fee including surcharge
	@Test
	void test_fee() throws Exception {
		clariti obj = new clariti();
		assertEquals(110212, obj.calculate_fee("development", "quality assurance", "cat1", ""));
		assertEquals(229041, obj.calculate_fee("operations", "human resources", "", ""));
	}
	
	// test case to find the correct surcharge
	@Test
	void test_surcharge() throws Exception {
		clariti obj = new clariti();
		assertEquals(0.10, obj.getSurcharge("Marketing"));
		assertEquals(0.15, obj.getSurcharge("Sales"));
		assertEquals(0.20, obj.getSurcharge("Development"));
		assertEquals(0.15, obj.getSurcharge("Operations"));	
		assertEquals(0.05, obj.getSurcharge("support"));
	}
}
