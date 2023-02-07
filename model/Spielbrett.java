package model;

import view.ColorEnum;

public class Spielbrett {
	private Spielstein spielsteins[] = null;
	private ColorEnum nextColor = ColorEnum.Red;
	
	public Spielbrett() {
		this(null);
	}
	
	public Spielbrett(Spielbrett spielbrett) {
		spielsteins = new Spielstein[42];
		for (int i = 0; i < 42; i++) {
			spielsteins[i] = new Spielstein();
			spielsteins[i].setRow(i / 7);
			spielsteins[i].setCol(i % 7);
			if (spielbrett != null) {
				spielsteins[i].setColor(spielbrett.getSpielsteins()[i].getColor());
			} else {
				spielsteins[i].setColor(ColorEnum.Gray);
			}
		}
		if (spielbrett != null) {
			nextColor = spielbrett.getNextColor();
		}
	}

	public Spielstein[] getSpielsteins() {
		return spielsteins;
	}
	
	public ColorEnum getNextColor() {
		return nextColor;
	}
	
	public void setNextColor() {
		nextColor = (nextColor == ColorEnum.Red ? ColorEnum.Orange : ColorEnum.Red);
	}

	@Override
	public String toString() {
		String s = "[";
		
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 7; j++) {
				s += (spielsteins[7*i+j].getColor() + " ");
			}
			if(i != 5) {
				s+="\n";				
			}
		}
		
		return s+"]";
	}
	
	
}
