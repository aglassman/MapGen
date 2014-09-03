package mapgen.map;

public class HeightMap {
    public final int WIDTH;
    public final int HEIGHT;

    public float get(int row, int column) {
        return map[column][row];
    }

    public void set(float val, int row, int column) {
        map[column][row] = val;
    }

    public HeightMap(int width, int height) {
        WIDTH = width;
        HEIGHT = height;

        map = new float[width][height];
    }

    private float[][] map;
}
