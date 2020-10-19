package br.com.devmos.pong.models;

import java.awt.Color;
import java.awt.Graphics;

public class Player {
	
	private static final int WIDTH = 40;
	private static final int HEIGHT = 10;
	private int x = 200;
	private int y = 110;

	public void update() {
		
	}
	
	public void render(Graphics graphics) {
		graphics.setColor(Color.blue);
		graphics.fillRect(x, y, WIDTH, HEIGHT);;
	}

}
