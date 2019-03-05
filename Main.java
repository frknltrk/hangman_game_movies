import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan=new Scanner(System.in);
        Game myGame = new Game();
        myGame.createList();
        myGame.chooseRandom();
        myGame.makeUnderscored();
        myGame.setPoint();

        while(myGame.point>0 && myGame.hasUnderscore) {
            System.out.print("Guess!");
            myGame.showUnderscored(); //shows "______"
            String letter = scan.nextLine(); //takes a letter from user

            if(myGame.isEqual(letter)){
                System.out.print("Well Done!");
                break;
            }

            if(myGame.letterChecker(letter)){
                myGame.revealLetters(letter);
            }
            else{
                myGame.point--;
            }
            myGame.underscoreChecker();
        }
        if(myGame.point==0){
            System.out.println("Sorry, you've lost.");
            System.out.print(myGame.revealChoosenOne());
        }
    }
}