/**
 * Main class of the EssecJ framework.
 * @author Maximilian Berkmann
 * @license MIT
 */
import java.util.Scanner;
import static java.lang.Math.*;

public class Essec {
    /**
     * Print an object.
     * @param o Object to be printed
     */
    static void p(Object o) {
        System.out.print(o.toString());
    }

    /**
     * Print an object.
     * @param o Object to be printed
     */
    static void pl(Object o) {
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
     * Prompt the user to get something.
     * @param label Label to be printed when prompting
     */
    static Object prompt(Object label) {
        Scanner k = new Scanner(System.in);
        pl(label);
        Object o = k.next();
        k.close();
        return o;
    }

    /**
     * Check if x is a square number.
     * @param x Number to test
     * @return Squareness
     */
    static boolean isSq(int x) {
        return sqrt(x) == floor(sqrt(x));
    }

    /**
     * Count how many times x contains c.
     * @param x Array which contains or not c
     * @param c Object which we are interested in knowing it's occurrence in x
     * @return Occurrence of c in x
     */
    static int hasNtimes(Object[] x, Object c) {
        int n = 0;
        for(Object current : x) {
            if(current.equals(c)) n++;
        }
        return n;
    }

    /**
     * Get the i in mtx[i] = c.
     * @param mtx Array/matrix
     * @param c Term we want to locate
     * @return Index of the c in mtx
     */
    static int getIndex(Object[] mtx, Object c) {
        int idx = 0;
        for(Object current : mtx) {
            if(current.equals(c) || current == c) return idx;
            else idx++;
        }
        return -1;
    }

    /**
     * Get the i and the j in mtx[i][j] = c.
     * @param mtx Array/matrix
     * @param c Term we want to locate
     * @return Indexes of the c in mtx
     */
    static int[] getIndexes(Object[][] mtx, Object c) {
        int[] idx = {-1, -1};
        for(int i = 0; i < mtx.length; i++) {
            for(int j = 0; j < mtx[0].length; j++) {
                if(mtx[i][j].equals(c) || mtx[i][j] == c) {
                    idx[0] = i;
                    idx[1] = j;
                }
            }
        }
        return idx;
    }

    /**
     * Return the length of an integer.
     * @param n Number
     * @return Length of the number
     */
    static int lenInt(int n) {
        int l = 0;
        do {
            l /= 10;
            l++;
        } while(floor(n) != 0);
        return l;
    }

    /**
     * String[] -> String.
     * @param arr Array
     * @return String equivalence
     */
    static String toStr(Object[] arr) {
        String str = "";
        for(Object subArr : arr) str += subArr.toString() + ", ";
        return str.substring(0, str.length()-2);
    }

    /**
     * String[][] -> String.
     * @param arr Array
     * @return String equivalence
     */
    static String TwoDToStr(String[][] arr) {
        String str = "", nl = System.getProperty("line.separator");
        for(String[] subArr : arr) {
            for(String current : subArr) str += current + ", ";
            str += nl;
        }
        return str;
    }

    /**
     * String[] -> String.
     * @param arr Array
     * @return String equivalence
     */
    static String arrToStr(String[][] arr) {
        String str = "";
        for(String[] subArr : arr) {
            for(String current : subArr) str += current;
        }
        return str;
    }

    /**
     * int[] -> int.
     * @param x Array
     * @return Integer equivalence
     */
    static int toInt(int x[]) {
        int n = 0;
        for(int i = 0; i < x.length; i++) n += x[i] * pow(10, x.length - i - 1);
        return n;
    }

    /**
     * int[] -> String.
     * @param x Array
     * @return String equivalence
     */
    static String intArrToStr(int x[]) {
        String str = "";
        for(int num : x) str += num + ", ";
        return str.substring(0, str.length() - 2);
    }
    /**
     * int->int[].
     * @param x Integer
     * @return Array of integers
     */
    int[] intToArr(int x) {
        int n[] = new int[lenInt(x)], i = 0;
        while(x > 0) {
            n[i] = x % 10;
            i++;
            x /= 10;
        }
        return n;
    }

    /**
     * Make a w*h matrix.
     * @param w Width
     * @param h Height
     * @param c Default value of the cells
     * @return Matrix
    */
    Object[][] mkMatrix(int w, int h, Object c) {
        Object[][] mtx = new Object[w][h];
        for(int i = 0; i < w; i++){
            for(int j = 0; j < h; j++) mtx[i][j] = c;
        }
        return mtx;
    }

    /**
     * Print a matrix.
     * @param mtx Matrix to print
    */
    static void printMatrix(Object[][] mtx) {
        for(Object[] row : mtx) {
            for(int k = 0; k <= mtx.length * 2; k++) p("-");
            pl("");
            for(int j = 1; j < row.length; j++) p("|" + row[j]);
            pl("|");
        }
        for(int k = 0; k <= mtx.length * 2; k++) p("-");
        pl("");
    }

    /**
     * Make sur a <= x <= b.
     * @param x Number to clamp
     * @param a Lower bound
     * @param b Lower bound
    */
    static double clamp(double x, double a, double b) {
        return x < a? a: (x > b? b: x);
    }

    /**
     * Generate a random integer between min and max
     * @param x Number to clamp
     * @param a Lower bound
     * @param b Lower bound
     */
    static int randInt(int min, int max) {
        return (int) (random() * (max - min + 1) + min);
    }

    /**
     * Generate a random double between min and max
     * @param x Number to clamp
     * @param a Lower bound
     * @param b Lower bound
     */
    static double rand(double min, double max) {
        return random() * (max - min + 1) + min;
    }

    /**
     * Swap two elements in an array
     * @param arr Array
     * @param i First index
     * @param j Second index
     */
    static void <T> swap(T[] arr, index i, index j) {
        T tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
     * Check if a string is numeric
     * @param str String
     * @return Numericalness
     */
    public boolean isNumeric(String str) {  
        return str.matches("[-+]?\\d*\\.?\\d*");  
    }
}