package academy.learnprogramming;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Slf4j
@Getter
public class GameImpl implements Game {

    //== fields ==
    @Getter(AccessLevel.NONE)
    private final NumberGenerator numberGenerator;

    private final int guessCount;
    private int number;
    private int smallest;
    private int biggest;
    private int remainingGuesses;
    private boolean validNumberRange = true;

    @Setter
    private int guess;

    //== constructors==
    @Autowired
    public GameImpl(NumberGenerator numberGenerator, @GuessCount int guessCount) {
        this.numberGenerator = numberGenerator;
        this.guessCount = guessCount;
    }

    //== init ==
    @Override
    @PostConstruct
    public void reset() {
        log.debug("***Starting reset()***");
        this.smallest = numberGenerator.getMinNumber();
        this.guess = numberGenerator.getMinNumber();
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
