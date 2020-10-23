package br.com.devmos.pong.models;

import java.awt.Color;
import java.awt.Graphics;

import com.sun.javafx.geom.Rectangle;

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
		x += (Game.ball.getX() - x - 6);
		
	}
	
	public void render(Graphics graphics) {
		graphics.setColor(Color.red);
		graphics.fillRect((int)x, (int)y, WIDTH, HEIGHT);
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

	public static int getWIDTH() {
		return WIDTH;
	}

	public static void setWIDTH(int wIDTH) {
		WIDTH = wIDTH;
	}

	public static int getHEIGHT() {
		return HEIGHT;
	}

	public static void setHEIGHT(int hEIGHT) {
		HEIGHT = hEIGHT;
	}
	
}
