import java.io.IOException;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Scanner;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(Paths.get("resources/puzzels.txt"));
		
		int amountOfPuzzelz = scanner.nextInt();
		int sizeOfPuzzle = scanner.nextInt();
		int[][] currentPuzzle;
		String puzzleRow = "";
		boolean correct = true;
		
		for (int puzzel = 0; puzzel < amountOfPuzzelz; puzzel++) {
			currentPuzzle = new int[sizeOfPuzzle][sizeOfPuzzle];
		
			for (int row = 0; row < sizeOfPuzzle; row++) {
				puzzleRow = scanner.next();
				
				for (int column = 0; column < sizeOfPuzzle; column++) {
					currentPuzzle[row][column] = Integer.parseInt(puzzleRow.substring(column, column+1));
				}
			}
			
			for (int row = 0; row < sizeOfPuzzle; row++) {

				int countSameNumberRow = 1, countSameNumberCol = 1;
				if(countSameNumberRow == 3 || countSameNumberCol == 3) {
					StringBuilder stringBuilder = new StringBuilder();
					for (int col = 0; col < sizeOfPuzzle; col++) {
						stringBuilder.append(currentPuzzle[0][col]);
					}
					stringBuilder.append(" fout");
					System.out.println(stringBuilder.toString());
				}
				for(int col = 0; col < sizeOfPuzzle; col++) {
					System.out.println(col + " " + sizeOfPuzzle);
					int number = currentPuzzle[row][col];
					if(col + 1 < sizeOfPuzzle) {
						if(number == currentPuzzle[row][col+1]) {
							countSameNumberRow++;
						} else {
							countSameNumberRow = 1;
						}
					}
					
					if(row + 1 < sizeOfPuzzle) {
						if(number == currentPuzzle[row + 1][col]) {
							countSameNumberCol++;
						} else {
							countSameNumberCol = 1;
						}
					}
				}				
			}
			if(!correct) {
				System.out.println("!correct");
			} else {
				System.out.println("correct");
			}
			correct = true;

			sizeOfPuzzle = scanner.nextInt();
		}
	}
}
