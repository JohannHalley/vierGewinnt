package view.panel;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

import controller.GUIController;
import controller.ViewController;
import view.JSpielbrett;


public enum SpielPanel{
	INSTANCE;

	private JPanel panel = new JPanel();
	private JSpielbrett jspielbrett = new JSpielbrett();
	
	public JPanel getPanel() {
		return panel;
	}

	public JSpielbrett getJspielbrett() {
		return jspielbrett;
	}
	
	public void init(){
		JButton neuStart = new JButton("Nee Starten");
		JButton zurücknehmen = new JButton("Zurücknehmen");
		JButton aufgeben = new JButton("Aufgeben");
		JButton abbrechen = new JButton("Abbrechen");
		JPanel buttonPanel = new JPanel();
		Color c = new Color(42,92,228);
		
		panel.setLayout(new GridLayout(1,2));
		panel.setBackground(new Color(42,108,228));
		panel.add(jspielbrett);
		
		neuStart.setSize(70, 75);
		zurücknehmen.setSize(70, 75);
		aufgeben.setSize(70, 75);
		abbrechen.setSize(70, 75);

		
		neuStart.setBackground(c);
		zurücknehmen.setBackground(c);
		aufgeben.setBackground(c);
		abbrechen.setBackground(c);
		
		neuStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					GUIController.INSTANCE.toSpiel(0, 0);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				};
			}
		});
		
		zurücknehmen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewController.INSTANCE.stepBack();
			}
		});
		
		aufgeben.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ViewController.INSTANCE.giveUp();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		abbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GUIController.INSTANCE.toStart();
			}
		});
		
		
		buttonPanel.setLayout(new GridLayout(4,1));
		buttonPanel.add(neuStart);
		buttonPanel.add(zurücknehmen);
		buttonPanel.add(aufgeben);
		buttonPanel.add(abbrechen);
		
		panel.add(buttonPanel);
	}

}
