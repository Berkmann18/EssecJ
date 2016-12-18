
import java.util.Scanner;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import static java.lang.Math.sqrt;

import java.io.Console;
import java.io.IOException;

import static java.lang.Math.floor;
import static java.lang.Math.pow;
import static java.lang.Math.random;

/**
 * Main class of the EssecJ framework. private int.
 * 
 * @author Maximilian Berkmann
 */
public class Essec {
	/**
	 * Number of maximum digit (to go to the next position).
	 */
	private static int maxDigit = 10;

	/**
	 * Print an object.
	 * 
	 * @param o
	 *            Object to be printed
	 */
	static void p(final Object o) {
		System.out.print(o.toString());
	}

	/**
	 * Print an object.
	 * 
	 * @param o
	 *            Object to be printed
	 */
	static void pl(final Object o) {
		System.out.println(o.toString());
	}

	/**
	 * Clear the screen like the clear command.
	 */
	static void cls() {
		pl("\u001b[2J\u001b[H");
		System.out.flush();
	}

	/**
	 * Execute a system command.
	 * 
	 * @param cmd
	 *            Bash/Batch/Shell command
	 */
	public static void sys(String cmd) {
		try {
			Runtime.getRuntime().exec(cmd);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Prompt the user to get something.
	 * 
	 * @param <T>
	 *            Type of the returned data
	 * @param label
	 *            Label to be printed when prompting
	 * @return User input
	 */
	static <T> T prompt(final String label) {
		Scanner kbd = new Scanner(System.in);
		pl(label);
		@SuppressWarnings("unchecked")
		T output = (T) kbd.next();
		kbd.close();
		return output;
	}

	/**
	 * Prompt a password from user.
	 * 
	 * @param label
	 *            Label to be printed when prompting
	 * @return User password
	 */
	static String password(final String label) {
		Console console = System.console();
		if (console == null) pl("This environment doesn't support consoles.");
		String pw = new String(console.readPassword(label));
		return pw;
	}
	
	/**
	 * Prompt a password on a Swing GUI.
	 * @return Password
	 */
	static String promptPassword() {
		String pw = "";
		final String message = "Password: ";
		if (System.console() == null) {
			final JPasswordField pf = new JPasswordField();
			pw = JOptionPane.showConfirmDialog(null, pf, message, JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION ? new String(pf.getPassword()) : "";
		} else pw = new String(System.console().readPassword("%s> ", message));
		return pw;
	}

	/**
	 * Check if x is a square number.
	 * 
	 * @param x
	 *            Number to test
	 * @return Squareness
	 */
	static boolean isSq(final int x) {
		return sqrt(x) == floor(sqrt(x));
	}

	/**
	 * Count how many times x contains c.
	 * 
	 * @param <T>
	 *            Data type
	 * @param x
	 *            Array which contains or not c
	 * @param c
	 *            Object which we are interested in knowing it's occurrence in x
	 * @return Occurrence of c in x
	 */
	static <T> int hasNtimes(final T[] x, final T c) {
		int n = 0;
		for (T current : x) {
			if (current.equals(c)) n++;
		}
		return n;
	}

	/**
	 * Get the i in a matrix mtx[i] = c.
	 * 
	 * @param mtx
	 *            Array/matrix
	 * @param c
	 *            Term we want to locate
	 * @return Index of the c in mtx
	 */
	static int getIndex(final Object[] mtx, final Object c) {
		int index = 0;
		for (Object current : mtx) {
			if (current.equals(c) || current == c) return index;
			else index++;
		}
		return -1;
	}

	/**
	 * Get the i and the j in mtx[i][j] = c.
	 * 
	 * @param mtx
	 *            Array/matrix
	 * @param c
	 *            Term we want to locate
	 * @return Indexes of the c in mtx
	 */
	static int[] getIndexes(final Object[][] mtx, final Object c) {
		int[] idx = { -1, -1 };
		for (int i = 0; i < mtx.length; i++) {
			for (int j = 0; j < mtx[0].length; j++) {
				if (mtx[i][j].equals(c) || mtx[i][j] == c) {
					idx[0] = i;
					idx[1] = j;
				}
			}
		}
		return idx;
	}

	/**
	 * Return the length of an integer.
	 * 
	 * @param n
	 *            Number
	 * @return Length of the number
	 */
	static int lenInt(final int n) {
		int l = 0;
		do {
			l /= maxDigit;
			l++;
		} while (floor(n) != 0);
		return l;
	}

	/**
	 * String[] -> String.
	 * 
	 * @param arr
	 *            Array
	 * @return String equivalence
	 */
	static String toStr(final Object[] arr) {
		String str = "";
		for (Object subArr : arr)
			str += subArr.toString() + ", ";
		return str.substring(0, str.length() - 2);
	}

	/**
	 * String[][] -> String.
	 * 
	 * @param arr
	 *            Array
	 * @return String equivalence
	 */
	static String twoDToStr(final String[][] arr) {
		String str = "", nl = System.getProperty("line.separator");
		for (String[] subArr : arr) {
			for (String current : subArr)
				str += current + ", ";
			str += nl;
		}
		return str;
	}

	/**
	 * String[] -> String.
	 * 
	 * @param arr
	 *            Array
	 * @return String equivalence
	 */
	static String arrToStr(final String[][] arr) {
		String str = "";
		for (String[] subArr : arr) {
			for (String current : subArr)
				str += current;
		}
		return str;
	}

	/**
	 * int[] -> int.
	 * 
	 * @param x
	 *            Array
	 * @return Integer equivalence
	 */
	static int toInt(final int[] x) {
		int n = 0;
		for (int i = 0; i < x.length; i++)
			n += x[i] * pow(maxDigit, x.length - i - 1);
		return n;
	}

	/**
	 * int[] -> String.
	 * 
	 * @param x
	 *            Array
	 * @return String equivalence
	 */
	static String intArrToStr(int[] x) {
		String str = "";
		for (int num : x)
			str += num + ", ";
		return str.substring(0, str.length() - 2);
	}

	/**
	 * int->int[].
	 * 
	 * @param x
	 *            Integer
	 * @return Array of integers
	 */
	int[] intToArr(int x) {
		int n[] = new int[lenInt(x)], i = 0;
		while (x > 0) {
			n[i] = x % maxDigit;
			i++;
			x /= maxDigit;
		}
		return n;
	}

	/**
	 * Make a w*h matrix.
	 * 
	 * @param w
	 *            Width
	 * @param h
	 *            Height
	 * @param c
	 *            Default value of the cells
	 * @return Matrix
	 */
	final Object[][] mkMatrix(final int w, final int h, final Object c) {
		Object[][] mtx = new Object[w][h];
		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++)
				mtx[i][j] = c;
		}
		return mtx;
	}

	/**
	 * Print a matrix.
	 * 
	 * @param <T>
	 *            Matrix type
	 * @param mtx
	 *            Matrix to print
	 */
	static <T> void printMatrix(final T[][] mtx) {
		for (T[] row : mtx) {
			for (int k = 0; k <= mtx.length * 2; k++)
				p("-");
			pl("");
			for (int j = 1; j < row.length; j++)
				p("|" + row[j]);
			pl("|");
		}
		for (int k = 0; k <= mtx.length * 2; k++)
			p("-");
		pl("");
	}

	/**
	 * Make sure a <= x <= b.
	 * 
	 * @param x
	 *            Number to clamp
	 * @param low
	 *            Lower bound
	 * @param high
	 *            Higher bound
	 */
	static double clamp(final double x, final double low, final double high) {
		return x < low ? low : (x > high ? high : x);
	}

	/**
	 * Make sure a <= x <= b.
	 * 
	 * @param x
	 *            Number to clamp
	 * @param low
	 *            Lower bound
	 * @param high
	 *            Higher bound
	 */
	static double clamp(int x, int low, int high) {
		return x < low ? low : (x > high ? high : x);
	}

	/**
	 * Generate a random integer between min and max.
	 * 
	 * @param min
	 *            Minimum
	 * @param max
	 *            Maximum
	 * @return random integer
	 */
	static int randInt(int min, int max) {
		return (int) (random() * (max - min + 1) + min);
	}

	/**
	 * Generate a random double between min and max.
	 * 
	 * @param min
	 *            Minimum
	 * @param max
	 *            Maximum
	 */
	static double rand(double min, double max) {
		return random() * (max - min + 1) + min;
	}

	/**
	 * Swap two elements in an array.
	 * 
	 * @param arr
	 *            Array
	 * @param index0
	 *            First index
	 * @param index1
	 *            Second index
	 */
	static <T> void swap(T[] arr, int index0, int index1) {
		T tmp = arr[index0];
		arr[index0] = arr[index1];
		arr[index1] = tmp;
	}

	/**
	 * Check if a string is numeric
	 * 
	 * @param str
	 *            String
	 * @return Is it a number ?
	 */
	public boolean isNumeric(String str) {
		return str.matches("[-+]?\\d*\\.?\\d*") && !str.equals("-");
	}
}