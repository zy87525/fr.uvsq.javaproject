package fr.uvsq.javaproject;

import java.io.InputStream;
import java.io.PrintStream;

import com.hp.hpl.jena.datatypes.xsd.XSDDatatype;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.util.FileManager;
import com.hp.hpl.jena.vocabulary.VCARD;

public class read {

	public static void main(String[] args) {
		/*
		 * // cr閑r un mod鑜e vide Model model =
		 * ModelFactory.createDefaultModel(); String inputFileName = "all2.rdf";
		 * // utiliser le FileManager pour trouver le fichier d'entr閑
		 * InputStream in = FileManager.get().open(inputFileName ); if (in ==
		 * null) { throw new IllegalArgumentException("Fichier: " +
		 * inputFileName + " non trouv�"); } // lire le fichier RDF/XML
		 * model.read(in, null); //model.write(System.out,"N-TRIPLE");
		 * StmtIterator iter = model.listStatements(); while (iter.hasNext()) {
		 * Statement stmt = iter.nextStatement(); // get next statement Resource
		 * subject = stmt.getSubject(); // get the subject Property predicate =
		 * stmt.getPredicate(); // get the predicate RDFNode object =
		 * stmt.getObject(); // get the object
		 * 
		 * System.out.print(subject.toString()); System.out.print(" " +
		 * predicate.toString() + " "); if (object instanceof Resource) {
		 * System.out.print(object.toString()+"zebi"); } else { // object is a
		 * literal System.out.print(" \"" + object.toString() + "\""); }
		 * System.out.println(" ."); }
		 */

		RDF rdf = new RDF("all2.rdf");
		Logic lc = new Logic();
		lc.readRDF(rdf);
	}
}
