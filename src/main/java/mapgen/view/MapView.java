package mapgen.view;

import mapgen.map.HeightMap;

import javax.swing.*;
import java.awt.*;

public class MapView extends JPanel {

	private static final long serialVersionUID = 1L;

	@Override
    public void paint(Graphics g) {
        int tileWidth = Math.min(getWidth()/map.WIDTH, getHeight()/map.HEIGHT);

        for (int row = 0; row<map.HEIGHT; ++row) {
            for (int col = 0; col<map.WIDTH; ++col) {
                float val = map.get(row, col);
                Color c = colors[colors.length-1];
                for (int i = 0; i<cutoffs.length; ++i) {
                	if (val < cutoffs[i]) {
                		c = colors[i];
                		break;
                	}
                }
                g.setColor(c);
                g.fillRect(col*tileWidth, row*tileWidth, tileWidth, tileWidth);
            }
        }
    }
	
	public void setMap(HeightMap map) {
		this.map = map;
		repaint();
	}

    public MapView(float[] cutoffs, Color[] colors) {
        this.cutoffs = cutoffs;
        this.colors = colors;
    }

    private HeightMap map;
    private float[] cutoffs;
    private Color[] colors;
}
