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

	

	/**
	 * Symbol represents what will be placed on the stack.
	 */
	private static class Symbol {
		public int line;
		public int colNum;
		public char symbolR;

		public Symbol(int _lineNumber, int _colNumber, char _symbolRead) {
			line = _lineNumber;
			colNum = _colNumber;
			symbolR = _symbolRead;
		}
	}
	public Scanner s;
	public boolean quote = false;
	public boolean singleQuote = false;
	public boolean lineComment = false;
	public boolean multiComment = false;
	int lineCount = 0;

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
	public String checkFile(String filename) throws FileNotFoundException {
		// File object being read in
		File f = new File(filename);
		// Scanner object to scan text
		Scanner symbolScanner = new Scanner(f);
		// Stack to store Character/Symbol objects
		LinkedListStack<Symbol> stack = new LinkedListStack<Symbol>();

		while (symbolScanner.hasNextLine()) {
			lineCount++;
			lineComment =false;
			quote=false;
			singleQuote=false;
			char[] charsSymbolArray = symbolScanner.nextLine().toCharArray();

			for (int j = 0; j < charsSymbolArray.length; j++) {
				quote=false;
				Symbol charSymbol = getSymbol(charsSymbolArray);

				// If char is a openSym push it to the stack
				if (charSymbol.symbolR == '(' || charSymbol.symbolR == '[' || charSymbol.symbolR == '{') {
					stack.push(charSymbol);
				} else if (charSymbol.symbolR == ')' || charSymbol.symbolR == ']' || charSymbol.symbolR == '}') {
					// if stack is already empty and returns a closing brace
					// report the error
					if (stack.size() == 0) {
						// If the stack is empty and you return the right char
						// character
						return unmatchedSymbolAtEOF(' ');

					}

					Symbol match = stack.pop();

					if (match.symbolR == '(' && charSymbol.symbolR != ')') {
						return unmatchedSymbol(charSymbol.line, charSymbol.colNum, charSymbol.symbolR, ')');
					}
					if (match.symbolR == '{' && charSymbol.symbolR != '}') {
						return unmatchedSymbol(charSymbol.line, charSymbol.colNum, charSymbol.symbolR, '}');

					}
					if (match.symbolR == '[' && charSymbol.symbolR != ']') {
						return unmatchedSymbol(charSymbol.line, charSymbol.colNum, charSymbol.symbolR, ']');

					}
				}
			}
		}

		if (multiComment == true) {
			return unfinishedComment();
		}

		if (stack.size() != 0) {
			Symbol res = stack.pop();

			if (res.symbolR == '{') {
				return unmatchedSymbolAtEOF('}');
			}
			if (res.symbolR == '(') {
				return unmatchedSymbolAtEOF(')');

			}
			if (res.symbolR == '[') {
				return unmatchedSymbolAtEOF(']');

			}
		}
		return allSymbolsMatch();
	}

	public Symbol getSymbol(char[] charsSymbolArray) {

		Symbol symbolObject;

		if (charsSymbolArray[0] == '\"') {
			quote = true;
		}

		if (charsSymbolArray[0] == '\'') {
			singleQuote = true;
		}
		if (charsSymbolArray[0] == '/' && charsSymbolArray[1] == '/') {
			lineComment = true;
		}

		if (charsSymbolArray[0] == '/' && charsSymbolArray[1] == '*') {
			multiComment = true;
		}

		if ((charsSymbolArray[0] == '(' || charsSymbolArray[0] == '{' || charsSymbolArray[0] == '[')
				|| charsSymbolArray[0] == '}' || charsSymbolArray[0] == ')'
				|| charsSymbolArray[0] == ']' && multiComment != true) {
			symbolObject = new Symbol(lineCount, 1, charsSymbolArray[0]);
			charsSymbolArray[0] = ' ';
			return symbolObject;
		} else {
			for (int i = 1; i < charsSymbolArray.length; i++) {
				
				if (charsSymbolArray[i] == '\"' && charsSymbolArray[i - 1] != '\\') {
					if (quote == false) {
						quote = true;
					} else if (quote == true) {
						quote = false;
					}
				}

				if (charsSymbolArray[i] == '\'' && charsSymbolArray[i - 1] != '\\') {
					if (singleQuote == false) {
						singleQuote = true;
					} else if (singleQuote == true) {
						singleQuote = false;
					}
				}

				if (charsSymbolArray[i] == '*' && charsSymbolArray[i - 1] == '/') {
					multiComment = true;
				}

				if (multiComment == true && charsSymbolArray[i] == '/' && charsSymbolArray[i - 1] == '*') {
					multiComment = false;
				}

				if (charsSymbolArray[i] == '/' && charsSymbolArray[i - 1] == '/') {
					lineComment = true;
				}

				if ((charsSymbolArray[i] == '(' || charsSymbolArray[i] == '{' || charsSymbolArray[i] == '[')
						|| charsSymbolArray[i] == ')' || charsSymbolArray[i] == '}'
						|| charsSymbolArray[i] == ']' && charsSymbolArray[i - 1] != '\\') {
					
					
					
					if ((multiComment == false && quote == false) && charsSymbolArray[i - 1] != '\''
							&& lineComment != true) {
						symbolObject = new Symbol(lineCount, i + 1, charsSymbolArray[i]);
						charsSymbolArray[i] = ' ';
						return symbolObject;
					}
					
					
					
				}

			}

		}
		return new Symbol(0, 0, ' ');
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