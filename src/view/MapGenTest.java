package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;

import map.HeightMap;
import map.MapGenerator;
import map.VoronoiDiagram;

public class MapGenTest {
    public static void main(String... args) {
    	new MapGenTest();
    }
    
    public MapGenTest() {
        generator = new VoronoiDiagram(100);

        float seaLevel = 0.4f;
        float grassLevel = 0.8f;

        view = new MapView(
        		new float[]{seaLevel, grassLevel},
        		new Color[]{Color.BLUE, new Color(25, 80, 25), Color.DARK_GRAY});
        view.setPreferredSize(new Dimension(500, 500));
        
        generate();
        
        JButton genButton = new JButton("Generate");
        genButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generate();
			}
		});
        
        JFrame window = new JFrame();
        window.getContentPane().setLayout(new FlowLayout());
        window.getContentPane().add(view);
        window.getContentPane().add(genButton);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.setVisible(true);
    }
    
    private void generate() {
    	Random random = new Random();
        HeightMap map = generator.generate(random, 500, 500);
        view.setMap(map);
    }
    
    private MapGenerator generator;
    private MapView view;
}
