package model;

import view.ColorEnum;

public class Spielstein {
	private ColorEnum color = ColorEnum.Gray;
	private int row;
	private int col;
	
	public Spielstein() {
	}
//	red.setCol(e.getX() / 50);

	public Spielstein(ColorEnum color, int row, int col) {
		super();
		this.color = color;
		this.row = row;
		this.col = col;
	}
	
	public boolean isEmpty() {
		return color == ColorEnum.Gray;
	}

	public ColorEnum getColor() {
		return color;
	}
	public void setColor(ColorEnum color) {
		this.color = color;
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
}
