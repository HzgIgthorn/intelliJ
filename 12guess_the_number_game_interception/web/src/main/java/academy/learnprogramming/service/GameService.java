package academy.learnprogramming.service;

public interface GameService {

    boolean isGameOver();
    String getMainMessge();
    String getResultMessage();
    void checkGuess(int guess);
    void reset();
}
