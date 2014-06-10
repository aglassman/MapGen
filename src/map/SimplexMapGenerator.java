package map;

import java.util.Random;

public class SimplexMapGenerator implements MapGenerator {

    public HeightMap generate(Random random, int width, int height) {
        HeightMap map = new HeightMap(width, height);

        float frequency = 1.0f / width * 4;

        // Assign each point the value of the closest node
        for (int row = 0; row<height; ++row) {
            for (int col = 0; col<width; ++col) {
                float val = (float)SimplexNoise.noise(col*frequency, row*frequency);
                map.set(val, row, col);
            }
        }

        return map;
    }
}
