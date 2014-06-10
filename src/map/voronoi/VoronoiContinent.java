package map.voronoi;

import java.util.Random;

import map.HeightMap;
import map.MapGenerator;

public class VoronoiContinent extends VoronoiDiagram implements MapGenerator {

	public HeightMap generate(Random random, int width, int height) {
		HeightMap map = new HeightMap(width, height);

        VoronoiPoint[] points = new VoronoiPoint[numPoints];
        for (int i = 0; i<numPoints; ++i)
            points[i] = randomPoint(random, width, height);
        
        // Set each point that hits the edge to be ocean
        for (int x = 0; x<width; ++x) {
        	closestVoronoi(0, x, points).value = 0f;
        	closestVoronoi(height-1, x, points).value = 0f;
        }
        if (sides) {
	        for (int y = 0; y<height; ++y) {
	        	closestVoronoi(y, 0, points).value = 0f;
	        	closestVoronoi(y, width-1, points).value = 0f;
	        }
        }
        
        // Assign each point the value of the closest node
        for (int row = 0; row<height; ++row) {
            for (int col = 0; col<width; ++col) {
                float val = closestVoronoi(row, col, points).value;
                map.set(val, row, col);
            }
        }

        return map;
	}
	
	public VoronoiContinent(int numPoints) {
		super(numPoints);
		sides = false;
	}
	
	private boolean sides;
}
