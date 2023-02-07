package controller;

import java.util.Observer;
import javax.swing.JOptionPane;

import model.Spielstein;
import view.MainFrame;

public enum ViewController {
	INSTANCE;

	public Spielstein nextSchritt(int n) {
		Spielstein spielstein = null;

		try {
			spielstein = SpielController.INSTANCE.steinfallen(n);
		} catch (VollException e) {
			JOptionPane.showMessageDialog(MainFrame.INSTANCE.getMainFrame(), "Diese Spalte ist schon voll!");
		}
		return spielstein;
	}

	public void isGewinnt(Spielstein spielstein) throws Exception {
		if (spielstein != null) {
			String gewinner = SpielController.INSTANCE.isGewinnt(spielstein);
			int option = -1;
			if (gewinner != null) {
				Object[] options = { "Noch mal", "Start Menü" };
				option = JOptionPane.showOptionDialog(MainFrame.INSTANCE.getMainFrame(), gewinner, "Game Over",
						JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[1]);
				if (option == 0) {
					GUIController.INSTANCE.toSpiel(0, 0);
				} else {
					GUIController.INSTANCE.toStart();
				}
			}
//			else{
//				System.out.println("xxx");
//				isGewinnt(SpielController.INSTANCE.steinfallen(2));
//			}
		}
	}
	
	public void stepBack() {
		try {
			SpielController.INSTANCE.stepBack();
		} catch (StepBackException e) {
			JOptionPane.showMessageDialog(MainFrame.INSTANCE.getMainFrame(), "Es gibt keinen Stein auf dem Spielbrett!");
		}
	}
	
	public void giveUp() throws Exception {
		String gewinner = SpielController.INSTANCE.giveUp();
		int option = -1;

		if (gewinner != null) {
			Object[] options = { "Noch mal", "Start Menü" };
			option = JOptionPane.showOptionDialog(MainFrame.INSTANCE.getMainFrame(), gewinner, "Game Over",
					JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[1]);
			if (option == 0) {
				GUIController.INSTANCE.toSpiel(0, 0);
			} else {
				GUIController.INSTANCE.toStart();
			}
		}
	}

	public void addObserver(Observer o) {
		SpielController.INSTANCE.addObsever(o);
	}

}
