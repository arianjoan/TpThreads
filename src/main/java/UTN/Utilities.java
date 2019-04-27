package UTN;

import java.util.Random;

public class Utilities {

    private static Random random = new Random(System.currentTimeMillis());

    public static Random getRandom() {
        return random;
    }
}
