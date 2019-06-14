package academy.learnprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HalloMaven {

    private final static Logger log = LoggerFactory.getLogger(HalloMaven.class);

    public static void main(String[] args) {
        System.out.println("Hallo Maven");
        log.info("Hallo Info");
        log.debug("Hello Debug");
    }
}
