import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Test class for Essec.java
 * @author maxie
 */
public class EssecTest {
	String hw;
	int[] intArr = {2, 7, 6, 13, 8};
	String[] list = {"OA", "JG", "MB", "JW", "JR", "CH", "LH", "FH"};
	String[][] matrix = {{"a", "b"}, {"c", "d"}};
	
	/**
	 * Set up of the test.
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		hw = "Hello world !";
		/*intArr = ;
	    matrix = ;
	    list = ;*/
	}

	/**
	 * Clear up of the test.
	 * @throws java.lang.Exception
	 */
	/*@After
	public void tearDown() throws Exception {
		hw = null;
	    intArr = null;
	    list = null;
	    matrix = null;
	}*/

	/**
	 * Test method for {@link Essec#prompt(java.lang.String)}.
	 */
	@Test
	public void testPrompt() {
		assertEquals("prompt(Maxie)", "Maxie", prompt("Your name ?"));
	}

	/**
	 * Test method for {@link Essec#isSq(int)}.
	 */
	@Test
	public void testIsSq() {
		assertEquals("isSq", true, isSq(4));
	}

	/**
	 * Test method for {@link Essec#hasNtimes(T[], java.lang.Object)}.
	 */
	@Test
	public void testHasNtimes() {
		assertEquals("hasNtimes", 2, hasNtimes(hw, " "));
	}

	/**
	 * Test method for {@link Essec#getIndex(java.lang.Object[], java.lang.Object)}.
	 */
	@Test
	public void testGetIndex() {
		assertEquals("getIndex>=0", 2, getIndex(hw, "l"));
	    assertEquals("getIndex<0", -1, getIndex(hw, "M"));
	}

	/**
	 * Test method for {@link Essec#getIndexes(java.lang.Object[][], java.lang.Object)}.
	 */
	@Test
	public void testGetIndexes() {
		assertEquals("getIndexes>=0", {1, 0}, getIndexes(matrix, "c"));
	    assertEquals("getIndexes<0", -1, getIndexes(matrix, "e"));
	}

	/**
	 * Test method for {@link Essec#lenInt(int)}.
	 */
	@Test
	public void testLenInt() {
		assertEquals("lenInt", 3, lenInt(125));
	}

	/**
	 * Test method for {@link Essec#toStr(java.lang.Object[])}.
	 */
	@Test
	public void testToStr() {
		assertEquals("toStr", "2, 7, 6, 13, 8", toStr(intArr));
	}

	/**
	 * Test method for {@link Essec#twoDToStr(java.lang.String[][])}.
	 */
	@Test
	public void testTwoDToStr() {
		assertEquals("2D->Str", "a, b, c, d", TwoDToStr(matrix));
	}

	/**
	 * Test method for {@link Essec#arrToStr(java.lang.String[][])}.
	 */
	@Test
	public void testArrToStr() {
		assertEquals("arr->Str", "OH, JG, MB, JW, CH, LH, FH", arrToStr(matrix));
	}

	/**
	 * Test method for {@link Essec#toInt(int[])}.
	 */
	@Test
	public void testToInt() {
		assertEquals("toInt", 276138, toInt(intArr));
	}

	/**
	 * Test method for {@link Essec#intArrToStr(int[])}.
	 */
	@Test
	public void testIntArrToStr() {
		assertEquals("intArrToStr", "2, 7, 6, 13, 8", intArrToStr(intArr));
	}

	/**
	 * Test method for {@link Essec#intToArr(int)}.
	 */
	@Test
	public void testIntToArr() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link Essec#mkMatrix(int, int, java.lang.Object)}.
	 */
	@Test
	public void testMkMatrix() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link Essec#printMatrix(T[][])}.
	 */
	@Test
	public void testPrintMatrix() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link Essec#clamp(double, double, double)}.
	 */
	@Test
	public void testClampDoubleDoubleDouble() {
		assertEquals("clamp in", 3.2, clamp(3.1, 0.5, 5.3));
	    assertEquals("clamp in", 5.3, clamp(7.4, 0.5, 5.3));
	}

	/**
	 * Test method for {@link Essec#clamp(int, int, int)}.
	 */
	@Test
	public void testClampIntIntInt() {
		assertEquals("clamp in", 3, clamp(3, 0, 5));
	    assertEquals("clamp in", 5, clamp(7, 0, 5));
	}

	/**
	 * Test method for {@link Essec#randInt(int, int)}.
	 */
	@Test
	public void testRandInt() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link Essec#rand(double, double)}.
	 */
	@Test
	public void testRand() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link Essec#swap(T[], int, int)}.
	 */
	@Test
	public void testSwap() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link Essec#isNumeric(java.lang.String)}.
	 */
	@Test
	public void testIsNumeric() {
		assertEquals("isNumeric(5.32)", true, isNumeric("5.32"));
		assertEquals("isNumeric(4)", true, isNumeric("4"));
		assertEquals("isNumeric(-190)", true, isNumeric("-190"));
		assertEquals("isNumeric(-)", false, isNumeric("-"));
		assertEquals("isNumeric(5e19)", false, isNumeric("5e19"));
		assertEquals("isNumeric(0xF4)", false, isNumeric("0xF4"));
	}

}
