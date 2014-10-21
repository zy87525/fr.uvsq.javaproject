package fr.uvsq.javaproject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.util.FileManager;

public class RDF {
	private String FileName;
	List<Tuple> tuple = new ArrayList<Tuple>();

	public RDF(String fileName) {
		this.setFileName(fileName);
		Tuple tuple;
		Model model = ModelFactory.createDefaultModel();
		
		// utiliser le FileManager pour trouver le fichier d'entr閑
		InputStream inputFileName = FileManager.get().open(this.getFileName());
		if (inputFileName == null) {
		    throw new IllegalArgumentException("Fichier: " + inputFileName + " non trouv�");
		}
		
		model.read(inputFileName,null);		
		
        StmtIterator iter = model.listStatements();
		while (iter.hasNext()) {
			// get next statement
            Statement stmt      = iter.nextStatement();
            
			tuple = new Tuple();
            // get the subject
			tuple.setRessource(stmt.getSubject()); 
            tuple.setPredicat(stmt.getPredicate()); // get the predicate
            tuple.setNode(stmt.getObject());    // get the object
            
            this.add(tuple);            
           
		}
	}

	public Object[][] getTupleArray() {
		Object[][] tArray = new Object[this.tuple.size()][3];
		int i = 0;
		for (Tuple t : this.tuple) {
			tArray[i][0] = t.getRessource();
			tArray[i][1] = t.getPredicat().getLocalName();
			tArray[i][2] = t.getNode();
			i++;
		}
		return tArray;
	}

	public RDF() {
	}

	public String getFileName() {
		return FileName;
	}

	public void setFileName(String fileName) {
		this.FileName = fileName;
	}

	public void add(Tuple tuple) {
		this.tuple.add(tuple);
	}
}
