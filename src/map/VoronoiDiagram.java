package map;

import java.util.Random;

public class VoronoiDiagram implements MapGenerator {

    public HeightMap generate(Random random, int width, int height) {
        HeightMap map = new HeightMap(width, height);

        VoronoiPoint[] points = new VoronoiPoint[numPoints];
        for (int i = 0; i<numPoints; ++i)
            points[i] = randomPoint(random, width, height);

        // Assign each point the value of the closest node
        for (int row = 0; row<height; ++row) {
            for (int col = 0; col<width; ++col) {
                float val = closestVoronoi(row, col, points).value;
                map.set(val, row, col);
            }
        }

        return map;
    }

    public VoronoiDiagram(int numPoints) {
        this.numPoints = numPoints;
    }

    private VoronoiPoint randomPoint(Random random, int width, int height) {
        int row = random.nextInt(height);
        int col = random.nextInt(width);
        //float val = (float)(SimplexNoise.noise((float)col/30, (float)row/30) / 2 + 0.5);
        float val = random.nextFloat();
        return new VoronoiPoint(row, col, val);
    }

    private VoronoiPoint closestVoronoi(int row, int col, VoronoiPoint[] points) {
        VoronoiPoint close = null;
        double dist = Double.MAX_VALUE;
        for (VoronoiPoint p : points) {
            //double pDist = Math.abs(row - p.row) + Math.abs(col - p.col) for the Manhattan distance
            int dX = Math.abs(row - p.row);
            int dY = Math.abs(col - p.col);
            double pDist = Math.sqrt(dX*dX + dY*dY); // Euclidean distance
            if (pDist < dist) {
                dist = pDist;
                close = p;
            }
        }
        return close;
    }

    private class VoronoiPoint {
        int col;
        int row;
        float value;

        VoronoiPoint(int row, int col, float value) {
            this.col = col;
            this.row = row;
            this.value = value;
        }
    }

    private int numPoints;
}
