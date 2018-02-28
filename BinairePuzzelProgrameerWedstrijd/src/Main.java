import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.sun.xml.internal.ws.util.StringUtils;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(Paths.get("resources/puzzels.txt"));

		int amountOfPuzzelz = scanner.nextInt();
		int sizeOfPuzzle = scanner.nextInt();

		for (int rule = 0; rule < amountOfPuzzelz; rule++) {
			boolean correct = true;
			int currentPuzzle[][] = new int[sizeOfPuzzle][sizeOfPuzzle];
			ArrayList<String> puzzleRows = new ArrayList<String>();

			for (int rowOfPuzzle = 0; rowOfPuzzle < sizeOfPuzzle; rowOfPuzzle++) {

				String currentLine = scanner.next();

				if (correct) {
					// Check voor regel 4
					// Check voor regel 2 (naast mekaar)
					if (puzzleRows.contains(currentLine) || checkForDoubleDigitsInRow(currentLine)) {
						correct = false;
						puzzleRows.add(currentLine);
					} else {
						puzzleRows.add(currentLine);

						for (int colOfPuzzle = 0; colOfPuzzle < sizeOfPuzzle; colOfPuzzle++) {
							currentPuzzle[rowOfPuzzle][colOfPuzzle] = Character
									.getNumericValue(currentLine.charAt(colOfPuzzle));
						}
					}
				}
			}

			// Check voor regel 2 (onder mekaar)
			if (checkForDoubleDigitsInColumn(currentPuzzle) || !isAmountOfOnesAndZerosCorrect(puzzleRows)) {
				correct = false;
			}

			System.out.println(puzzleRows.get(0) + (correct ? " juist" : " fout"));

			if (rule + 1 != amountOfPuzzelz) {
				sizeOfPuzzle = scanner.nextInt();
			}
		}
	}

	private static boolean isAmountOfOnesAndZerosCorrect(ArrayList<String> puzzleRows) {
		// Moeten niet eentjes en nulletjes tellen. Als er te weinig eentjes
		// zijn, zijn er ook teveel nulletjes. Ook omgekeerd,
		// Dit zou dus dubbel werk creëren en dat is niet nodig.
		int countNeeded = puzzleRows.get(0).length() / 2;

		for (int row = 0; row < puzzleRows.size(); row++) {
			int countOfZeros = (int) puzzleRows.get(row).chars().filter(c -> c == '0').count();

			if (countOfZeros != countNeeded) {
				return false;
			}
		}
		return true;
	}

	private static boolean checkForDoubleDigitsInColumn(int[][] currentPuzzle) {
		int prevNumber;
		int maxSameDigit = 1;

		for (int col = 0; col < currentPuzzle.length; col++) {
			prevNumber = -1;
			for (int row = 0; row < currentPuzzle.length; row++) {
				//System.out.println("R:C" + row + ":" + col + ", prevNumber: " + prevNumber + ", currentNumber: " + currentPuzzle[row][col] + ", maxSameDigit: " + maxSameDigit);
				if (prevNumber == currentPuzzle[row][col]) {
					++maxSameDigit;
					if (maxSameDigit > 2) {
						return true;
					}
				} else {
					prevNumber = currentPuzzle[row][col];
					maxSameDigit = 1;
				}
			}
		}
		return false;
	}

	private static boolean checkForDoubleDigitsInRow(String currentLine) {
		char currentChar = '2';
		int maxSameDigit = 0;

		for (int i = 0; i < currentLine.length(); i++) {

			if (currentLine.charAt(i) == currentChar) {
				maxSameDigit++;
				if (maxSameDigit > 2) {
					return true;
				}
			} else {
				currentChar = currentLine.charAt(i);
				maxSameDigit = 0;
			}

		}
		return false;
	}
}
