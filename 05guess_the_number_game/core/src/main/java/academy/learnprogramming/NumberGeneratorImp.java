package academy.learnprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class NumberGeneratorImp implements NumberGenerator {

    //== fields ==
    private final Random random = new Random();

    private final int maxNumber;

    private final int minNumber;

    private static final Logger log = LoggerFactory.getLogger(NumberGeneratorImp.class);

    //== constructors==
    @Autowired
    public NumberGeneratorImp(@MaxNumber int maxNumber, @MinNumber int minNumber) {
        this.maxNumber = maxNumber;
        this.minNumber = minNumber;
    }

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
