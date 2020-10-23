package br.com.devmos.pong.models;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import br.com.devmos.pong.main.Game;

public class Ball {
	
	private double x;
	private double y;
	private static int WIDTH = 4;
	private static int HEIGHT = 4;
	
	private double dx;
	private double dy;
	private double speed = 1.2;

	
	public Ball(int x, int y) {
		this.x = x;
		this.y = y;
		
		dx = new Random().nextGaussian();
		dy = new Random().nextGaussian();

	}
	
	public void update() {
		
		if(x + (dx * speed) + WIDTH >= Game.WIDTH) {
			dx *= -1;
		}else if(x + (dx * speed) < 0) {
			dx *= -1;
		}
		
		if(y >= Game.HEIGHT) {
			
		}else if(y < 0) {
			
		}
		
		Rectangle bounds = new Rectangle((int)(x + (dx * speed)), (int)(y + (dy * speed)), WIDTH, HEIGHT);
		Rectangle boundsPlayer = new Rectangle(Game.player.getX(), Game.player.getY(),Game.player.getWidth(), Game.player.getHeight());
		Rectangle boundsEnemy = new Rectangle((int)Game.enemy.getX(), (int)Game.enemy.getY(),Game.enemy.getWIDTH(), Game.enemy.getHEIGHT());
		
		x += dx * speed;
		y += dy * speed;
		
		if(bounds.intersects(boundsPlayer)) {
			dy *= -1;
		}else if(bounds.intersects(boundsEnemy)) {
			dy *= -1;
		}
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
