package fr.uvsq.javaproject;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Interface {

	private JTable table;
	private JButton launch;
	private JFrame frame;
	
	public Interface(){
		
		frame = new JFrame();
		this.launch = new JButton();
        launch.setText("Launch");
        launch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	launch_btActionPerformed(evt);
            }
        });
		
        this.table = new JTable();
		this.table.setPreferredScrollableViewportSize(new Dimension(850, 600));
		this.frame.getContentPane().add(new JScrollPane(this.table) , BorderLayout.CENTER);
		this.frame.getContentPane().add(new JScrollPane(launch), BorderLayout.NORTH);
		this.frame.setTitle("RDF");
		this.frame.pack();
		this.frame.setVisible(true);
		this.frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	private void readRdf(String chemain){
		RDF rdf = new RDF(chemain);
		MyTable mt = new MyTable(rdf);
		this.table.setModel(mt);
		this.frame.pack();
	}
	
	private void launch_btActionPerformed(java.awt.event.ActionEvent evt)  {  
			JFileChooser chooser = new JFileChooser();
		    FileNameExtensionFilter filter = new FileNameExtensionFilter("RDF", "rdf");
		    chooser.setFileFilter(filter);
		    int returnVal = chooser.showOpenDialog(null);
		    if(returnVal == JFileChooser.APPROVE_OPTION) {
		       System.out.println("You chose to open this file: " + chooser.getSelectedFile().getPath());
		       readRdf(chooser.getSelectedFile().getPath());
		    }
	 }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//RDF rdf = new RDF("all2.rdf");
		new Interface();
	}

}
