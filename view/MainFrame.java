package view;

import javax.swing.JFrame;

import view.panel.MainPanel;

public enum MainFrame{
	INSTANCE;
	private JFrame mainFrame = new JFrame("Vier Gewinnt");
	
	public JFrame getMainFrame() {
		return mainFrame;
	}

	public void init() {
		mainFrame.setSize(700, 335);
		
		MainPanel.INSTANCE.init();
		
		mainFrame.getContentPane().add(MainPanel.INSTANCE.getMainPanel());
		mainFrame.setVisible(true);
	}
	
	public static void main(String[] args) {
		MainFrame.INSTANCE.init();
	}
}
