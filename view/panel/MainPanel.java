package view.panel;

import javax.swing.JPanel;
import java.awt.CardLayout;

public enum MainPanel {
	INSTANCE;
	private JPanel mainPanel= new JPanel();
	private CardLayout panels = new CardLayout();

	public void init() {
		mainPanel.setLayout(panels);
		StartPanel.INSTANCE.init();
		SpielPanel.INSTANCE.init();
		mainPanel.add("start", StartPanel.INSTANCE.getPanel());
		mainPanel.add("spiel", SpielPanel.INSTANCE.getPanel());
		panels.show(mainPanel, "start");
	}
	
	public void show(String string) {
		panels.show(mainPanel, string);
	}

	public JPanel getMainPanel() {
		return mainPanel;
	}
	
}
