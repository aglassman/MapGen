package map.voronoi;

public class VoronoiPoint {
    int col;
    int row;
    float value;

    VoronoiPoint(int row, int col, float value) {
        this.col = col;
        this.row = row;
        this.value = value;
    }
}
