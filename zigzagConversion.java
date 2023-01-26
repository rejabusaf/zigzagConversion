package zigzagConversion;

import java.math.*;

public class zigzagConversion {

	public static String convert(String s, int numRows) {
		int x = 0;
		int n = 0;
		int i = 0;
		int j = 0;
		int k = 0;
		int beforeSkip = 0;
		int afterSkip = 0;
		String word = "";
		int sections = (int) Math.ceil( (s.length() / (2 * numRows - 2.0)));
		int numCols = sections * (numRows - 1);
		char[][] matrix = new char[numRows][numCols];
		if (s.length() <= 2)
			return s;
		if (numRows <= 1)
			return s;
		while (i < s.length()) {
			for (j = 0 ; j < numRows ; j++) {
				if (i < s.length()) {
					matrix[j][n] = s.charAt(i);
					i++;
				}
			}
			for (j = numRows - 2 ; j > 0 ; j--) {
				if (i < s.length()) {
					n++;
					matrix[j][n] = s.charAt(i);
					i++;
				}
			}
			n++;
		}
		i = 0;
		beforeSkip = numRows - 3;
		afterSkip = 0;
		
		for (j = 0 ; j < numRows ; j++) {
			for (i = 0 ; i < numCols ; i++) {
				if (i % (numRows - 1) == 1) {
					if (j == 0) {
						i = i + beforeSkip;
					}
					if ((j >= 1) && (j < numRows - 1)) {
						i = i + beforeSkip + 1;
						if ((j < numRows) && (i < numCols)) {
							word = word + matrix[j][i];
						}
						i = i + afterSkip - 1;
					}
					if (j == numRows - 1) {
						if (afterSkip > 2) {
							i = i + afterSkip - 2;
						}
					}
				}
				else {
					if ((j < numRows) && (i < numCols)) {
						word = word + matrix[j][i];
					}
				}
			}
			beforeSkip --;
			afterSkip ++;
		}
		

		word = word.replace("\u0000", "");
		return word;

	}
	
	
	public static void main(String[] args) {
		int numRows = 3;
		String s = "PAYPALISHIRING";
		String o = convert(s , numRows);
		System.out.println(o);
	}
}

