package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Jogador implements Runnable {

	int x, y, yDirection, id;

	public Rectangle jogador;

	public Jogador(int xJogador, int yJogador, int idJogador) {
		this.x = xJogador;
		this.y = yJogador;
		this.id = idJogador;

		jogador = new Rectangle(x, y, 10, 50);
	}

	public int getyDirection() {
		return yDirection;
	}

	public void setyDirection(int yDirection) {
		this.yDirection = yDirection;
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
		jogador.y += getyDirection();
		if (jogador.y <= 30) {
			jogador.y = 30;
		}
		if (jogador.y >= 340) {
			jogador.y = 340;
		}
	}
	
	public void draw(Graphics g) {
		switch(id) {
		default:
			System.out.println("Não é um id valido");
			break;
		case 1:
			g.setColor(Color.CYAN);
			g.fillRect(jogador.x, jogador.y, jogador.width, jogador.height);
			break;
		case 2:
			g.setColor(Color.PINK);
			g.fillRect(jogador.x, jogador.y, jogador.width, jogador.height);
			break;
		}
	}
	
	public void keyPressed(KeyEvent e) {
		switch(id) {
		default:
			System.out.println("Não é um id valido");
			break;
		case 1:
			if(e.getKeyCode() == KeyEvent.VK_W)
				setyDirection(-1);
			if(e.getKeyCode() == KeyEvent.VK_S)
				setyDirection(1);
			break;
		case 2:
			if(e.getKeyCode() == KeyEvent.VK_UP)
				setyDirection(-1);
			if(e.getKeyCode() == KeyEvent.VK_DOWN)
				setyDirection(1);
			break;
		}
	}
	
	public void keyReleased(KeyEvent e) {
		switch(id) {
		default:
			System.out.println("Não é um id valido");
			break;
		case 1:
			if(e.getKeyCode() == KeyEvent.VK_W)
				setyDirection(0);
			if(e.getKeyCode() == KeyEvent.VK_S)
				setyDirection(0);
			break;
		case 2:
			if(e.getKeyCode() == KeyEvent.VK_UP)
				setyDirection(0);
			if(e.getKeyCode() == KeyEvent.VK_DOWN)
				setyDirection(0);
			break;
		}
	}

}
