package academy.learnprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameImpl implements Game {

    //== constants ==
    private static final Logger log = LoggerFactory.getLogger(GameImpl.class);

    //== fields ==
    @Autowired
    private NumberGenerator numberGenerator;
    private  int guessCount = 10;
    private int number;
    private int guess;
    private int smallest;
    private int biggest;
    private int remainingGuesses;
    private boolean validNumberRange = true;

    //== init ==
    @Override
    public void reset() {
        this.smallest = 0;
        this.guess = 0;
        this.remainingGuesses = this.guessCount;
        this.biggest = numberGenerator.getMaxNumber();
        this.number = numberGenerator.next();
        log.debug("the number is {}", number);
    }

    public void preDestroyed(){
        log.info("in Game preDestroy()");
    }

    //== public methods
    @Override
    public int getNumber() {
        return this.number;
    }

    @Override
    public int getGuess() {
        return this.guess;
    }

    @Override
    public void setGuess(int guess) {
        this.guess = guess;
    }

    @Override
    public int getSmallest() {
        return this.smallest;
    }

    @Override
    public int getBiggest() {
        return this.biggest;
    }

    @Override
    public int getRemainingGuesses() {
        return this.remainingGuesses;
    }

    @Override
    public void check() {
        checkVaildNumberRange();
        if(this.validNumberRange){
            if(guess > number){
                biggest = guess -1;
            }
            if(guess < number){
                smallest = guess +1;
            }
        }
        remainingGuesses--;
    }

    @Override
    public boolean isValidNumberRange() {
        return this.validNumberRange;
    }

    @Override
    public boolean isGameWon() {
        return guess == number;
    }

    @Override
    public boolean isGameLost() {
        return !isGameWon() && remainingGuesses <= 0;
    }

    //== private methods ==
    private void checkVaildNumberRange(){
        this.validNumberRange=(guess >= smallest) && (guess <= biggest);
    }
}
