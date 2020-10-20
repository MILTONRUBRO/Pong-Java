package br.com.devmos.pong.models;

import java.awt.Color;
import java.awt.Graphics;

public class Player {
	
	private static final int WIDTH = 40;
	private static final int HEIGHT = 10;
	private int x = 100;
	private int y = 110;
	public  boolean right;
	public boolean left;
	
	public Player(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void update() {
		if(left) {
			x++;
		}else if(right) {
			x--;
		}
	}
	
	public void render(Graphics graphics) {
		graphics.setColor(Color.blue);
		graphics.fillRect(x, y, WIDTH, HEIGHT);;
	}

}
