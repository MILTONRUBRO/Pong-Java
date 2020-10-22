package br.com.devmos.pong.models;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Ball {
	
	private double x;
	private double y;
	private static int WIDTH = 4;
	private static int HEIGHT = 4;
	
	private double dx;
	private double dy;
	private double speed = 0.4;

	
	public Ball(int x, int y) {
		this.x = x;
		this.y = y;
		
		dx = new Random().nextGaussian();
		dy = new Random().nextGaussian();

	}
	
	public void update() {
		x += dx * speed;
		y += dy * speed;

	}
	
	public void render(Graphics graphics) {
		graphics.setColor(Color.green);
		graphics.fillRect((int)x, (int)y, WIDTH, HEIGHT);;
	}
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

}
