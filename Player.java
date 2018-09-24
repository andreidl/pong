package myPong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Player implements Runnable {

	int x, y, yDirection, id;

	public Rectangle player;

	public Player(int xPlayer, int yPlayer, int idPlayer) {
		this.x = xPlayer;
		this.y = yPlayer;
		this.id = idPlayer;
		player = new Rectangle(x, y, 10, 50);
	}

	public int getYDirection() {
		return yDirection;
	}

	public void setYDirection(int yDir) {
		yDirection = yDir;
	}

	@Override
	public void run() {
		try {
			while (true) {
				move();
				Thread.sleep(7);
			}
		} catch (Exception e) {

		}
	}

	private void move() {
		player.y += getYDirection();
		if (player.y <= 15)
			player.y = 15;
		if (player.y >= 340)
			player.y = 340;

	}

	public void draw(Graphics g) {
		switch (id) {
		default:
			System.out.println("Please enter a Valid ID in paddle contructor");
			break;
		case 1:
			g.setColor(Color.CYAN);
			g.fillRect(player.x, player.y, player.width, player.height);
			break;
		case 2:
			g.setColor(Color.pink);
			g.fillRect(player.x, player.y, player.width, player.height);
			break;
		}
	}

	public void keyPressed(KeyEvent e) {
		switch (id) {
		default:
			System.out.println("Please enter a Valid ID in paddle contructor");
			break;
		case 1:
			if (e.getKeyCode() == KeyEvent.VK_W)
				setYDirection(-1);

			if (e.getKeyCode() == KeyEvent.VK_S)
				setYDirection(1);

			break;

		case 2:
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				setYDirection(-1);
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				setYDirection(1);
			}
			break;
		}

	}

	public void keyReleased(KeyEvent e) {
		switch (id) {
		default:
			System.out.println("Please enter a Valid ID in paddle contructor");
			break;
		case 1:
			if (e.getKeyCode() == KeyEvent.VK_UP)
				setYDirection(0);

			if (e.getKeyCode() == KeyEvent.VK_DOWN)
				setYDirection(0);

			break;
		case 2:

			if (e.getKeyCode() == KeyEvent.VK_W)
				setYDirection(0);

			if (e.getKeyCode() == KeyEvent.VK_S)
				setYDirection(0);

			break;
		}
	}

}
