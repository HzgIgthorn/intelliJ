package academy.learnprogramming;

public interface NumberGenerator {

    public static final String GENERATOR = "numberGenerator";

    int next();

    int getMaxNumber();

    int getMinNumber();
}
