package br.com.devmos.pong.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

import br.com.devmos.pong.models.Ball;
import br.com.devmos.pong.models.Enemy;
import br.com.devmos.pong.models.Player;

public class Game extends Canvas implements Runnable, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static int WIDTH = 240;
	public static int HEIGHT = 120;
	public static int SCALE = 3;

	public Player player;
	public Enemy enemy;
	public static Ball ball;

	private BufferedImage layer = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

	public Game() {
		this.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));
		this.addKeyListener(this);
		player = new Player(100, HEIGHT-10);
		enemy = new Enemy(100, 0);
		ball = new Ball(100, HEIGHT/2 -1);
	}

	public static void main(String[] args) {
		Game game = new Game();

		JFrame frame = new JFrame();
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.add(game);
		frame.pack();
		frame.setVisible(true);

		new Thread(game).start();
	}

	public void update() {
		player.update();
		enemy.update();
		ball.update();
	}

	public void render() {
		BufferStrategy bs = this.getBufferStrategy();

		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		Graphics graphics = layer.getGraphics();
		graphics.setColor(Color.black);
		graphics.fillRect(0, 0, WIDTH, HEIGHT);
		
		//
		player.render(graphics);
		enemy.render(graphics);
		ball.render(graphics);
		
		graphics = bs.getDrawGraphics();
		
		graphics.drawImage(layer, 0, 0, WIDTH * SCALE, HEIGHT * SCALE, null);
		bs.show();
	}

	@Override
	public void run() {
		//foca diretamente na janela do jogo
		requestFocus();
		
		while (true) {
			update();
			render();

			try {
				Thread.sleep(1000 / 60);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.setRight(true);
		}else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.setLeft(true);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.setRight(false);
		}else if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.setLeft(false);
		}		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}
