package view;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class TableauModele extends AbstractTableModel{
	private Object[][] data;
	private String[] title;
	public TableauModele(Object[][] donnees, String[] entete){
		this.data = donnees;
		this.title = entete;
	}
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.title.length;
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.data.length;
	}
	@Override
	public Object getValueAt(int ligne, int colonne) {
		// TODO Auto-generated method stub
		return this.data[ligne][colonne];
	}
	
}
