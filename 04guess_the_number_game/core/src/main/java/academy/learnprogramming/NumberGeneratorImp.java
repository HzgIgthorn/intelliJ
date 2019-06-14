package academy.learnprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

public class NumberGeneratorImp implements NumberGenerator{

    //== fields ==
    private final Random random = new Random();
    @Autowired
    @MaxNumber
    private int maxNumber;

    @Autowired
    @MinNumber
    private int minNumber;

    private static final Logger log = LoggerFactory.getLogger(NumberGeneratorImp.class);

    //== public methods ==
    @Override
    public int next() {
        return random.nextInt(this.maxNumber-this.minNumber) + this.minNumber;
    }

    @Override
    public int getMaxNumber() {
        return this.maxNumber;
    }

    @Override
    public int getMinNumber() {
        return this.minNumber;
    }


}
