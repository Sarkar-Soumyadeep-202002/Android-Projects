package au.edu.jcu.guessinggame;

import java.util.Random;
public class Game {
    private int answer;

    public Game(){
        Random rand = new Random();
        answer = rand.nextInt(10) + 1;
    }
     public boolean check(int number){

        return number == answer;
     }
}
