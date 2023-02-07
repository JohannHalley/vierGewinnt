package view.panel;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.GUIController;
import view.MainFrame;

public enum StartPanel{
	INSTANCE;
	private JPanel panel= new JPanel();
	
	public JPanel getPanel() {
		return panel;
	}

	public void init() {
		JLabel t = new JLabel("Vier Gewinn");
		JButton pvp = new JButton("PvP");
		JButton pvc = new JButton("PvC");
		JButton abbrechen = new JButton("Abbrechen");
		
		panel.setSize(300, 500);
		panel.setLayout(new GridLayout(4,1));
		panel.setBackground(new Color(42,108,228));
		
		Color c = new Color(42,92,228);
		pvp.setBackground(c);
		pvc.setBackground(c);
		abbrechen.setBackground(c);
		
		pvp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					GUIController.INSTANCE.toSpiel(0,0);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		pvc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Object[] stufeOptions = { "Leicht", "Mittelmäßig", "Schwer", "Abbrechen"};
				int stufe = JOptionPane.showOptionDialog(MainFrame.INSTANCE.getMainFrame(), "Wählen Sie eine Stufe:", "Game Over",
						JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, stufeOptions, stufeOptions[3]);
				if(stufe == 3 || stufe == -1) {
					GUIController.INSTANCE.toStart();					
				}else {
					Object[] folgeOptions = { "Erste", "Zweite", "Abbrechen"};
					int folge = JOptionPane.showOptionDialog(MainFrame.INSTANCE.getMainFrame(), "Wählen Sie eine Folge", "Game Over",
							JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, folgeOptions, folgeOptions[2]);
					
					if(folge == 2 || folge == -1) {
						GUIController.INSTANCE.toStart();											
					}else {						
						try {
							GUIController.INSTANCE.toSpiel(stufe, folge);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}				
					}
				}
				
			}
		});
		
		abbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				GUIController.INSTANCE.toStufe();
			}
		});
		
		panel.add(t);
		panel.add(pvp);
		panel.add(pvc);
		panel.add(abbrechen);
	}
	
}
