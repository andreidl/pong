package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Bola implements Runnable {

	int x, y, xDirection, yDirection;

	Rectangle bola;

	int p1ponto, p2ponto;

	Jogador p1 = new Jogador(10, 25, 1);
	Jogador p2 = new Jogador(485, 25, 2);

	public Bola(int xBall, int yBall) {
		p1ponto = p2ponto = 0;
		this.x = xBall;
		this.y = yBall;

		Random r = new Random();
		moveBola(r);

		bola = new Rectangle(this.x, this.y, 15, 15);
	}

	private void moveBola(Random r) {
		int rXDir = r.nextInt(1);
		if (rXDir == 0)
			rXDir--;
		setxDirection(rXDir);
		int rYDir = r.nextInt(1);
		if (rYDir == 0)
			rYDir--;
		setyDirection(rYDir);
	}

	public void draw(Graphics gb) {
		gb.setColor(Color.WHITE);
		gb.fillOval(bola.x, bola.y, 15, 15);
	}

	public void setxDirection(int xDirection) {
		this.xDirection = xDirection;
	}

	public void setyDirection(int yDirection) {
		this.yDirection = yDirection;
	}

	@Override
	public void run() {
		try {
			while (Game.isJogo()) {
				move();
				Thread.sleep(8);
			}
		} catch (Exception e) {
			Game.setJogo(false);
		}

	}

	private void move() {
		colisao();
		bola.x += xDirection;
		bola.y += yDirection;

		if (bola.x <= 0) {
			setxDirection(+1);
			p2ponto++;
			bola.setLocation(x, y);
		}
		if (bola.x >= 485) {
			setxDirection(-1);
			p1ponto++;
			bola.setLocation(x, y);
		}
		if (bola.y <= 15) {
			setyDirection(+1);
		}
		if (bola.y >= 385) {
			setyDirection(-1);
		}

	}

	private void colisao() {
		if(bola.intersects(p1.jogador))
			setxDirection(+1);
		if(bola.intersects(p2.jogador))
			setxDirection(-1);
		
	}

}
