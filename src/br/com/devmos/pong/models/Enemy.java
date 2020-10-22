package br.com.devmos.pong.models;

import java.awt.Color;
import java.awt.Graphics;

import br.com.devmos.pong.main.Game;

public class Enemy {
	
	private double x;
	private double y;
	private static int WIDTH = 40;
	private static int HEIGHT = 10;

	
	public Enemy(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void update() {
		x += (Game.ball.getX() - x);
	}
	
	public void render(Graphics graphics) {
		graphics.setColor(Color.red);
		graphics.fillRect((int)x, (int)y, WIDTH, HEIGHT);;
	}

}
