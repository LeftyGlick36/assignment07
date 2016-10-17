package assignment07;

import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

public class BalancedSymbolCheckerTest {
	BalancedSymbolChecker Test = new BalancedSymbolChecker();
	// @BeforeClass
	// public static void setUpBeforeClass() throws Exception {
	// }
	//
	// @AfterClass
	// public static void tearDownAfterClass() throws Exception {
	// }

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void testCheckFile() throws FileNotFoundException {
		// String filename = "Class1.java";

		Test.checkFile("Class1.java");
	}

}
