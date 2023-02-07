package controller;

import view.panel.MainPanel;
import view.panel.SpielPanel;

public enum GUIController {
	INSTANCE;

	public void toStart() {
		MainPanel.INSTANCE.show("start");
	}

	public void toSpiel(int stufe, int folge) throws Exception {
		SpielController.INSTANCE.setSpielPara(stufe, folge);
		ViewController.INSTANCE.addObserver(SpielPanel.INSTANCE.getJspielbrett());

		// Fuer erste paint(), müssen ein mal setChanged() und notifyObservers()
		// aufgerufen werden.
		SpielController.INSTANCE.showInPanel();
		MainPanel.INSTANCE.show("spiel");
	}
}
