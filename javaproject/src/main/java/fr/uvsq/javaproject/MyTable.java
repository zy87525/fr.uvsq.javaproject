package fr.uvsq.javaproject;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class MyTable extends AbstractTableModel {
	/*
	 * Object[][] p = { { "阿呆", new Integer(66), new Boolean(false) }, { "阿瓜",
	 * new Integer(85), new Boolean(false) }, };
	 */
	Object[][] p;
	String[] n = { "Resource", "Predicat", "Object" };

	public MyTable(RDF rdf) {
		p = rdf.getTupleArray();
	}

	public int getColumnCount() {
		return n.length;
	}

	public int getRowCount() {
		return p.length;
	}

	public String getColumnName(int col) {
		return n[col];
	}

	public Object getValueAt(int row, int col) {
		return p[row][col];
	}

	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
}
