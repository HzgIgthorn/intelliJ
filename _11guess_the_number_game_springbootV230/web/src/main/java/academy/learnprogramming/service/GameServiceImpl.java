package academy.learnprogramming.service;

import academy.learnprogramming.Game;
import academy.learnprogramming.MessageGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Slf4j
public class GameServiceImpl implements GameService {

    //==fields==
    private final Game game;
    private final MessageGenerator mg;

    //==constructors=
    @Autowired
    public GameServiceImpl(Game game, MessageGenerator mg) {
        this.game = game;
        this.mg = mg;
    }

    //==public methods
    @PostConstruct
    public void init(){
        log.debug("Die zu schätzende Zahl ist {}",game.getNumber());
        log.debug("Die Hauptnachricht ist {}",mg.getMainMessage());
    }

    @Override
    public boolean isGameOver() {
        return game.isGameWon() || game.isGameLost();
    }

    @Override
    public String getMainMessge() {
        return mg.getMainMessage();
    }

    @Override
    public String getResultMessage() {
        return mg.getResultMessage();
    }

    @Override
    public void checkGuess(int guess) {
        game.setGuess(guess);
        game.check();
    }

    @Override
    public void reset() {
        game.reset();
    }
}
