package au.edu.jcu.guesstheceleb;

import org.junit.Test;

import static org.junit.Assert.*;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import au.edu.jcu.guesstheceleb.game.Game;
import au.edu.jcu.guesstheceleb.game.Question;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class GameUnitTest {

    private String[] possibleNames= {"brad pitt"};
    private String guess = "brad pitt";
    private Bitmap celebrityImage;

    @Test
    public void check_isCorrect() {

//        assertTrue(check(guess));

    }

//    @Test
//    public void testGame(){
//
//        Question[] questions = new Question[3];
//        String[] answers = new String[]{"bob", "jane", "harry"};
//        for(int i = 0; i < 3; i++)
//            questions[i] = new Question(answers[i], null, answers);
//
//        Game game = new Game(questions);
//
//        while(!game.isGameOver()){
//
//            Question question = game.next();
//            game.updateScore(question.check("bob"));
//
//        }
//
//        assertEquals("Score: 1/3", game.getScore());
//    }
//
}
