package br.com.devmos.pong.models;

import java.awt.Color;
import java.awt.Graphics;

import br.com.devmos.pong.main.Game;

public class Player {
	
	private static final int WIDTH = 40;
	private static final int HEIGHT = 5;
	private int x = 100;
	private int y = 110;
	private  boolean right;
	private boolean left;
	
	public Player(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void update() {
		if(right) {
			x++;
		}else if(left) {
			x--;
		}
		
		if(x + WIDTH > Game.WIDTH) {
			x =  Game.WIDTH - WIDTH;
		}
		
		if(x < 0) {
			x = 0;
		}
	}
	
	public void render(Graphics graphics) {
		graphics.setColor(Color.blue);
		graphics.fillRect(x, y, WIDTH, HEIGHT);;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public static int getWidth() {
		return WIDTH;
	}

	public static int getHeight() {
		return HEIGHT;
	}
	
}
