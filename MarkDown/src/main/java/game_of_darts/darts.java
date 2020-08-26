package game_of_darts;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
public class darts {
    public static int score(float x, float y)
    {
        float distance = (float) sqrt(pow(x,2) + pow(y,2));

        if (distance <= 1)
            return 10;
        if (distance <= 5)
            return 5;
        if (distance <= 10)
            return 1;
        return 0;
    }

    public static void main(String []args)
    {
    System.out.println(score(0,5));
    }
}
