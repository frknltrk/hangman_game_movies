import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Game {
    private File moviesFile;
    private Scanner fileScan;

    public Game() throws FileNotFoundException {
        moviesFile = new File("movies.txt");
        fileScan = new Scanner(moviesFile);
    }

    public int point;
    private int i;
    private String[] list;

    public void createList() {
        i = 0;
        list=new String[25];
        while (fileScan.hasNextLine()) {
            list[i] = fileScan.nextLine();
            i++;
        }
    }

    private String choosenOne;

    public void chooseRandom() {
        double temp = Math.random();
        int indexOfChoosen=(int)(temp*26);
        choosenOne = list[indexOfChoosen];
    }

    private String[] underscoredOne;

    public void makeUnderscored(){
        underscoredOne=new String[50];
        underscoredOne=choosenOne.split("");
        for(i=0;i<underscoredOne.length;i++) {
            underscoredOne[i]="_";
        }
    }

    public void showUnderscored(){
        for(int i=0;i<underscoredOne.length;i++){
            System.out.print(underscoredOne[i]);
        }
    }

    public void revealLetters(String paramLetter){
        int x=choosenOne.indexOf(paramLetter);
        while(x>-1){
            underscoredOne[x]=paramLetter;
            x=choosenOne.indexOf(paramLetter,x+1);
        }
    }

    public boolean hasUnderscore=true;

    public void underscoreChecker(){
        hasUnderscore=false;
        for(i=0;i<underscoredOne.length;i++){
            if(underscoredOne[i]=="_"){
                hasUnderscore=true;
                break;
            }
        }
    }

    public boolean letterChecker(String paramLetter){
        if(choosenOne.indexOf(paramLetter)!=-1){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isEqual(String paramLetter){
        if(choosenOne.equals(paramLetter)){
            return true;
        }
        else{
            return false;
        }
    }

    public String revealChoosenOne(){
        return choosenOne;
    }

    public void setPoint(){
        point=10;
    }
}