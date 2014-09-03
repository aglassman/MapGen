package mapgen.map;

import java.util.Random;

public interface MapGenerator {

    public HeightMap generate(Random random, int width, int height);
}
