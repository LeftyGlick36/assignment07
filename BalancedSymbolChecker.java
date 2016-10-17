package assignment07;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class containing the checkFile method for checking if the (, [, and { symbols
 * in an input file are correctly matched.
 * 
 * @author Moses
 */
public class BalancedSymbolChecker {
	public int errors;

	LinkedListStack<Character> stack = new LinkedListStack<Character>();

	public BalancedSymbolChecker() {

	}

	/**
	 * Symbol represents what will be placed on the stack.
	 */
	private static class Symbol {
		int line;
		int colNum;
		char symbolR;
		char symbolE;

		public Symbol(int lineNumber, int colNumber, char symbolRead, char symbolExpected) {
			line = lineNumber;
			colNum = colNumber;
			symbolR = symbolRead;
			symbolE = symbolExpected;
		}
	}

	/**
	 * Returns a message indicating whether the input file has unmatched
	 * symbols. (Use the methods below for constructing messages.) Throws
	 * FileNotFoundException if the file does not exist.
	 */

	// 1. Make an empty stack.

	// 2. Read symbols until the end of the file.
	// a. If the symbol is an opening symbol, push it onto the stack.
	// b. If it is a closing symbol, do the following.
	// i. If the stack is empty, report an error.
	// ii. Otherwise, pop the stack. If the symbol popped is not the
	// corresponding opening symbol, report an error.

	// 3. At the end of the file, if the stack is not empty, report an
	// error.

	// BalancedSymbolChecker p;

	public String checkFile(String filename) throws FileNotFoundException {

		// Line count
		int lineCount = 0;
		// Column Count
		int columnCount;
		// File object being read in
		File f = new File(filename);
		// Scanner object to scan text
		Scanner symbolScanner = new Scanner(f);
		// Stack to store Character/Symbol objects
		LinkedListStack<Character> stack = new LinkedListStack<>();
		while (symbolScanner.hasNextLine()) {
			columnCount = 0;
			lineCount++;
			
			char[] charsSymbolArray = symbolScanner.nextLine().toCharArray();
			for (int i = 0; i < charsSymbolArray.length; i++) {

				if (charsSymbolArray[i] == '(' || charsSymbolArray[i] == '[' || charsSymbolArray[i] == '{') {
					stack.push(getSymbol(charsSymbolArray[i]));
				}

				if (charsSymbolArray[i] == ')' || charsSymbolArray[i] == ']' || charsSymbolArray[i] == '}') {
					stack.pop();
					if (stack.isEmpty()) {
						// If the stack is empty and you return the right char
						// character
						return unmatchedSymbolAtEOF(' ');
					}

				}

				//
				if ((this.stack.pop() == ')')) {
					return unmatchedSymbolAtEOF(')');
				}

			}

		}

		return filename;

	}

	char getSymbol(char charsSymbolArray) {

		return charsSymbolArray;
	}

	/**
	 * Returns an error message for unmatched symbol at the input line and
	 * column numbers. Indicates the symbol match that was expected and the
	 * symbol that was read.
	 */
	private String unmatchedSymbol(int lineNumber, int colNumber, char symbolRead, char symbolExpected) {
		return "ERROR: Unmatched symbol at line " + lineNumber + " and column " + colNumber + ". Expected "
				+ symbolExpected + ", but read " + symbolRead + " instead.";
	}

	/**
	 * Returns an error message for unmatched symbol at the end of file.
	 * Indicates the symbol match that was expected.
	 */
	private String unmatchedSymbolAtEOF(char symbolExpected) {
		return "ERROR: Unmatched symbol at the end of file. Expected " + symbolExpected + ".";
	}

	/**
	 * Returns an error message for a file that ends with an open /* comment.
	 */
	private String unfinishedComment() {
		return "ERROR: File ended before closing comment.";
	}

	/**
	 * Returns a message for a file in which all symbols match.
	 */
	private String allSymbolsMatch() {
		return "No errors found. All symbols match.";
	}
}