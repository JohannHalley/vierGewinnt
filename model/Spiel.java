package model;

import java.util.ArrayList;
import java.util.Observable;

import controller.StepBackException;

public class Spiel extends Observable {
	private ArrayList<Spielbrett> spielbretts = new ArrayList<Spielbrett>();
	private int stufe = 0;
	private int folge = 0;

	public Spiel(int stufe, int folge) {
		spielbretts.add(new Spielbrett());
		this.stufe = stufe;
		this.setFolge(folge);
	}

	public void addSpielbrett(Spielbrett spielbrett) {
		spielbretts.add(spielbrett);
		setChanged();
		notifyObservers();
	}

	public void deleteSpielbrett() throws StepBackException {
		if(spielbretts.size() == 1) {
			throw new StepBackException();
		}
		spielbretts.remove(getletztSpielbrett());
		setChanged();
		notifyObservers();
	}

	public ArrayList<Spielbrett> getSpielbretts() {
		return spielbretts;
	}

	public Spielbrett getletztSpielbrett() {
		return spielbretts.get(spielbretts.size() - 1);
	}

	public void change() {
		setChanged();
		notifyObservers();
	}

	@Override
	public String toString() {
		String s = "";

		for (Spielbrett temp : spielbretts) {
			s += (temp.toString() + "\n");
		}
		return s + "\n\n\n";
	}

	public int getStufe() {
		return stufe;
	}

	public void setPara(int stufe, int folge) {
		this.stufe = stufe;
		this.setFolge(folge);
	}

	public int getFolge() {
		return folge;
	}

	public void setFolge(int folge) {
		this.folge = folge;
	}
}
