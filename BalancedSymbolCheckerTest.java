package assignment07;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BalancedSymbolCheckerTest {
	BalancedSymbolChecker Test = new BalancedSymbolChecker();

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void testCheckFile() throws FileNotFoundException {
		// String filename = "Class1.java";

		Assert.assertEquals("ERROR: Unmatched symbol at line 8 and column 1. Expected ), but read } instead.",
				Test.checkFile("Class1.java"));
	}

	@Test
	public void testCheckFile2() throws FileNotFoundException {
		Assert.assertEquals("ERROR: Unmatched symbol at the end of file. Expected  .", Test.checkFile("Class2.java"));

	}

	@Test
	public void testCheckFile3() throws FileNotFoundException {
		Assert.assertEquals("No errors found. All symbols match.", Test.checkFile("Class3.java"));
	}

	@Test
	public void testCheckFile4() throws FileNotFoundException {
		Assert.assertEquals("ERROR: File ended before closing comment.", Test.checkFile("Class4.java"));
	}

	@Test
	public void testCheckFile5() throws FileNotFoundException {
		Assert.assertEquals("ERROR: Unmatched symbol at line 3 and column 18. Expected ], but read } instead.",
				Test.checkFile("Class7.java"));
	}

	@Test
	public void testCheckFile6() throws FileNotFoundException {
		Assert.assertEquals("No errors found. All symbols match.", Test.checkFile("Class6.java"));
	}

	@Test
	public void testCheckFile7() throws FileNotFoundException {
		Assert.assertEquals("ERROR: Unmatched symbol at line 3 and column 33. Expected ], but read ) instead.",
				Test.checkFile("Class7.java"));
	}

	@Test
	public void testCheckFile8() throws FileNotFoundException {
		Assert.assertEquals("ERROR: Unmatched symbol at line 5 and column 30. Expected }, but read ) instead.",
				Test.checkFile("Class8.java"));
	}

	@Test
	public void testCheckFile9() throws FileNotFoundException {
		Assert.assertEquals("ERROR: Unmatched symbol at line 3 and column 33. Expected ), but read ] instead.",
				Test.checkFile("Class9.java"));
	}

	@Test
	public void testCheckFile10() throws FileNotFoundException {
		Assert.assertEquals("ERROR: Unmatched symbol at line 5 and column 10. Expected }, but read ] instead.",
				Test.checkFile("Class10.java"));
	}

	@Test
	public void testCheckFile11() throws FileNotFoundException {
		Assert.assertEquals("ERROR: Unmatched symbol at the end of file. Expected }.", Test.checkFile("Class2.java"));
	}

	@Test
	public void testCheckFile12() throws FileNotFoundException {
		Assert.assertEquals("No errors found. All symbols match.", Test.checkFile("Class12.java"));
	}

	@Test
	public void testCheckFile13() throws FileNotFoundException {
		Assert.assertEquals("No errors found. All symbols match.", Test.checkFile("Class13.java"));
	}

	@Test
	public void testCheckFile14() throws FileNotFoundException {
		Assert.assertEquals("No errors found. All symbols match.", Test.checkFile("Class14.java"));
	}
	@Test
	public void testCheckFile15() throws FileNotFoundException {
		Assert.assertEquals("ERROR: Unmatched symbol at the end of file. Expected }.", Test.checkFile("Class15.java"));
	}

}
