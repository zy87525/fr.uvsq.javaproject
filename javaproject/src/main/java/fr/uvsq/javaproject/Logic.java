package fr.uvsq.javaproject;

import java.io.InputStream;
import java.util.Iterator;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.util.FileManager;

public class Logic {
	
	public void readRDF(RDF rdf){
		
		Tuple tuple;
		// cr閑r un mod鑜e vide
		Model model = ModelFactory.createDefaultModel();
		
		// utiliser le FileManager pour trouver le fichier d'entr閑
		InputStream inputFileName = FileManager.get().open(rdf.getFileName());
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
            
            rdf.add(tuple);            
           
		}
		
		for(Tuple t:rdf.tuple){

			 System.out.print(t.getRessource().toString());
	         System.out.print(" " + t.getPredicat().toString() + " ");
	         if (t.getNode() instanceof Resource) {
	             System.out.print(t.getNode().toString()+"zebi");
	         } else {
	             // object is a literal
	             System.out.print(" \"" + t.getNode().toString() + "\"");
	         }
	         System.out.println(" .");
		}
	}
}
