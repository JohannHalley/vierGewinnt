package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import java.util.Observable;
import java.util.Observer;

import controller.ViewController;
import model.Spiel;
import model.Spielbrett;
import model.Spielstein;

public class JSpielbrett extends JPanel implements Observer {
	private static final long serialVersionUID = 1L;
	private Spielbrett spielbrett = null;
	private int nextStein = -1;

	private final class PointMoveListener extends MouseAdapter {

		@Override
		public void mouseMoved(MouseEvent e) {
			nextStein = e.getX() / 50;
			repaint();
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			Spielstein spielstein  = ViewController.INSTANCE.nextSchritt(e.getX() / 50);
			repaint();
			try {
				ViewController.INSTANCE.isGewinnt(spielstein);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}

	public JSpielbrett() {
		addMouseMotionListener(new PointMoveListener());
		addMouseListener(new PointMoveListener());
	}

	@Override
	public void update(Observable o, Object arg) {
		spielbrett = ((Spiel) o).getletztSpielbrett();		
		repaint();
	}

	protected void paintComponent(Graphics g) {
		final Graphics2D g2d = (Graphics2D) g;

		// Hintergrund erstellen
		g.setColor(new Color(42, 108, 228));
		g.fillRoundRect(0, 0, 354, 304, 25, 25);

		// Spielsteine erstellen
		for (int i = 0; i < 42; i++) {
			paintSpielstein(g2d, (spielbrett.getSpielsteins())[i]);
		}

		// oberen Spielstein erstellen
		paintNextSpielstein(g2d, nextStein);
	}

	public void paintSpielstein(Graphics2D g2d, Spielstein spielstein) {
		g2d.setColor(spielstein.getColor().getColor());
		g2d.fillOval(2 + spielstein.getCol() * 50, 2 + spielstein.getRow() * 50, 48, 48);
	}

	public void paintNextSpielstein(Graphics2D g2d, int nextStein) {
		g2d.setColor(spielbrett.getNextColor().getColor());
		g2d.fillOval(2 +  nextStein * 50, 2, 48, 48);
	}

}