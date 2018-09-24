package myPong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Ball implements Runnable {
	int x, y, xDirection, yDirection;

	Rectangle ball;

	 int p1score;

	 int p2score;

	 Player p1 = new Player(10, 25, 1);
	 Player p2 = new Player(485, 25, 2);

	public Ball(int xBall, int yBall) {
		p1score = p2score = 0;
		this.x = xBall;
		this.y = yBall;

		Random r = new Random();
		moveBall(r);

		ball = new Rectangle(this.x, this.y, 15, 15);
		
	}
	

	public void draw(Graphics gb) {
		gb.setColor(Color.white);
		gb.fillOval(ball.x, ball.y, 15, 15);

	}
	
	public void setXDirection(int xDir) {
		xDirection = xDir;
	}

	public void setYDirection(int yDir) {
		yDirection = yDir;
	}

	@Override
	public void run() {
		try {
			while (Main1.isJogo()) {

				move();
				Thread.sleep(8);
			}
		} catch (Exception e) {
			Main1.setJogo(false);
		}

	}

	private void move() {

		collision();
		ball.x += xDirection;
		ball.y += yDirection;
		// bounce the ball when it hits the edge of the screen
		if (ball.x <= 0) {
			setXDirection(+1);
			p2score++;
			ball.setLocation(x, y);

		}
		if (ball.x >= 485) {
			setXDirection(-1);
			p1score++;
			ball.setLocation(x, y);
		}

		if (ball.y <= 15) {
			setYDirection(+1);
		}

		if (ball.y >= 385) {
			setYDirection(-1);
		}

	}

	private void moveBall(Random r) {
		int rXDir = r.nextInt(1);
		if (rXDir == 0)
			rXDir--;
		setXDirection(rXDir);

		int rYDir = r.nextInt(1);
		if (rYDir == 0)
			rYDir--;
		setYDirection(rYDir);
	}

	private void collision() {
		if (ball.intersects(p1.player))
			setXDirection(+1);
		if (ball.intersects(p2.player))
			setXDirection(-1);

	}



}
