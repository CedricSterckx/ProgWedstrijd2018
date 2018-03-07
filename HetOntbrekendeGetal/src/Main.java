import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {

		Scanner scanner = new Scanner(System.in);

		int amountOfLines = Integer.parseInt(scanner.nextLine());

		for (int line = 1; line < amountOfLines + 1; line++) {

			int size = 3;

			String currentLine = scanner.nextLine();
			//System.out.println(currentLine);

			int firstNumber = Integer.parseInt(currentLine.substring(0, size));
			int lastNumber = Integer.parseInt(currentLine.substring(currentLine.length() - size));

			//System.out.println("First number: " + firstNumber + ", last number: " + lastNumber);

			int difference = lastNumber - firstNumber;
			//System.out.println("Difference: " + difference);

			int amountOfNumbersGiven = currentLine.length() / size;
			//System.out.println("AmountOfNumbersGiven: " + amountOfNumbersGiven);
			
			if(difference == amountOfNumbersGiven) {

				String[] numbers = currentLine.split("(?<=\\G...)");
				int posWrong = 0;
				int wrongAmount = 0;
				
				for (int i = 0; i < difference; i++) {
					if(i + 1 < numbers.length) {
						int curNumber = Integer.parseInt(numbers[i]);
						int nextNumber = Integer.parseInt(numbers[i + 1]);
						
						if(!(curNumber == (nextNumber - 1))) {
							posWrong = i;
							wrongAmount++;
						}
					}
				}
				
				if(wrongAmount == 1) {
					System.out.println(line + " " + (Integer.parseInt(numbers[posWrong]) + 1));
				} else {
					System.out.println(line + " geen ontbrekend getal");
				}
				
			} else {
				System.out.println(line + " geen ontbrekend getal");
			}

		}

	}

}
