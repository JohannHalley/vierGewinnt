package controller;

import java.util.Observer;
import model.Spiel;
import model.Spielbrett;
import model.Spielstein;
import view.ColorEnum;

enum RichtungEnum {
	OBENDIA(-1, 1), UNTENDIA(1, 1), UNTEN(1, 0), WAAGERECHT(0, 1);
	private int dRow;
	private int dCol;

	private RichtungEnum(int dRow, int dCol) {
		this.dRow = dRow;
		this.dCol = dCol;
	}

	public int getdCol() {
		return dCol;
	}

	public int getdRow() {
		return dRow;
	}

}

public enum SpielController {
	INSTANCE();
	private Spiel spiel = null;

	public void setSpielPara(int stufe, int folge) {
		spiel = new Spiel(stufe, folge);
	}

	public void addObsever(Observer o) {
		spiel.addObserver(o);
	}

	/**
	 * macht nichts, nur ein mal setChanged() und notifyObservers() aufrufen.
	 * 
	 * @param stufe
	 * @param folge
	 * @throws Exception 
	 */
	public void showInPanel() throws Exception {
		if(spiel.getFolge() == 1) {
			steinfallen(2);
		}
		spiel.change();
	}
	
	public void steinfallenComputer(int stufe) {
		
	}

	public Spielstein steinfallen(int n) throws VollException {
		Spielstein spielstein = null;
		Spielbrett spielbrett = new Spielbrett(spiel.getletztSpielbrett());

		if (!spielbrett.getSpielsteins()[n].isEmpty()) {
			throw new VollException();
		} else {
			// den ersten freien Spielstein zu suchen
			int i = 5;
			for (; !spielbrett.getSpielsteins()[i * 7 + n].isEmpty(); i--) {
			}
			spielstein = spielbrett.getSpielsteins()[i * 7 + n];
			spielstein.setColor(spielbrett.getNextColor());

			spielbrett.setNextColor();
			spiel.addSpielbrett(spielbrett);

			spielbrett = new Spielbrett(spiel.getletztSpielbrett());
		}

		return spielstein;
	}

	/**
	 * 
	 * @return die gewonnene Farge
	 */
	public String isGewinnt(Spielstein spielstein) {
		String gewinner = null;
		Spielbrett spielbrett = spiel.getletztSpielbrett();

		if (spiel.getSpielbretts().size() < 7)
			return null;

		if (beideSeitenSuchen(spielbrett, spielstein, RichtungEnum.UNTEN)
				|| beideSeitenSuchen(spielbrett, spielstein, RichtungEnum.UNTENDIA)
				|| beideSeitenSuchen(spielbrett, spielstein, RichtungEnum.OBENDIA)
				|| beideSeitenSuchen(spielbrett, spielstein, RichtungEnum.WAAGERECHT)) {
			gewinner = spielstein.getColor().toString();
		}

		return gewinner;
	}

	private boolean beideSeitenSuchen(Spielbrett spielbrett, Spielstein spielstein, RichtungEnum r) {
		return eineSeiteSuchen(spielbrett, spielstein, r, 1) + eineSeiteSuchen(spielbrett, spielstein, r, -1) - 2 > 2;
	}

	private int eineSeiteSuchen(Spielbrett spielbrett, Spielstein spielstein, RichtungEnum r, int n) {
		int m = 0;
		int i = spielstein.getRow();
		int j = spielstein.getCol();
		ColorEnum color = spielstein.getColor();

		do {
			m++;
			i -= n * r.getdRow();
			j -= n * r.getdCol();
		} while (i >= 0 && j >= 0 && i <= 5 && j <= 6
				&& spielbrett.getSpielsteins()[7 * i + j].getColor().equals(color));
		return m;
	}

	public void stepBack() throws StepBackException {
		spiel.deleteSpielbrett();
	}

	public String giveUp() {
		String winner = (spiel.getletztSpielbrett().getNextColor() == ColorEnum.Red ? ColorEnum.Orange.toString() : ColorEnum.Red.toString());
		
		return winner;
	}

}
