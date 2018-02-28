import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int amountOfLists = scanner.nextInt();


        int max = 0;
        int min = Integer.MAX_VALUE;


        for(int list = 0; list  < amountOfLists ; list ++){

            int amountOfNumbersPerList = scanner.nextInt();

            for (int row = 0; row < amountOfNumbersPerList; row++) {

               int currentNumber = scanner.nextInt();

                if( currentNumber < min){
                    min = currentNumber;
                }

                if (currentNumber > max){
                    max = currentNumber;
                }


            }
            System.out.println((list + 1) + " " + min + " "  + max );

            max = 0;
            min = Integer.MAX_VALUE;

            }
    }

}
