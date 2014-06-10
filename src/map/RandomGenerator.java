package map;

import java.util.Random;

public class RandomGenerator implements MapGenerator {

    public HeightMap generate(Random random, int width, int height) {
        HeightMap map = new HeightMap(width, height);
        for (int col = 0; col<width; ++col) {
            for (int row = 0; row<height; ++row)
                map.set(random.nextFloat(), row, col);
        }
        return map;
    }
}
