package academy.learnprogramming;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component(NumberGenerator.GENERATOR)
public class NumberGeneratorImp implements NumberGenerator{

    //== fields ==
    private final Random random = new Random();
    private int naxNumber = 100;

    //== public methods ==
    @Override
    public int next() {
        return random.nextInt(this.naxNumber);
    }

    @Override
    public int getMaxNumber() {
        return this.naxNumber;
    }
}
