package view;

import java.awt.Color;

public enum ColorEnum {
    Gray(new Color(153,153,153)),Red(new Color(212,48,48)),Orange(new Color(255,141,26));
    private Color color;
	
	private ColorEnum(Color c) {
		this.color = c;
	}
	
	public Color getColor() {
		return color;
	}
	
}
