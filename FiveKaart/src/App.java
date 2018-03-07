import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

	public static void main(String[] args) throws IOException {

		Scanner scanner = new Scanner(System.in);
		int amountOfLines = Integer.parseInt(scanner.nextLine());

		String[] rang = new String[13];
		rang[0] = "A";
		rang[1] = "2";
		rang[2] = "3";
		rang[3] = "4";
		rang[4] = "5";
		rang[5] = "6";
		rang[6] = "7";
		rang[7] = "8";
		rang[8] = "9";
		rang[9] = "10";
		rang[10] = "B";
		rang[11] = "V";
		rang[12] = "H";

		String[] types = new String[4];
		types[0] = "K";
		types[1] = "R";
		types[2] = "H";
		types[3] = "S";

		ArrayList<String> deckOfCards = new ArrayList<>();

			for (int i = 0; i < rang.length; i++) {
				for (int j = 0; j < types.length; j++) {
					deckOfCards.add(types[j] + rang[i]);
				}
			}

		for (int i = 0; i < amountOfLines; i++) {
			String line = scanner.nextLine();
			char type = line.charAt(0);
			String cards[] = line.split(" ");
			int waardes[] = new int[4];

			for (int j = 0; j < waardes.length; j++) {
				waardes[j] = deckOfCards.indexOf(cards[j]);
			}

			String waarde = "";

			if (waardes[1] < waardes[2] && waardes[2] < waardes[3]) { 
				waarde = deckOfCards.get((waardes[0] + 4) % 52).substring(1);
			} else if (waardes[1] < waardes[2] && waardes[2] > waardes[3]) {
				waarde = deckOfCards.get((waardes[0] + 8) % 52).substring(1);
			} else if (waardes[1] > waardes[2] && waardes[1] < waardes[3]) {
				waarde = deckOfCards.get((waardes[0] + 12) % 52).substring(1);
			} else if (waardes[1] < waardes[2] && waardes[1] > waardes[3]) {
				waarde = deckOfCards.get((waardes[0] + 16) % 52).substring(1);
			} else if (waardes[1] > waardes[2] && waardes[2] < waardes[3]) {
				waarde = deckOfCards.get((waardes[0] + 20) % 52).substring(1);
			} else if (waardes[1] > waardes[2] && waardes[2] > waardes[3]) {
				waarde = deckOfCards.get((waardes[0] + 24) % 52).substring(1);
			}
			System.out.println(i + 1 + " " + type + waarde);
		}

	}
}
