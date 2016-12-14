package test;

import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;

public class MyJtable extends JTable {
	@Override
	public void valueChanged(ListSelectionEvent e) {
		super.valueChanged(e);
		Object source = e.getSource();
	}
}
